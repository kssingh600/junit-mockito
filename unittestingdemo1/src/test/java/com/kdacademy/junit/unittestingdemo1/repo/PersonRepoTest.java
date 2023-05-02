package com.kdacademy.junit.unittestingdemo1.repo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kdacademy.junit.unittestingdemo1.entities.Person;
import static org. assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PersonRepoTest {

    @Autowired
    private PersonRepo personRepo ;
 
    @Test
    void testIsPersonExitsById() {
        Person person = new Person(2, "Kuldeep", "Paris") ;
        personRepo.save(person) ;
        Boolean actualResult = personRepo.isPersonExitsById(person.getPersonId()) ;
        assertThat(actualResult).isTrue();
    }

    @BeforeEach
    void setUp(){
        System.out.println("Setting up");
    }

    @AfterEach
    void tearDown(){
        System.out.println("tearing down") ;
        personRepo.deleteAll();
    }
}
