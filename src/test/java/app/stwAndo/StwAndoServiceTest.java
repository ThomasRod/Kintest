package app.stwAndo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import app.stwAndo.service.impl.StwAndoServiceImpl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StwAndoServiceTest {

    @InjectMocks
    private StwAndoServiceImpl service;

    @Test
    public void display_multiple_of_3_test() {
        assertThat(service.buildStwAndo(3), equalTo("Stw"));
    }

    @Test
    public void display_multiple_of_5_test() {
        assertThat(service.buildStwAndo(5), equalTo("Ando"));
    }

    @Test
    public void display_multiple_of_3_and_5_test() {
        assertThat(service.buildStwAndo(45), equalTo("StwAndo"));
    }
}
