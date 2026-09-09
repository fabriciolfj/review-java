package com.github.fabriciolfj.review.controller;

import com.github.fabriciolfj.review.model.Person;
import com.github.fabriciolfj.review.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.github.fabriciolfj.review.util.ScopeValues.CORRELATION_ID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/persons")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public void createPerson(@RequestBody final Person person) {
        ScopedValue.where(CORRELATION_ID, UUID.randomUUID().toString()).run(() -> {
            personService.save(person);
        });
    }
}
