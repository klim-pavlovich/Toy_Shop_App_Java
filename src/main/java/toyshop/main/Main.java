package toyshop.main;
import toyshop.model.Toy;
import toyshop.model.ToyStore;
import toyshop.strategy.ToySelectionStrategy;
import toyshop.strategy.WeightedToySelectionStrategy;
public class Main {
    public static void main(String[] args) {
        ToySelectionStrategy strategy = new WeightedToySelectionStrategy();
        ToyStore toyStore = new ToyStore(strategy);

        toyStore.addToy(new Toy(1, "Кукла", 3, 5));
        toyStore.addToy(new Toy(2, "Робот", 5, 2));
        toyStore.addToy(new Toy(3,"Машинка",1,3));

        toyStore.selectToy();
        toyStore.getPrize();
        toyStore.selectToy();
        toyStore.getPrize();
        toyStore.selectToy();
        toyStore.getPrize();
        toyStore.selectToy();
        toyStore.selectToy();
        toyStore.selectToy();
        toyStore.selectToy();
        toyStore.selectToy();
        toyStore.selectToy();
        toyStore.selectToy();




        toyStore.getPrize();
        toyStore.getPrize();
        toyStore.getPrize();
        toyStore.getPrize();
        toyStore.getPrize();
        toyStore.getPrize();
        toyStore.getPrize();

        // Обработка пользовательских ошибок
        toyStore.selectToy(); // игрушек было добавлено всего 10
        toyStore.getPrize(); // игрушки для выдачи закончились, так как не удалось выбрать 11 игрушку
    }
}
