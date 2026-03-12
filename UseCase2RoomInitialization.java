/**
 * Room Initialization Example
 * Demonstrates inheritance and abstraction
 *
 * @author Student
 * @version 2.1
 */

abstract class Room {

    String roomType;
    int beds;
    double price;

    Room(String roomType, int beds, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Beds: " + beds);
        System.out.println("Price: $" + price);
        System.out.println("------------------------");
    }
}

class SingleRoom extends Room {
    SingleRoom() {
        super("Single Room", 1, 100);
    }
}

class DoubleRoom extends Room {
    DoubleRoom() {
        super("Double Room", 2, 180);
    }
}

class SuiteRoom extends Room {
    SuiteRoom() {
        super("Suite Room", 3, 350);
    }
}

public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        int singleAvailability = 5;
        int doubleAvailability = 3;
        int suiteAvailability = 2;

        Room single = new SingleRoom();
        Room dbl = new DoubleRoom();
        Room suite = new SuiteRoom();

        System.out.println("Hotel Booking System v2.1\n");

        single.displayDetails();
        System.out.println("Available: " + singleAvailability);

        dbl.displayDetails();
        System.out.println("Available: " + doubleAvailability);

        suite.displayDetails();
        System.out.println("Available: " + suiteAvailability);
    }
}