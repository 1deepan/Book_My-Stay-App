/**
 * Booking Request Queue
 * Demonstrates FIFO booking request handling
 *
 * @author Student
 * @version 5.0
 */

import java.util.LinkedList;
import java.util.Queue;

class Reservation {

    String guestName;
    String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String toString() {
        return guestName + " requested " + roomType + " room";
    }
}

class BookingRequestQueue {

    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {
        queue.add(reservation);
        System.out.println("Request Added: " + reservation);
    }

    public void showRequests() {

        System.out.println("\nCurrent Booking Requests:");

        for (Reservation r : queue) {
            System.out.println(r);
        }
    }
}

public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("Hotel Booking System v5.0\n");

        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Alice", "Single"));
        queue.addRequest(new Reservation("Bob", "Double"));
        queue.addRequest(new Reservation("Charlie", "Suite"));

        queue.showRequests();
    }
}