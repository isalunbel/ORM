package org.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;

public class CustomerId implements Serializable {
    private String name;
    private String surname;
    private int age;

    public CustomerId() {
    }

    public CustomerId(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerId that = (CustomerId) o;
        return age == that.age && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}
