package com.example.petclinic.controller;

import com.example.petclinic.model.Owner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OwnerControllerIntegrationTests implements ApplicationContextAware {

    private static ApplicationContext context;
    private static OwnerController controller;

    private static Owner owner1;
    private static Owner owner2;
    private static Owner owner3;
    private static Owner owner4;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        context = applicationContext;
    }

    @Before
    public void setup() {

        owner1 = Owner.builder().withId(1L).withName("Homer Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        owner2 = Owner.builder().withId(2L).withName("Marge Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        owner3 = Owner.builder().withId(3L).withName("Bart Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        owner4 = Owner.builder().withId(4L).withName("Lisa Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        controller = (OwnerController) context.getBean("ownerController");
    }

    @Test
    public void saveAndFindOwner() {

        // exercise
        controller.add(owner1);
        Owner actual = controller.get(1L);

        // assert
        assertEquals(owner1, actual);

    }

    @Test
    public void saveAndModify() {

        // exercise
        controller.add(owner1);
        Owner actual = controller.get(1L);

        // assert
        assertEquals(owner1, actual);

        // exercise
        String expectedName = "Homer";
        owner1.setName(expectedName);
        controller.add(owner1);
        actual = controller.get(1L);

        // assert
        assertEquals(owner1, actual);

        String actualName = owner1.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void saveAndDeleteOwner() {

        // exercise
        controller.add(owner1);
        Owner actual = controller.get(1L);

        // assert
        assertEquals(owner1, actual);

        // exercise
        controller.delete(owner1);
        actual = controller.get(1L);

        // assert
        assertNull(actual);

    }

    @Test
    public void findAllOwners() {

        // exercise
        controller.add(owner1);
        controller.add(owner2);
        controller.add(owner3);
        controller.add(owner4);

        int actual = controller.getAll().size();

        // assert
        assertEquals(4, actual);
    }


}