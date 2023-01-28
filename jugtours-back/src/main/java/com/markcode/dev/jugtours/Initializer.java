package com.markcode.dev.jugtours;

import com.markcode.dev.jugtours.model.Event;
import com.markcode.dev.jugtours.model.Group;
import com.markcode.dev.jugtours.repository.GroupRepository;
import org.springframework.boot.CommandLineRunner;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

public class Initializer implements CommandLineRunner {

    private final GroupRepository repository;

    public Initializer(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Seattle JUG", "Denver JUG", "Dublin JUG",
                "London JUG").forEach(name ->
                repository.save(new Group(name))
        );

        Group djug = repository.findByName("Seattle JUG");
        Event e = Event.builder().title("Micro Frontends for Java Developers")
                .description("JHipster now has microfrontend support!")
                .date(Instant.parse("2022-09-13T17:00:00.000Z"))
                .build();
        djug.setEvents(Collections.singleton(e));
        repository.save(djug);

        repository.findAll().forEach(System.out::println);
    }


}
