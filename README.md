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

###### Bonus Activity 1 (easy)
* Switch the `\get` endpoint(s) to use a @PathVariable instead of a @RequestParam by referencing the tutorial below.
* [Spring @RequestParam Annotation](https://www.baeldung.com/spring-request-param)

###### Bonus Activity 2 (medium)
* Add exception handling to your REST service by referencing the tutorial below.
* [Error Handling for REST with Spring](https://www.baeldung.com/exception-handling-for-rest-with-spring)

###### Bonus Activity 3 (hard)
* Create a custom White Label error page in your REST service by referencing the tutorial below.
* [Customize Whitelabel Error Page](https://www.baeldung.com/spring-boot-custom-error-page)

#### Notes
* Dependencies have already been added for you in the pom.xml file for this phase.  You shouldn't have to modify or add anything to your build file (pom.xml), but feel free to as needed.
* We are NOT creating a front end for this application.  The `PetClinicDriver` acts as the front end (or view) for this application. Feel free to add to the driver as needed.
