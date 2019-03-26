package app.zerosAndOnes;

import app.collection.CollectionRunner;
import app.collection.service.CollectionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Order(3)
@Component
public class ZerosAndOnesRunner implements CommandLineRunner {

    private static Logger LOGGER = LogManager.getLogger(ZerosAndOnesRunner.class);

    @Value("${zeros.and.ones.match}")
    private Integer match;

    @Autowired
    private CollectionService service;

    @Override
    public void run(String... args) throws Exception {
        List<Integer> l1 = Arrays.asList(0,1,0,1,0,1,1,1,0,1,0,1,0,0,0,1,1,1,0,1,0,1,1,1,0,1);
        List<Integer> l2 = Arrays.asList(1,1,1,0,1,0,0,0,1,1,0,1,0,0,1,0,0,1,0,0,0,0,1,0,1,0,0,0,0,1,0,1,0,1,0,1,0,0,0,0,1);
        LOGGER.info(service.countMatchNumberInTwoLists(l1, l2, 1));
    }
}
