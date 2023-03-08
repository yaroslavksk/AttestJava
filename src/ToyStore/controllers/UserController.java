package ToyStore.controllers;

import java.util.List;

import ToyStore.model.Repository;
import ToyStore.model.Toy;

public class UserController {

    private final Repository repository;

    public UserController(Repository repository) {
        this.repository = repository;
    }

    public void saveToy(Toy user) {
        repository.CreateToy(user);
    }

    public void deleteToy(String id){
        repository.DeleteToy(id);
    }

    public boolean prizeToy(String Fid){

        List<Toy> toys = repository.getAllToys();
        for (Toy toy : toys) {
            if (toy.getId().equals(Fid)) {
                int percent = Integer.parseInt(toy.getPercent());
                int rnd = (int)(Math.random()* 100);
                if ((rnd <= percent) && (rnd >= 0)){
                    return true;
                }
            }
        }
        return false;
        
    }

    public Toy readToy(String FindId) throws Exception {
        List<Toy> toys = repository.getAllToys();
        for (Toy toy : toys) {
            if (toy.getId().equals(FindId)) {
                return toy;
            }
        }

        throw new Exception("Toy not found");
    }
}
