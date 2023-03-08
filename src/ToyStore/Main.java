package ToyStore;

import ToyStore.controllers.UserController;
import ToyStore.model.FileOperation;
import ToyStore.model.FileOperationImpl;
import ToyStore.model.Repository;
import ToyStore.model.RepositoryFile;
import ToyStore.views.ViewUser;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("toys.txt");
        Repository repository = new RepositoryFile(fileOperation);
        UserController controller = new UserController(repository);
        ViewUser view = new ViewUser(controller);
        view.run();
    }
}
