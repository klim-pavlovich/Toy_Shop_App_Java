package toyshop.strategy;

import toyshop.model.Toy;

import java.util.List;

public interface ToySelectionStrategy {
    Toy selectToy(List<Toy> toyList);
}
