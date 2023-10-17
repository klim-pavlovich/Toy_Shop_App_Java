package toyshop.model;

import toyshop.model.Toy;

import java.util.Comparator;

public class WeightedToyComparator implements Comparator<Toy> {
    /**
     * Сравнение игрушек по кумулятивному весу
     * @param toy1 the first object to be compared.
     * @param toy2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Toy toy1, Toy toy2) {
        // Сравниваем игрушки по кумулятивному весу в порядке убывания
        return Double.compare(toy2.getCumulativeWeight(), toy1.getCumulativeWeight());
    }
}