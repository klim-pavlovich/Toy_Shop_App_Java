package toyshop.strategy;

import toyshop.model.Toy;

import java.util.List;
import java.util.PriorityQueue;

public interface ToySelectionStrategy {
    Toy selectToy(List<Toy> toyList);
}
