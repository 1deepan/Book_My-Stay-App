/**
 * Room Search Service
 * Displays available rooms without modifying inventory
 *
 * @author Student
 * @version 4.0
 */

import java.util.HashMap;

class InventoryService {

    private HashMap<String, Integer> inventory;

    public InventoryService() {
        inventory = new HashMap<>();

        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 0);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public HashMap<String, Integer> getInventory() {
        return inventory;
    }
}

class RoomSearchService {

    public void searchRooms(InventoryService inventory) {

        System.out.println("Available Rooms:\n");

        for (String type : inventory.getInventory().keySet()) {

            int available = inventory.getAvailability(type);

            if (available > 0) {
                System.out.println(type + " Room - Available: " + available);
            }
        }
    }
}

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("Hotel Booking System v4.0\n");

        InventoryService inventory = new InventoryService();

        RoomSearchService searchService = new RoomSearchService();

        searchService.searchRooms(inventory);
    }
}