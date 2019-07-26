package com.example.petclinic;

import com.example.petclinic.controller.OwnerController;
import com.example.petclinic.controller.PetController;
import com.example.petclinic.controller.VetController;
import com.example.petclinic.controller.VisitController;
import com.example.petclinic.model.*;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PetClinicDriver implements ExitCodeGenerator {

    private static ConfigurableApplicationContext context;

    private static OwnerController ownerController;
    private static PetController petController;
    private static VisitController visitController;
    private static VetController vetController;

    public static void main(String[] args) {

        // We'll need a reference to the Spring IoC container (it's context).
        context = SpringApplication.run(PetClinicDriver.class, args);

        testApp();

        // Lets sleep for a day
        System.out.println("Zzzz...");
        try {
            Thread.sleep(86400000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // part of exit code implementation
        System.exit(SpringApplication.exit(context));

    }

    private static void testApp() {

        System.out.println();

        // Need a reference to the OwnerController to run our tests.
        // We use the context to retrieve managed beans by name.
        // The name of the bean is the type of bean (it's name) in camelcase, with the first letter lowercase (by default).
        ownerController = (OwnerController) context.getBean("ownerController");
        petController = (PetController) context.getBean("petController");
        visitController = (VisitController) context.getBean("visitController");
        vetController = (VetController) context.getBean("vetController");

        // Create Owners
        Owner owner1 = Owner.builder().withName("Homer Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        Owner owner2 = Owner.builder().withName("Marge Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        Owner owner3 = Owner.builder().withName("Bart Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        Owner owner4 = Owner.builder().withName("Lisa Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();

        // Add Owners
        ownerController.add(owner1);
        ownerController.add(owner2);
        ownerController.add(owner3);
        ownerController.add(owner4);

        display(ownerController.getAll());

        // Create Pets

        // Pets for Homer
        Pet pet1 = Pet.builder().withName("Strangles").withBirthDate(new Date()).withPetType(PetType.SNAKE).withOwner(owner1).build();
        Pet pet2 = Pet.builder().withName("Mojo").withBirthDate(new Date()).withPetType(PetType.MONKEY).withOwner(owner1).build();
        Pet pet3 = Pet.builder().withName("Pinchy").withBirthDate(new Date()).withPetType(PetType.LOBSTER).withOwner(owner1).build();
        Pet pet4 = Pet.builder().withName("Plopper").withBirthDate(new Date()).withPetType(PetType.PIG).withOwner(owner1).build();

        // Pets for Marge
        Pet pet5 = Pet.builder().withName("Greyhound").withBirthDate(new Date()).withPetType(PetType.DOG).withOwner(owner2).build();

        // Pets for Bart
        Pet pet6 = Pet.builder().withName("Laddie").withBirthDate(new Date()).withPetType(PetType.DOG).withOwner(owner3).build();
        Pet pet7 = Pet.builder().withName("Santa's Little Helper").withBirthDate(new Date()).withPetType(PetType.DOG).withOwner(owner3).build();
        Pet pet8 = Pet.builder().withName("Stampy").withBirthDate(new Date()).withPetType(PetType.ELEPHANT).withOwner(owner3).build();
        Pet pet9 = Pet.builder().withName("Duncan").withBirthDate(new Date()).withPetType(PetType.HORSE).withOwner(owner3).build();


        // Pets for Lisa
        Pet pet10 = Pet.builder().withName("Nibbles").withBirthDate(new Date()).withPetType(PetType.HAMPSTER).withOwner(owner4).build();
        Pet pet11 = Pet.builder().withName("Chirpy Boy").withBirthDate(new Date()).withPetType(PetType.LIZARD).withOwner(owner4).build();
        Pet pet12 = Pet.builder().withName("Bart Junior").withBirthDate(new Date()).withPetType(PetType.LIZARD).withOwner(owner4).build();
        Pet pet13 = Pet.builder().withName("Snowball IV").withBirthDate(new Date()).withPetType(PetType.CAT).withOwner(owner4).build();
        Pet pet14 = Pet.builder().withName("Princess").withBirthDate(new Date()).withPetType(PetType.HORSE).withOwner(owner4).build();

        petController.add(pet1);
        petController.add(pet2);
        petController.add(pet3);
        petController.add(pet4);
        petController.add(pet5);
        petController.add(pet6);
        petController.add(pet7);
        petController.add(pet8);
        petController.add(pet9);
        petController.add(pet10);
        petController.add(pet11);
        petController.add(pet12);
        petController.add(pet13);
        petController.add(pet14);

        display(petController.getAll());

        owner1.addPet(pet10);
        ownerController.modify(owner1);

        // Create Visit
        Visit visit1 = Visit.builder().withDateOfVisit(new Date()).withDescription("Nice Visit!").withPet(pet1).build();
        Visit visit2 = Visit.builder().withDateOfVisit(new Date()).withDescription("Bad Visit!").withPet(pet2).build();
        Visit visit3 = Visit.builder().withDateOfVisit(new Date()).withDescription("Bad Visit!").withPet(pet3).build();
        Visit visit4 = Visit.builder().withDateOfVisit(new Date()).withDescription("Bad Visit!").withPet(pet3).build();

        visitController.add(visit1);
        visitController.add(visit2);
        visitController.add(visit3);
        visitController.add(visit4);

        System.out.println("\n ***** Visits ***** \n");
        display(visitController.getAll());

        // ***** Vet *****
        Vet vet1 = Vet.builder().withName("SuperVet").withSpeciality(Speciality.DENTISTRY).withSpeciality(Speciality.DENTISTRY).withSpeciality(Speciality.SURGERY).withVisit(visit1).build();
        Vet vet2 = Vet.builder().withName("SuperDuperVet").withSpeciality(Speciality.DENTISTRY).withSpeciality(Speciality.SURGERY).withSpeciality(Speciality.RADIOLOGY).withVisit(visit1).build();
        Vet vet3 = Vet.builder().withName("OutstandingVet").withSpeciality(Speciality.DENTISTRY).withSpeciality(Speciality.SURGERY).withVisit(visit4).withVisit(visit3).withVisit(visit2).build();

        vetController.add(vet1);
        vetController.add(vet2);
        vetController.add(vet3);

        visitController.modify(visit1);
        visitController.modify(visit2);
        visitController.modify(visit3);
        visitController.modify(visit4);

        System.out.println("\n ***** Vets ***** \n");
        display(vetController.getAll());

        System.out.println("Done with tests!");
    }

    private static void display(Object obj) {

        if (obj instanceof List) {

            List<?> list = (List) obj;
            for (Object o : list) {
                System.out.println("\t" + o);
            }

        } else {

            System.out.println(obj);

        }

        System.out.println();
    }

    @Override
    public int getExitCode() {
        return 42;
    }
}
