package com.Elgaddari;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.Test;

public class PersonServiceTest {

    @Test
    public void testFilterByAddress() {
        List<Person> peopleLivingInF1 = PersonService.filterByAddress("F1");

        List<Person> expectedPeopleLivingInF1 = Arrays.asList(
                Person.builder().firstName("abdeljabbar").familyName("elgaddari").birthDate(LocalDate.of(2004, 4, 5))
                        .address("F1").build(),
                Person.builder().firstName("hamza").familyName("chleih").birthDate(LocalDate.of(2003, 10, 15))
                        .address("F1").build());

        assertThat(peopleLivingInF1).containsExactlyInAnyOrderElementsOf(expectedPeopleLivingInF1);
    }

    @Test
    public void testFilterAdults() {
        List<Person> adultPersons = PersonService.filterAdults();

        List<Person> expectedAdultPersons = Arrays.asList(
                Person.builder().firstName("abdeljabbar").familyName("elgaddari")
                        .birthDate(LocalDate.of(2004, 4, 5))
                        .address("F1").build(),
                Person.builder().firstName("hamza").familyName("chleih")
                        .birthDate(LocalDate.of(2003, 10, 15))
                        .address("F1").build());

        assertThat(adultPersons).containsExactlyInAnyOrderElementsOf(expectedAdultPersons);
    }

    @Test
    public void testRemoveAdisonWithoutIterator() {
        assertThatThrownBy(() -> PersonService.removeAdisonWithoutIterator())
                .isInstanceOf(ConcurrentModificationException.class);
    }

    @Test
    public void testRemoveAdisonUsingIterator() {
        Set<Person> expectedPeopleWithoutAdison = new HashSet<>();
        expectedPeopleWithoutAdison.add(Person.builder().firstName("abdeljabbar").familyName("elgaddari").build());
        expectedPeopleWithoutAdison.add(Person.builder().firstName("hamza").familyName("chleih").build());

        Set<Person> peopleWithoutAdison = PersonService.removeAdisonUsingIterator();

        assertThat(peopleWithoutAdison).containsExactlyInAnyOrderElementsOf(expectedPeopleWithoutAdison);
    }

    @Test
    public void testSortPeople() {
        List<Person> expectedPeople = new ArrayList<>();
        expectedPeople.add(Person.builder().firstName("abdellah").familyName("adison").build());
        expectedPeople.add(Person.builder().firstName("abdeljabbar").familyName("chleih").build());
        expectedPeople.add(Person.builder().firstName("hamza").familyName("chleih").build());

        List<Person> peopleSorted = PersonService.SortPeople();

        assertThat(peopleSorted).isEqualTo(expectedPeople);

    }

    @Test
    public void testSortPeopleWithoutOrder() {
        List<Person> expectedPeople = new ArrayList<>();
        expectedPeople.add(Person.builder().firstName("abdellah").familyName("adison").build());
        expectedPeople.add(Person.builder().firstName("hamza").familyName("chleih").build());
        expectedPeople.add(Person.builder().firstName("abdeljabbar").familyName("chleih").build());


        List<Person> peopleSorted = PersonService.SortPeople();

        assertThat(peopleSorted).isEqualTo(expectedPeople);

    }
}
