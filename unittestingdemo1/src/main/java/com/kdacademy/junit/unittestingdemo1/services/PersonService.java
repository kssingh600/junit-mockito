package com.kdacademy.junit.unittestingdemo1.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.kdacademy.junit.unittestingdemo1.entities.Person;
import com.kdacademy.junit.unittestingdemo1.repo.PersonRepo;

@Service
public class PersonService {

    private PersonRepo repo;

    public PersonService(PersonRepo repo) {
        this.repo = repo;
    }

    public List<Person> getAllPerson() {
        return this.repo.findAll();
    }

}
