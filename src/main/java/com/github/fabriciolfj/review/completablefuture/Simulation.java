package com.github.fabriciolfj.review.completablefuture;

import com.github.fabriciolfj.review.model.Person;
import lombok.SneakyThrows;

import java.util.Random;
import java.util.random.RandomGenerator;

import static java.util.concurrent.StructuredTaskScope.Joiner.awaitAll;
import static java.util.concurrent.StructuredTaskScope.open;

public class Simulation {

    private static final Random RANDOM = Random.from(RandomGenerator.getDefault());

    @SneakyThrows
    void main() {
        final var person = new Person("fabricio", "test");
        try(var scope = open(awaitAll())) {
            scope.fork(() -> sendEmail(person));
            scope.fork(() -> sendSms(person));

            scope.join();
        }
    }

    public void sendEmail(final Person person) {
        try {
            Thread.sleep(RANDOM.nextInt(0, 19999));
            IO.println("send email to " + person.name());
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void sendSms(final Person person)  {
        try {
            Thread.sleep(RANDOM.nextLong(1000, 90000));
            IO.println("send sms to " + person.name());
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
