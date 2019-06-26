# PetClinic Phase 4

#### Overview
In this phase of the project, we convert the code from phase 3 to a RESTful service using Spring REST services. 

[PetClinic Reference Application](http://petclinic.cognizantacademy.com)


#### What You Are Given
* Code for the controllers - `BasicController`, `OwnerController`, `PetController`, `VisitController`, `VetController`
* Code for the services - `BasicService`, `OwnerService`, `PetService`, `VisitService`, `VetService`
* Code for the repositories - `OwnerRepository`, `PetRepository`, `VisitRepository`, `VetRepository`
* Code for the models - `Owner`, `Pet`, `PetType`, `Visit`, `Vet` and `Speciality`
* A driver class - `PetClinicDriver`

#### What You Need To Complete
* Modify each of your child Controller classes to implement REST endpoints for each of the methods.
* Each controller will have it's own base URL.
* Each method within each controller will follow the same naming convention for endpoints.
- `\add`
- `\get`
- `\change`
- `\remove`
- `\getall`

* Each endpoint will use a @RequestParam to receive data from Postman.

###### Frameworks Used
* Spring
* Spring Boot
* Spring Data JPA
* Hibernate
* Spring REST

###### Spring Annotations Used
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

###### Activity 1
##### Building a REST Client
* Complete the tutorial at:
* [Building a REST Client](https://spring.io/guides/gs/consuming-rest/)

###### Activity 2
##### Building a REST Server
* Complete the tutorial at:
* [Building a REST Server](https://spring.io/guides/gs/rest-service/)

###### Activity 3
##### Building Out Our REST Server
* Using the existing website as a guide, identify endpoints you may need in the UI.
* Modify your existing controllers to implement endpoints identified.
* Test your endpoints with Postman
* Test your endpoints with your REST client.  (You'll need to add some data models to get this to work.)

###### Bonus Activity 1 (medium)
##### Exception Handling
* Add exception handling to your REST service by referencing the tutorial below.
* [Error Handling for REST with Spring](https://www.baeldung.com/exception-handling-for-rest-with-spring)

###### Bonus Activity 2 (hard)
##### Custom White Label Page
* Create a custom White Label error page in your REST service by referencing the tutorial below.
* [Customize Whitelabel Error Page](https://www.baeldung.com/spring-boot-custom-error-page)

###### Bonus Activity 3 (nightmare)
##### Adding a Bit of Swagger
* Add Swagger documentation to your REST service by completing the following tutorial:
* [Adding Swagger 2 to Your RESTful Service](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)

#### Notes
* Dependencies have already been added for you in the pom.xml file for this phase.  You shouldn't have to modify or add anything to your build file (pom.xml), but feel free to as needed.

