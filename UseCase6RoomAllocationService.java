/**
 * Room Allocation Service
 * Prevents double booking using Set
 *
 * @author Student
 * @version 6.0
 */

import java.util.*;

class AllocationInventory {

    private HashMap<String, Integer> inventory;

    public AllocationInventory() {

        inventory = new HashMap<>();

        inventory.put("Single", 2);
        inventory.put("Double", 2);
        inventory.put("Suite", 1);
    }

    public boolean isAvailable(String type) {
        return inventory.getOrDefault(type, 0) > 0;
    }

    public void reduceRoom(String type) {
        inventory.put(type, inventory.get(type) - 1);
    }
}

class RoomAllocationService {

    private Set<String> allocatedRooms = new HashSet<>();
    private HashMap<String, Set<String>> roomAssignments = new HashMap<>();
    private int roomCounter = 1;

    public void allocateRoom(String roomType, AllocationInventory inventory) {

        if (!inventory.isAvailable(roomType)) {
            System.out.println("No " + roomType + " rooms available.");
            return;
        }

        String roomId = roomType + "-" + roomCounter++;

        allocatedRooms.add(roomId);

        roomAssignments.putIfAbsent(roomType, new HashSet<>());
        roomAssignments.get(roomType).add(roomId);

        inventory.reduceRoom(roomType);

        System.out.println("Room Allocated: " + roomId);
    }

    public void showAllocations() {

        System.out.println("\nRoom Allocations:");

        for (String type : roomAssignments.keySet()) {
            System.out.println(type + " Rooms -> " + roomAssignments.get(type));
        }
    }
}

public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("Hotel Booking System v6.0\n");

        AllocationInventory inventory = new AllocationInventory();

        RoomAllocationService service = new RoomAllocationService();

        service.allocateRoom("Single", inventory);
        service.allocateRoom("Double", inventory);
        service.allocateRoom("Single", inventory);
        service.allocateRoom("Suite", inventory);

        service.showAllocations();
    }
}
