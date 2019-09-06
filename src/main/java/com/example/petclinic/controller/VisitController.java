package com.example.petclinic.controller;

import com.example.petclinic.model.Visit;
import com.example.petclinic.service.VisitService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/visit")
@JsonIgnoreProperties(ignoreUnknown = true)
public class VisitController implements BasicController<Visit> {

    private VisitService visitService;

    public VisitController(VisitService visitService) {

        this.visitService = visitService;
    }

    @Override
    @PostMapping(value = "addVisit", produces = "application/json")
    public Visit add(Visit visit) {

        return this.visitService.add(visit);
    }

    @Override
    @GetMapping(value = "getById/{id}", produces = "application/json")
    public Visit get(@PathVariable("id") Long id) {

        // Demonstrates exception handling with ResponseStatusException exception
        Visit visit = null;
        try {
            visit = this.visitService.get(id);
        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Visit [" + id + "] Not Found", exc);
        }
        return visit;
    }

    @Override
    @PutMapping(value = "updateVisit", produces = "application/json")
    public Visit modify(@RequestBody Visit visit) {

        return this.visitService.modify(visit);
    }

    @Override
    @RequestMapping(value = "deleteVisit", method = {RequestMethod.DELETE}, produces = "application/json")
    public boolean delete(@RequestBody Visit visit) {

        return this.visitService.delete(visit);
    }

    @Override
    @GetMapping(value = "getAllVisits", produces = "application/json")
    public List<Visit> getAll() {

        List<Visit> all = this.visitService.getAll();
        return all;

    }
}
