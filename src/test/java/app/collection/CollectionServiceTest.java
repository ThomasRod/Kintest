package app.collection;

import app.collection.service.impl.CollectionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectionServiceTest {

    @InjectMocks
    private CollectionServiceImpl service;

    @Test
    public void nominal_test() {

        List<Integer> l1 = Arrays.asList(12, 6, 8);
        List<Integer> l2 = Arrays.asList(23, 11, 32);

        Set<Integer> mergedAndOrdered = service.mergedAndOrderedCollectionsWithFilter(l1, l2, 5);
        assertThat(mergedAndOrdered, hasSize(6));
        assertThat(mergedAndOrdered, contains(32, 23, 12, 11, 8, 6));
    }

    @Test
    public void elements_smaller_than_5_test() {

        List<Integer> l1 = Arrays.asList(12, 6, 3, 8);
        List<Integer> l2 = Arrays.asList(23, 2, 11, 1, 32);

        Set<Integer> mergedAndOrdered = service.mergedAndOrderedCollectionsWithFilter(l1, l2, 5);
        assertThat(mergedAndOrdered, hasSize(6));
        assertThat(mergedAndOrdered, contains(32, 23, 12, 11, 8, 6));
    }

    @Test
    public void doublon_test() {

        List<Integer> l1 = Arrays.asList(12, 6, 8, 6);
        List<Integer> l2 = Arrays.asList(23, 23, 11, 32);

        Set<Integer> mergedAndOrdered = service.mergedAndOrderedCollectionsWithFilter(l1, l2, 5);
        assertThat(mergedAndOrdered, hasSize(6));
        assertThat(mergedAndOrdered, contains(32, 23, 12, 11, 8, 6));
    }

    @Test
    public void elements_smaller_than_5_and_doublon_test() {

        List<Integer> l1 = Arrays.asList(12, 6, 3, 8, 8);
        List<Integer> l2 = Arrays.asList(23, 23, 1, 11, 32);

        Set<Integer> mergedAndOrdered = service.mergedAndOrderedCollectionsWithFilter(l1, l2, 5);
        assertThat(mergedAndOrdered, hasSize(6));
        assertThat(mergedAndOrdered, contains(32, 23, 12, 11, 8, 6));
    }
}
