package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {

    private List<Student> students = new ArrayList<>();

    @Before
    public void setUp() {
        students = List.of(
                new Student(10, "Surname1"),
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(60, "Surname6"),
                new Student(70, "Surname7"),
                new Student(80, "Surname8"),
                new Student(90, "Surname9")
        );
    }

    @Test
    public void whenCollectClassA() {
        School sc = new School();
        Predicate<Student> pr = (p) -> p.getScore() >= 70;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected = List.of(
                new Student(70, "Surname7"),
                new Student(80, "Surname8"),
                new Student(90, "Surname9")
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        School sc = new School();
        Predicate<Student> pr = (p) -> p.getScore() < 70 && p.getScore() >= 50;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected = List.of(
                new Student(50, "Surname5"),
                new Student(60, "Surname6")
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassC() {
        School sc = new School();
        Predicate<Student> pr = (p) -> p.getScore() < 50 && p.getScore() > 0;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected = List.of(
                new Student(10, "Surname1"),
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(40, "Surname4")
        );
        assertThat(rsl, is(expected));
    }
}