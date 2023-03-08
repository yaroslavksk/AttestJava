package ToyStore.views;

import java.util.Scanner;

import ToyStore.controllers.UserController;
import ToyStore.model.Toy;

public class ViewUser {

    private UserController userController;

    public ViewUser(UserController userController) {
        this.userController = userController;
    }

    public void run(){
        Commands com = Commands.NONE;

        while (true) {
            String command = prompt("Введите команду: ");
            try {
                com = Commands.valueOf(command);
            } 
            catch (Exception e) {
                System.out.println("Команда не опознана!");
                run();
            }
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    String Name = prompt("Название: ");
                    Scanner in = new Scanner(System.in);
                    System.out.print("Введите шанс в %: ");
                    int num = in.nextInt();
                    String percent = Integer.toString(num);
                    userController.saveToy(new Toy(Name, percent));
                    break;
                case READ:
                    String id = prompt("Идентификатор игрушки: ");
                    try {
                        Toy toy = userController.readToy(id);
                        System.out.println(toy);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case PRIZE:
                    String Fid = prompt("Идентификатор разыгрываемой игрушки: ");
                    try {
                        Boolean result = userController.prizeToy(Fid);
                        System.out.println("Игрушка разыграна: " + result);
                        System.out.println("Если игрушка разыграна не забудте удалить игрушку!");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case DELETE:
                    String ID = prompt("Идентификатор игрушки: ");
                    try {
                        Toy toy = userController.readToy(ID);
                        System.out.println(toy);
                        userController.deleteToy(ID);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case EXIT:
                    break;
            default: break;
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
