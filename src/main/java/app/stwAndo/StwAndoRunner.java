package app.stwAndo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import app.stwAndo.service.StwAndoService;

import java.util.stream.IntStream;


@Order(1)
@Component
public class StwAndoRunner implements CommandLineRunner {

    private static Logger LOGGER = LogManager.getLogger(StwAndoRunner.class);

    @Value("${stwando.iteration.start}")
    private Integer start;

    @Value("${stwando.iteration.end}")
    private Integer end;

    @Autowired
    private StwAndoService service;

    @Override
    public void run(String... args) throws Exception {
        IntStream.range(start, end).forEach( i ->
            LOGGER.info(service.buildStwAndo(i))
        );
    }
}
