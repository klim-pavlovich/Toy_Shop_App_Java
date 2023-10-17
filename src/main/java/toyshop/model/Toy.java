package toyshop.model;

public class Toy {
    //region Private Fields
    private int id;
    private String name;
    private int weight;

    private int quantity;

    private double cumulativeWeight;

    public double getNumChanceToBeGiven() {
        return numChanceToBeGiven;
    }

    private double numChanceToBeGiven;

    public void setNumChanceToBeGiven(double numChanceToBeGiven) {
        this.numChanceToBeGiven = numChanceToBeGiven;
    }

    //endregion

    //region Public Constructor
    public Toy(int id, String name, int weight, int quantity) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.quantity = quantity;
    }
    //endregion

    //region Private Constructor

    /**
     * Конструктор для копирования игрушки
     * @param id идентификатор
     * @param name имя
     * @param weight вероятность
     * @param cumulativeWeight кумулятивная вероятность
     * @param numChanceToBeGiven шанс в процентах
     * @param quantity количество
     */
    private Toy(int id, String name, int weight, double cumulativeWeight, double numChanceToBeGiven, int quantity) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.quantity = quantity;
        this.cumulativeWeight = cumulativeWeight;
        this.numChanceToBeGiven = numChanceToBeGiven;
    }
    //endregion

    //region Protected Helpers for Store

    /**
     * Метод получения копии игрушки, но с количеством 1 для добавления в выдачу в качестве приза.
     * @param toy игрушка для копии
     * @return новую игрушку с количеством 1.
     */
    protected Toy getCopiedToyWithOneQuantity(Toy toy){
        return new Toy(toy.id, toy.name, toy.weight, toy.cumulativeWeight, toy.numChanceToBeGiven, 1);
    }

    /**
     * Метод уменьшения количества игрушки на 1
     */
    protected void decreaseQuantity(){
        if (this.quantity < 1){
            return;
        }
        this.quantity = this.quantity-1;
    }
    //endregion

    //region Public Getters and Setters
    public int getQuantity() {
        return quantity;
    }
    public int getWeight() {
        return weight;
    }

    public String getName(){
        return name;
    }
    public double getCumulativeWeight(){return cumulativeWeight;}
    public void setCumulativeWeight(double cumulativeWeight) {
        this.cumulativeWeight = cumulativeWeight;
    }
    //endregion
}
