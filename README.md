## Spring Cloud Function POC

### Function Composition

This branch uses the showcases declarative function composition by adding `spring.cloud.function.definition` to the properties to  
compose different functions.

**Note:** Notice how the function declaration of `uppercase` has changed. Without a uniform function definitions such a function
composition is not possible

### Test this branch
* Composition function can be invoked at the root `curl -H "Content-Type: text/plain" localhost:8080/ -d 'Buckle. Before Anything Else'`
* Other functions can still be invoked from their relative paths
  * `curl -H "Content-Type: text/plain" localhost:8080/uppercase -d 'Buckle. Before Anything Else'`
  * `curl -H "Content-Type: text/plain" localhost:8080/reversestring -d 'Buckle. Before Anything Else'`


### Reference Documentation
[Function Composition](https://docs.spring.io/spring-cloud-function/docs/current/reference/html/spring-cloud-function.html#_function_composition)
