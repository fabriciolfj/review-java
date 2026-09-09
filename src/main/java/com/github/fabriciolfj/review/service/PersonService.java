package com.github.fabriciolfj.review.service;

import com.github.fabriciolfj.review.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.github.fabriciolfj.review.util.ScopeValues.CORRELATION_ID;

@Slf4j
@Service
public class PersonService {

    public void save(final Person person) {

        log.info("person saved {}, correlationId {}", person.name(), CORRELATION_ID.get());
    }
}
