import java.io.*;

/**
 *
 * CLASS FilePersistenceService
 *
 * Use Case 12: Data Persistence & System Recovery
 *
 * Description:
 * Handles saving and loading inventory state
 * using a simple text file.
 *
 * @version 12.0
 */

public class FilePersistenceService {

    /**
     * Saves inventory data to file
     *
     * Format:
     * Single-5
     * Double-3
     *
     * @param inventory room inventory
     * @param filePath file path
     */
    public void saveInventory(RoomInventory inventory,
                              String filePath) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(filePath))) {

            for (String roomType :
                    inventory.getRoomAvailability().keySet()) {

                int count =
                        inventory.getRoomAvailability().get(roomType);

                writer.write(roomType + "-" + count);
                writer.newLine();
            }

            System.out.println("Inventory saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving inventory.");
        }
    }

    /**
     * Loads inventory data from file
     *
     * @param inventory room inventory
     * @param filePath file path
     */
    public void loadInventory(RoomInventory inventory,
                              String filePath) {

        File file = new File(filePath);

        /*
         * If file does not exist → start fresh
         */
        if (!file.exists()) {
            System.out.println(
                    "No valid inventory data found. Starting fresh."
            );
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                /*
                 * Split format: Single-5
                 */
                String[] parts = line.split("-");

                String roomType = parts[0];
                int count = Integer.parseInt(parts[1]);

                inventory.updateAvailability(roomType, count);
            }

            System.out.println("Inventory restored successfully.");

        } catch (Exception e) {
            System.out.println(
                    "Error loading inventory. Starting fresh."
            );
        }
    }
}
