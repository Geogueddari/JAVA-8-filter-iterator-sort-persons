package com.Elgaddari;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class PersonTest {

    @Test
    public void testCalculateAge() {

        Person person = Person.builder()
                .firstName("abdeljabbar")
                .familyName("elgaddari")
                .birthDate(LocalDate.of(2004, 4, 5))
                .build();

        int expectedAge = LocalDate.now().getYear() - 2004;

        assertThat(person.calculateAge()).isEqualTo(expectedAge);
    }

    @Test
    public void testCompareToWithFirstName() {
        Person etudiantSig = Person.builder()
                .firstName("abdeljabbar")
                .familyName("elgaddari")
                .build();

        Person etudiantMeteo = Person.builder()
                .firstName("hamza")
                .familyName("chleih")
                .build();

        assertThat(etudiantSig.compareTo(etudiantMeteo)).isPositive();
        assertThat(etudiantMeteo.compareTo(etudiantSig)).isNegative();
    }

    @Test
    public void testCompareToWithFamilyName() {
        Person etudiantMeteo = Person.builder()
                .firstName("hamza")
                .familyName("chleih")
                .build();

        Person etudiantIhe = Person.builder()
                .firstName("youssef")
                .familyName("chleih")
                .build();

        assertThat(etudiantMeteo.compareTo(etudiantIhe)).isNegative();
        assertThat(etudiantIhe.compareTo(etudiantMeteo)).isPositive();
    }

    @Test
    public void testEqualsAndHashCode() {
        Person expertLinux = Person.builder()
                .firstName("abdeljabbar")
                .familyName("elgaddari")
                .birthDate(LocalDate.of(2004, 4, 5))
                .address("F13")
                .build();

        Person expertDebian = Person.builder()
                .firstName("abdeljabbar")
                .familyName("elgaddari")
                .birthDate(LocalDate.of(2004, 4, 5))
                .address("F13")
                .build();

        assertThat(expertLinux).isEqualTo(expertDebian);
        assertThat(expertLinux.hashCode()).isEqualTo(expertDebian.hashCode());
    }

    @Test
    public void testToString() {
        Person person = Person.builder()
                .firstName("abdeljabbar")
                .familyName("elgaddari")
                .birthDate(LocalDate.of(2004, 4, 5))
                .address("F13")
                .build();

        assertThat(person.toString()).contains("abdeljabbar", "elgaddari", "2004-04-05", "F13");
    }
}
