package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    void compareJobAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("One", 1),
                new Job("Two", 2),
                new Job("Three", 3)
        );
        List<Job> expected = Arrays.asList(
                new Job("One", 1),
                new Job("Three", 3),
                new Job("Two", 2)
        );
        jobs.sort(new JobAscByName());
        assertEquals(expected, jobs);
    }

    @Test
    void compareJobAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Three", 3),
                new Job("Two", 2),
                new Job("One", 1)
        );
        List<Job> expected = Arrays.asList(
                new Job("One", 1),
                new Job("Two", 2),
                new Job("Three", 3)
        );
        jobs.sort(new JobAscByPriority());
        assertEquals(expected, jobs);
    }

    @Test
    void compareJobDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Three", 3),
                new Job("Two", 2),
                new Job("Five", 5)
        );
        List<Job> expected = Arrays.asList(
                new Job("Two", 2),
                new Job("Three", 3),
                new Job("Five", 5)
        );
        jobs.sort(new JobDescByName());
        assertEquals(expected, jobs);
    }

    @Test
    void compareJobDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Three", 3),
                new Job("Two", 2),
                new Job("Five", 5)
        );
        List<Job> expected = Arrays.asList(
                new Job("Five", 5),
                new Job("Three", 3),
                new Job("Two", 2)
        );
        jobs.sort(new JobDescByPriority());
        assertEquals(expected, jobs);
    }

    @Test
    public void compareDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority =
                new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void compareAscByNameAndPriority() {
        Comparator<Job> cmpNamePriority =
                new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void compareAscByNameAndDescByPriority() {
        Comparator<Job> cmpNamePriority =
                new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isLessThan(2);
    }
}