package toyshop.model;
import toyshop.strategy.ToySelectionStrategy;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ToyStore{

    //region Private Fields
    private static List<Toy> toysInStore = new ArrayList<>();
    private static PriorityQueue<Toy> toysToGive = new PriorityQueue<>(new WeightedToyComparator());

    private ToySelectionStrategy strategy;
    //endregion

    //region Public Constructor
    public ToyStore(ToySelectionStrategy strategy) {
        this.strategy = strategy;
    }
    //endregion

    //region Public Methods

    /**
     * Добавить игрушку
     * @param toy игрушка для добавления
     */
    public void addToy(Toy toy) {
        toysInStore.add(toy);
    }

    /**
     * Выбор игрушки
     */
    public void selectToy(){
        if (toysInStore.size()==0){
            System.out.println("Игрушки в магазине закончились");
            return;
        }

        Toy selectedToy = strategy.selectToy(toysInStore);

        if (selectedToy.getQuantity() > 1){
            Toy toyToGive = selectedToy.getCopiedToyWithOneQuantity(selectedToy);
            toysToGive.add(toyToGive);
            selectedToy.decreaseQuantity();
            return;
        }
        toysInStore.remove(selectedToy);
        toysToGive.add(selectedToy);
    }

    /**
     * Получение приза
     */
    public void getPrize(){
        if (toysToGive.size()==0){
            System.out.println("Нет выбранных игрушек.");
            return;
        }
        Toy toyToGive = toysToGive.peek();

        try (FileWriter writer = new FileWriter("prize_toys.txt", true)){

            String toyInfo = "Вы выигрыли игрушку: " + toyToGive.getName() + " (Шанс получить данную игрушку составлял: " + toyToGive.getNumChanceToBeGiven() + "%)";
            toysToGive.remove();
            writer.write(toyInfo + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //endregion
}

