package ToyStore.model;

import java.util.List;

public interface Repository {
    List<Toy> getAllToys();
    String CreateToy(Toy toy);
    String DeleteToy (String id);
}
