package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
   //     List<Double> result = Function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
   //     assertThat(result, is(expected));
    }
}