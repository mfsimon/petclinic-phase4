package com.example.petclinic.controller;

import com.example.petclinic.model.Pet;
import com.example.petclinic.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController implements BasicController<Pet> {

    private PetService petService;

    public PetController(PetService petService) {

        this.petService = petService;
    }

    @Override
    @PostMapping(value = "addPet", produces = "application/json")
    public Pet add(@RequestBody Pet pet) {

        return this.petService.add(pet);
    }

    @Override
    @GetMapping(value = "getById/{id}", produces = "application/json")
    public Pet get(@PathVariable("id") Long id) {

        // Demonstrates exception handling with ResponseStatusException exception
        Pet pet = null;
        try {
            pet = this.petService.get(id);
        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Pet [" + id + "] Not Found", exc);
        }
        return pet;
    }

    @Override
    @PutMapping(value = "updatePet", produces = "application/json")
    public Pet modify(@RequestBody Pet pet) {

        return this.petService.modify(pet);
    }

    @Override
    @RequestMapping(value = "deletePet", method = {RequestMethod.DELETE}, produces = "application/json")
    public boolean delete(@RequestBody Pet pet) {

        return this.petService.delete(pet);
    }

    @Override
    @GetMapping(value = "getAllPets", produces = "application/json")
    public List<Pet> getAll() {

        List<Pet> all = this.petService.getAll();
        return all;
    }

}
