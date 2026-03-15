/**
 *
 * MAIN CLASS BookMyStayApp
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * This class demonstrates how room availability
 * is managed using a centralized inventory system.
 *
 * The RoomInventory class acts as the single
 * source of truth for room availability.
 *
 * Room objects provide room characteristics
 * such as beds, size, and pricing.
 *
 * No booking or search logic is implemented
 * in this stage of the system.
 *
 * @version 3.1
 */

public class BookMyStayApp {

    /**
     * Application entry point.
     *
     * The JVM starts program execution here.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Hotel Room Inventory Status");

        /*
         * Create room objects representing
         * different types of hotel rooms.
         */
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        /*
         * Initialize centralized room inventory.
         * This replaces scattered availability variables
         * from the previous use case.
         */
        RoomInventory inventory = new RoomInventory();

        /*
         * Display Single Room details and availability
         */
        System.out.println("\nSingle Room:");
        singleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " +
                inventory.getRoomAvailability().get("Single"));

        /*
         * Display Double Room details and availability
         */
        System.out.println("\nDouble Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " +
                inventory.getRoomAvailability().get("Double"));

        /*
         * Display Suite Room details and availability
         */
        System.out.println("\nSuite Room:");
        suiteRoom.displayRoomDetails();
        System.out.println("Available Rooms: " +
                inventory.getRoomAvailability().get("Suite"));
    }
}