package com.Elgaddari;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService {
    public static List<Person> filterByAddress(String address) {
        List<Person> mockPersonsDatabase = Arrays.asList(
                Person.builder().firstName("abdeljabbar").familyName("elgaddari").birthDate(LocalDate.of(2004, 4, 5))
                        .address("F1").build(),
                Person.builder().firstName("hamza").familyName("chleih").birthDate(LocalDate.of(2003, 10, 15))
                        .address("F1").build(),
                Person.builder().firstName("hassan").familyName("tijani").birthDate(LocalDate.of(1985, 3, 9))
                        .address("TE").build());

        Predicate<Person> hasAddress = person -> person.getAddress().equals(address);

        return mockPersonsDatabase.stream()
                .filter(hasAddress)
                .collect(Collectors.toList());
    }
}
