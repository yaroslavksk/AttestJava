package ToyStore.model;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository {
    private ToyMapper mapper = new ToyMapper();
    private FileOperation fileOperation;

    public RepositoryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Toy> getAllToys() {
        List<String> lines = fileOperation.readAllLines();
        List<Toy> toys = new ArrayList<>();
        try {
            for (String line : lines) {
                toys.add(mapper.map(line));
            }
        } catch (Exception e) {
        }
        
        return toys;
    }

    @Override
    public String CreateToy(Toy toy) {

        List<Toy> toys = getAllToys();
        int max = 0;
        for (Toy item : toys) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        toy.setId(id);
        toys.add(toy);
        List<String> lines = new ArrayList<>();
        for (Toy item: toys) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
        return id;
    }

    @Override
    public String DeleteToy(String id){
        List<Toy> toys = getAllToys();
        int thisToy =  Integer.parseInt(id);
        if (thisToy == 0 || thisToy > toys.size()) return null; 
        toys.remove(thisToy-1);
        List<String> lines = new ArrayList<>();
        for (Toy item: toys) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
        return null;
    }
}