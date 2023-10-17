package toyshop.strategy;

import toyshop.model.Toy;

import java.util.*;

public class WeightedToySelectionStrategy implements ToySelectionStrategy{

    //region Public Methods
    @Override
    public Toy selectToy(List<Toy> toyList) {
        int totalWeight = calculateTotalWeight(toyList);
        double totalCumulativeWeight = 0;

        if (totalWeight == 0){
            return null;
        }

        for (Toy toy: toyList){
            double toyCumulativeWeight = calculateCumulativeWeight(toy, totalWeight);
            toy.setCumulativeWeight(toyCumulativeWeight);
            totalCumulativeWeight += toy.getCumulativeWeight() * toy.getQuantity();
        }

        // Для проверки на условие берем за максимум рассчитанный вес первой игрушки
        Toy toyWithMaxCumulativeWeight = toyList.get(0);

        for (Toy toy: toyList){
            if (toy.getCumulativeWeight() > toyWithMaxCumulativeWeight.getCumulativeWeight()){
                toyWithMaxCumulativeWeight = toy;
            }
        }

        double numChance = (double) (toyWithMaxCumulativeWeight.getCumulativeWeight() * toyWithMaxCumulativeWeight.getQuantity()) / (double) totalCumulativeWeight * 100.0;
        toyWithMaxCumulativeWeight.setNumChanceToBeGiven(numChance);
        return toyWithMaxCumulativeWeight;
    }
    //endregion

    //region Private Methods
    private int calculateTotalWeight(List<Toy> toyList){
        int totalWeight = 0;

        for (Toy toy: toyList){
            totalWeight += toy.getQuantity() * toy.getWeight();
        }
        return totalWeight;
    }

    private double calculateCumulativeWeight(Toy toy, int totalWeight){
        return (double) (toy.getWeight() * toy.getQuantity() * new Random().nextInt(1, 10)) / totalWeight;
    }
    //endregion
}
