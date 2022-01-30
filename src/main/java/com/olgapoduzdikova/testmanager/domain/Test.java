package com.olgapoduzdikova.testmanager.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tests")
@Getter
@Setter
@ToString
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tests_seq")
    @SequenceGenerator(name="tests_seq", sequenceName="tests_seq", allocationSize=1)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return id.equals(test.id) && name.equals(test.name) && status.equals(test.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status);
    }
}
