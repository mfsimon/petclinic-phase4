# PetClinic Phase 4

#### Overview
In this phase of the project, we convert the code from phase 3 to a RESTful service using Spring REST services. 

[PetClinic Reference Application](http://petclinic.cognizantacademy.com)


#### What You Are Given
* Completed code from phase 3.
* Completed code for the Owner sequence.

#### What You Need To Complete

##### Activity 1
###### Building a REST Server
* Complete the tutorial at:
* [Building a REST Server](https://spring.io/guides/gs/rest-service/)

##### Activity 2
###### Building a REST Client
* Complete the tutorial at:
* [Building a REST Client](https://spring.io/guides/gs/consuming-rest/)

##### Activity 3
###### Building Out Our REST Server
* Modify each of your Controller classes to implement REST endpoints for each of the standard CRUD methods.
* Each controller will have it's own base URL.
* Each method within each controller will follow the same naming convention for its endpoints.
  - `\add`
  - `\get`
  - `\update`
  - `\delete`
  - `\getall`
* Add any other endpoints as needed to match functionality of the reference website.  For instance, you may want to be able to get all visits for a specific pet, etc.  See the `OwnerController` for one example of a non-CRUD endpoint.
* You need to figure out the best way to pass information from Postman to your REST endpoints.  In other words, are you going to use a `@PathVariable` or `@RequestBody`.
* Test your endpoints with Postman

##### Activity 4
###### Infinite Recursion
* There's an issue with the way the JSON data is being marshalled.
* Look at the results when you navigate to `http://localhost:8080/owner/getAllOwners`
* This is caused by the infinitely recursive relationship between model objects.
* Research the `@JsonIgnoreProperties` annotation to see how this can be handled.
* Add the `@JsonIgnoreProperties` annotation to each model's association fields (the fields that relate to other model objects) with the proper attributes.
* See the Owner model for an example.

##### Activity 5
###### Playing With a REST Client
* Test your endpoints out with a REST client.
  - Download and use the following REST client:
  [Simple REST Client](https://github.com/AcademyNATrainers/petclinic-phase4-client)
 
* You'll have to modify your REST client code along with the RestTemplate and/or it's parameters to test each of the endpoints.
* You do NOT need to get all endpoints tested at the same time.  Test them one at a time by changing RestTemplate methods and/or parameters.
* You'll need to figure out which RestTemplate method is needed to test each endpoint.
  - [This](https://www.baeldung.com/rest-template) tutorial gives some more detailed info about how to use a RestTemplate.  
* Remember, there are more APIs to use with a RestTemplate than those shown.
  - [RestTemplate JavaDoc](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html)

#### Frameworks Used
* Spring
* Spring Boot
* Spring Data JPA
* Hibernate
* Spring REST

#### Spring Annotations Used
* @SpringBootApplication
* @RestController
* @Service
* @Entity
* @Table
* @Id
* @GeneratedValue
* @OneToMany
* @ManyToOne
* @JoinColumn
* @BodyMapping
* @GetMapping
* @PostMapping
* @ResponseBody
* @RequestMapping
* @RequestParam
* @PathVariable

#### Bonus Activities
##### Bonus Activity 1 (easy)
###### Adding a Bit of Swagger
* Add Swagger documentation to your REST service by completing the following tutorial:
* [Adding Swagger 2 to Your RESTful Service](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)

##### Bonus Activity 2 (medium)
###### Exception Handling
* Add exception handling to your REST service by referencing the tutorial below.
* [Error Handling for REST with Spring](https://www.baeldung.com/exception-handling-for-rest-with-spring)
* Try using solution 4 from the tutorial.  This is endpoint specific so you'll have to implement it in all of your endpoints.

##### Bonus Activity 3 (medium)
###### Custom White Label Page
* Create a custom White Label error page in your REST service by referencing the tutorial below.
* [Customize Whitelabel Error Page](https://www.baeldung.com/spring-boot-custom-error-page)

##### Bonus Activity 4 (hard)
###### Adding Spring Security
* Add Spring Security to your REST endpoints by uncommenting the Spring Security dependency in the POM.xml file.
* Add very simple Basic Authentication to your endpoints.
* [Spring Boot Security REST Basic Authentication Example](https://howtodoinjava.com/spring-boot2/security-rest-basic-auth-example/)
* [Spring Security Basic Authentication](https://www.baeldung.com/spring-security-basic-authentication)

#### Notes
* Dependencies have already been added for you in the pom.xml file for this phase.  You shouldn't have to modify or add anything to your build file (pom.xml), but feel free to as needed.

