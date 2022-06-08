## Spring Cloud Function POC

### Function Composition - 2

This is a different flavour to showcase function composition and will be used as baseline for AWS lambda implementation.

The case and reverse functions have been implemented as a spring component which now can be autowired into the main
class.
`CompositeFunction` uses the 2 to compose a complex function and it this function which has become a default definition
for this application.

In a nutshell, this implementation take the composition from properties file and puts in code as an example that more
complex
reactive programming can be implemented using `java.util.Function` type.

**Note:** Few curious observations, also noted in official documentations

1. When Functions are implemented as a separate component, Spring Serverless will try to scan the packages and create a
   function bean
2. Above is true only when there is only ONE component. In this example, it is important to autowire both components
   because
   framework will not be able to create bean and no function will be exposed.
3. Consumer and Supplier types can be implemented in a similar fashion with reactive types

### Test this branch

* `CompositeFunction` can be invoked at the
  root `curl -H "Content-Type: text/plain" localhost:8080/ -d 'Buckle. Before Anything Else'`
* Other functions can still be invoked from their relative paths
    * `curl -H "Content-Type: text/plain" localhost:8080/uppercase -d 'Buckle. Before Anything Else'`
    * `curl -H "Content-Type: text/plain" localhost:8080/reversestring -d 'Buckle. Before Anything Else'`

### Reference Documentation

[Main dependencies and basic structure](https://www.baeldung.com/spring-cloud-function)

[Basic Function Examples](https://mkyong.com/java8/java-8-function-examples/)

[AWS Lambda context](https://stackoverflow.com/questions/53452675/multiple-spring-cloud-functions-in-one-project-for-deployment-on-aws-lambda)
