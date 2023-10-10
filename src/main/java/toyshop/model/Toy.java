package toyshop.model;

public class Toy {
    //region Private Fields
    private int id;
    private String name;
    private int weight;
    //endregion

    //region Public Constructor
    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }
    //endregion
}
