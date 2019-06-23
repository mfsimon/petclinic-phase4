package com.example.petclinic.repository;

import com.example.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    public List<Owner> getOwnerByName();

}
