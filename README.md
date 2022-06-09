## Spring Cloud Function POC

### AWS Lambda Ready

Building upon func-composition-2, a locally workable Cloud Function, this branch makes the implementation
_workable_ as an AWS lambda function. There are no code changes in this branch; instead all the changes are in
build.gradle.

Compiling this application will produce 2 jar files:

* spring-cf-0.0.1-SNAPSHOT.jar
* spring-cf-0.0.1-SNAPSHOT-lambda.jar

The second jar comes with whichever postfix we define in `archiveClassifier` in build.gradle (#74).

_It is this second file which is uploaded to AWS lambda environment._ Notice the difference in the size of both JAR
files.

**Salient Features:**

1. Making this function compatible with AWS Lambda environment requires **no** java code changes are required and the SpringBoot
   application remains _cloud-agnostic_
2. This is made possible by the latest spring-cloud-function-adapter-aws dependency; simply set the handler as
   `org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest`, and let the framework do the rest
3. Even though this application has multiple functions, AWS Lambda can execute only function, which is defined in our
   properties file `spring.cloud.function.definition`. This is also
   noted [here](https://docs.spring.io/spring-cloud-function/docs/current/reference/html/aws.html#_aws_request_handlers)
   .
4. Since AWS needs a shaded jar to run, this is done by using gradle plugins `com.github.johnrengelman.shadow`
   and `org.springframework.boot.experimental.thin-launcher`

**Caution:**
As of writing of this readme, the build script repositories and classpath dependencies are _**incorrect**_ in official
documentations.
The correct integration is described [here](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow), and same
are implemented in this POC.

The source of this confusion is (I think) is rooted in the namespace updated made my the owner of the plugin, somewhere
around v5.x.x.

### Test this branch

* AWS Lambda function is deployed in dataluss-np account, function name spring-cf. This function is also exposed using
  function URL
  - `curl --location --request GET 'https://klej3attpxuzdjtbncxb36q2y40jkpgf.lambda-url.us-west-2.on.aws/' \
  --header 'Content-Type: text/plain' \
  --data-raw '"Buckle. Before Anything Else"'`

* Other functions can still be invoked from their relative paths
    * CompositeFunction `curl -H "Content-Type: text/plain" localhost:8080/ -d 'Buckle. Before Anything Else'`
    * Upper Case `curl -H "Content-Type: text/plain" localhost:8080/uppercase -d 'Buckle. Before Anything Else'`
    * Reverse String `curl -H "Content-Type: text/plain" localhost:8080/reversestring -d 'Buckle. Before Anything Else'`

### Reference Documentation

[Official Spring AWS Lambda Documentation](https://docs.spring.io/spring-cloud-function/docs/current/reference/html/aws.html)

[SpringBoot Thin Launcher](https://github.com/spring-projects-experimental/spring-boot-thin-launcher)

[**Working** Shade Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
