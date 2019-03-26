package app.collection.service.impl;

import app.collection.service.CollectionService;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CollectionServiceImpl implements CollectionService {

    @Override
    public Set<Integer> mergedAndOrderedCollectionsWithFilter(Collection<Integer> l1, Collection<Integer> l2, Integer filtered) {

        return Stream.of(l1, l2).flatMap(Collection::stream)
                .collect(Collectors.toList())
                .stream().filter(i -> i > filtered)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public Long countMatchNumberInTwoLists(List<Integer> l1, List<Integer> l2, Integer match) {

        return Stream.of(l1, l2)
                .flatMap(List::stream)
                .filter(i -> i.equals(match))
                .count();
    }
}
