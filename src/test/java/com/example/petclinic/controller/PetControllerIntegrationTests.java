package com.example.petclinic.controller;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Pet;
import com.example.petclinic.model.PetType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PetControllerIntegrationTests implements ApplicationContextAware {

    private static ApplicationContext context;
    private static PetController controller;

    private static Pet pet1;
    private static Pet pet2;
    private static Pet pet3;
    private static Pet pet4;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        context = applicationContext;
    }

    @Before
    public void setup() {

        pet1 = Pet.builder().withId(1L).withName("Strangles").withBirthDate(new Date()).withPetType(PetType.SNAKE).build();
        pet2 = Pet.builder().withId(2L).withName("Mojo").withBirthDate(new Date()).withPetType(PetType.MONKEY).build();
        pet3 = Pet.builder().withId(3L).withName("Pinchy").withBirthDate(new Date()).withPetType(PetType.LOBSTER).build();
        pet4 = Pet.builder().withId(4L).withName("Plopper").withBirthDate(new Date()).withPetType(PetType.PIG).build();
        controller = (PetController) context.getBean("petController");
    }

    @Test
    public void saveAndFindPet() {

        // exercise
        controller.add(pet1);
        Pet actual = controller.get(1L);

        // assert
        assertEquals(pet1, actual);
    }

    @Test
    public void saveAndModifyPet() {

    }

    @Test
    public void saveAndDeletePet() {

    }

    @Test
    public void findAllPets() {

    }


}