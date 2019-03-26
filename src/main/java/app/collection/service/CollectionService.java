package app.collection.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface CollectionService {

    /**
     * Merged two list :
     * with no duplicates
     * with only number > filtered number
     * Ordered by greatest to smallest
     *
     * @param l1
     * @param l2
     * @param filtered
     * @return Set
     */
    Set<Integer> mergedAndOrderedCollectionsWithFilter(Collection<Integer> l1, Collection<Integer> l2, Integer filtered);

    /**
     *
     *
     * @return
     */
    Long countMatchNumberInTwoLists(List<Integer> l1, List<Integer> l2, Integer toCount);

}
