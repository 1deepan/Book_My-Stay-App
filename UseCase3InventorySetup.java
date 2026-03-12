/**
 * Centralized Room Inventory Management
 * Demonstrates HashMap for managing room availability
 *
 * @author Student
 * @version 3.1
 */

import java.util.HashMap;

class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public void displayInventory() {

        System.out.println("Current Room Inventory:");

        for (String roomType : inventory.keySet()) {
            System.out.println(roomType + " Rooms Available: " + inventory.get(roomType));
        }
    }
}

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("Hotel Booking System v3.1\n");

        RoomInventory inventory = new RoomInventory();

        inventory.displayInventory();
    }
}