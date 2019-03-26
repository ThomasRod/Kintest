package app.collection;

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

@Order(2)
@Component
public class CollectionRunner implements CommandLineRunner {

    private static Logger LOGGER = LogManager.getLogger(CollectionRunner.class);

    @Autowired
    private CollectionService service;

    @Value("${collection.filtered}")
    private Integer filtered;

    @Override
    public void run(String... args) throws Exception {
        List<Integer> l1 = Arrays.asList(1, 2, 6, 6, 8, 9);
        List<Integer> l2 = Arrays.asList(9, 7, 9, 4, 10, 15, 10);
        LOGGER.info(service.mergedAndOrderedCollectionsWithFilter(l1, l2, filtered).toString());
    }
}
