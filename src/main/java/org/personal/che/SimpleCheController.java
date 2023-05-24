package org.personal.che;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/people")
public class SimpleCheController {

    @Inject
    EntityManager em;


    @GetMapping("/{name}/{firstname}")
    @Transactional
    public String persistPeople(@PathVariable(name = "name") String name, @PathVariable(name = "firstname") String firstname) {
        People entity1 = new People();
        entity1.name = name;
        entity1.firstname = firstname;
        em.persist(entity1);
        return name + " " + firstname + " persisted";
    }
}
