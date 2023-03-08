package ToyStore.model;

public class Toy {
    private String id = "";
    private String Name;
    private String Percent;

    public Toy(String Name, String Percent) {
        this.Name = Name;
        this.Percent = Percent;
    }

    public Toy(String id, String Name, String Percent) {
        this(Name, Percent);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPercent() {
        return Percent;
    }

    public void setPercent(String Percent) {
        this.Percent = Percent;
    }

    @Override
    public String toString() {
        return String.format("Идентификатор: %s\n Имя: %s,\n Шанс: %s", id, Name, Percent + "%");
    }
}
