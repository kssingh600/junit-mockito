package com.kdacademy.junit.unittestingdemo1.services;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kdacademy.junit.unittestingdemo1.repo.PersonRepo;

// @ExtendWith(MockitoExtension.class) we can use AutoCloseable instead
public class PersonServiceTest {

    @Mock
    private PersonRepo personRepo ;

    private PersonService personService ;

    AutoCloseable autoCloseable ;

    @Test
    void testGetAllPerson() {
        personService.getAllPerson() ;
        verify(personRepo).findAll() ;
    }

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this) ;
        this.personService = new PersonService(personRepo) ;
    }

    @AfterEach
    void tearDown(){
        try {
            this.autoCloseable.close() ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
