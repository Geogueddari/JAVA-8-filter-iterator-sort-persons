package com.Elgaddari;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService {
        public static List<Person> filterByAddress(String address) {
                List<Person> mockPersonsDatabase = Arrays.asList(
                                Person.builder().firstName("abdeljabbar").familyName("elgaddari")
                                                .birthDate(LocalDate.of(2004, 4, 5))
                                                .address("F1").build(),
                                Person.builder().firstName("hamza").familyName("chleih")
                                                .birthDate(LocalDate.of(2003, 10, 15))
                                                .address("F1").build(),
                                Person.builder().firstName("hassan").familyName("tijani")
                                                .birthDate(LocalDate.of(1985, 3, 9))
                                                .address("TE").build());

                Predicate<Person> hasAddress = person -> person.getAddress().equals(address);

                return mockPersonsDatabase.stream()
                                .filter(hasAddress)
                                .collect(Collectors.toList());
        }

        public static List<Person> filterAdults() {
                List<Person> mockPersonsDatabase = Arrays.asList(
                                Person.builder().firstName("abdeljabbar").familyName("elgaddari")
                                                .birthDate(LocalDate.of(2004, 4, 5))
                                                .address("F1").build(),
                                Person.builder().firstName("hamza").familyName("chleih")
                                                .birthDate(LocalDate.of(2003, 10, 15))
                                                .address("F1").build(),
                                Person.builder().firstName("adam").familyName("zouani")
                                                .birthDate(LocalDate.of(2008, 3, 9))
                                                .address("ET5").build());

                Predicate<Person> isAdult = person -> person.calculateAge() >= 18;

                return mockPersonsDatabase.stream()
                                .filter(isAdult)
                                .collect(Collectors.toList());
        }

        public static Set<Person> removeAdisonWithoutIterator() {
                Set<Person> people = new HashSet<>();
                people.add(Person.builder().firstName("abdeljabbar").familyName("elgaddari").build());
                people.add(Person.builder().firstName("abdellah").familyName("adison").build());
                people.add(Person.builder().firstName("hamza").familyName("chleih").build());

                for (Person person : people) {
                        if (person.getFamilyName().equals("adison")) {
                                people.remove(person); // concurrentModificationException
                        }
                }
                return people;
        }

        public static Set<Person> removeAdisonUsingIterator() {
                Set<Person> people = new HashSet<>();
                people.add(Person.builder().firstName("abdeljabbar").familyName("elgaddari").build());
                people.add(Person.builder().firstName("abdellah").familyName("adison").build());
                people.add(Person.builder().firstName("hamza").familyName("chleih").build());

                Iterator<Person> iterator = people.iterator();
                while (iterator.hasNext()) {
                        Person person = iterator.next();
                        if (person.getFamilyName().equals("adison")) {
                                iterator.remove(); // Secured
                        }
                }
                return people;
        }

        public static List<Person> SortPeople() {
                List<Person> people = new ArrayList<>();
                people.add(Person.builder().firstName("abdeljabbar").familyName("chleih").build());
                people.add(Person.builder().firstName("abdellah").familyName("adison").build());
                people.add(Person.builder().firstName("hamza").familyName("chleih").build());

                Collections.sort(people);

                return people;
        }
}
