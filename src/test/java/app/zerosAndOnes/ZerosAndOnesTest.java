package app.zerosAndOnes;

import app.collection.service.impl.CollectionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZerosAndOnesTest {

    @InjectMocks
    private CollectionServiceImpl service;

    @Test
    public void nominal_test() {
        List<Integer> l1 = Arrays.asList(0, 1, 1, 0);
        List<Integer> l2 = Arrays.asList(0, 1, 1, 0, 0, 1, 1, 0);
        assertThat(service.countMatchNumberInTwoLists(l1, l2, 1), equalTo(6L));
    }

    @Test
    public void nominal_no_match() {
        List<Integer> l1 = Arrays.asList(0, 0, 0, 0);
        List<Integer> l2 = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0);
        assertThat(service.countMatchNumberInTwoLists(l1, l2, 1), equalTo(0L));
    }

    @Test
    public void nominal_list1_no_match() {
        List<Integer> l1 = Arrays.asList(0, 0, 0, 0);
        List<Integer> l2 = Arrays.asList(0, 1, 0, 0, 1, 0, 0, 1);
        assertThat(service.countMatchNumberInTwoLists(l1, l2, 1), equalTo(3L));
    }

    @Test
    public void nominal_list2_no_match() {
        List<Integer> l1 = Arrays.asList(0, 1, 0, 1);
        List<Integer> l2 = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0);
        assertThat(service.countMatchNumberInTwoLists(l1, l2, 1), equalTo(2L));
    }

}
