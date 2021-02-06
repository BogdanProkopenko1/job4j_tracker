package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobSortNameDown().thenComparing(new JobSortPriorityDown());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenPriorityUp() {
        Comparator<Job> sort = new JobSortPriorityUp();
        int rsl = sort.compare(
                new Job("Fps", 2),
                new Job("Fps", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenPriorityDown() {
        Comparator<Job> sort = new JobSortPriorityDown();
        int rsl = sort.compare(
                new Job("Homework", 0),
                new Job("Homework", 5)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenNameUp() {
        Comparator<Job> sort = new JobSortNameUp();
        int rsl = sort.compare(
                new Job("Eat", 3),
                new Job("Relax", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenNameDown() {
        Comparator<Job> sort = new JobSortNameDown();
        int rsl = sort.compare(
                new Job("Watch YT", 0),
                new Job("Watch TV", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenPriorityAndName() {
        Comparator<Job> sort = new JobSortPriorityUp().thenComparing(new JobSortNameDown());
        int rsl = sort.compare(
                new Job("Learn", 1),
                new Job("Relax", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}