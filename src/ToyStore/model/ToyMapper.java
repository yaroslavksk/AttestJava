package ToyStore.model;

public class ToyMapper {
    public String map(Toy toy) {
        return String.format("%s,%s,%s", toy.getId(), toy.getName(), toy.getPercent());
    }

    public Toy map(String line) {
        String[] lines = line.split(",");
        return new Toy(lines[0], lines[1], lines[2]);
    }
}