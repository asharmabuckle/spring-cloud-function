## Spring Cloud Function POC

This is the first branch to be referred.

### Basic Implementation

This is a basic implementation of Spring Cloud Functions created with most basic spring dependencies, yet it can be executed 
and debugged like a normal Spring application using any IDE. 

**Note** This is very simple a Springboot application to Start with. Take a look at the build.gradle file to understand the most common 
dependencies to start with, because these will evolve as we layer up this POC with different implementation and demo DB access from 
function and make it AWS Lambda compatible.

Sample functions are included inside the main SpringBootApplication class itself.  


### Test this branch
* The two functions can be invoked from their relative paths using below curl commands
    * `curl -H "Content-Type: text/plain" localhost:8080/uppercase -d 'Buckle. Before Anything Else'`
    * `curl -H "Content-Type: text/plain" localhost:8080/reversestring -d 'Buckle. Before Anything Else'`


### Reference Documentation
[Function Composition](https://docs.spring.io/spring-cloud-function/docs/current/reference/html/spring-cloud-function.html#_function_composition)
