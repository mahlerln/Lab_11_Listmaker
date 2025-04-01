import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMenu();
            String choice = SafeInput.getRegExString(scanner, "Enter a command: ", "[AaDdIiPpQq]");
            switch (choice.toLowerCase()) {
                case "a":
                    addItem();
                    break;
                case "d":
                    deleteItem();
                    break;
                case "i":
                    insertItem();
                    break;
                case "p":
                    printList();
                    break;
                case "q":
                    running = quit();
                    break;
            }
        }
    }

    private static void addItem() {
        String item = SafeInput.getString(scanner, "Enter the item to add: ");
        list.add(item);
        System.out.println("Item added.");
    }

    private static void deleteItem() {
        if (list.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        printList();
        int index = SafeInput.getRangedInt(scanner, "Enter the item number to delete: ", 1, list.size()) - 1;
        list.remove(index);
        System.out.println("Item deleted.");
    }

    private static void insertItem() {
        if (list.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        printList();
        int index = SafeInput.getRangedInt(scanner, "Enter the position to insert the item: ", 1, list.size() + 1) - 1;
        String item = SafeInput.getString(scanner, "Enter the item to insert: ");
        list.add(index, item);
        System.out.println("Item inserted.");
    }

    private static void printList() {
        if (list.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }

    private static boolean quit() {
        return !SafeInput.getYNConfirm(scanner, "Are you sure you want to quit?");
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("A – Add an item to the list");
        System.out.println("D – Delete an item from the list");
        System.out.println("I – Insert an item into the list");
        System.out.println("P – Print (i.e. display) the list");
        System.out.println("Q – Quit the program");
    }
}