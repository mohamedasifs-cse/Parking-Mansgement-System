import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingLot lot = new ParkingLot(10); // 10 slots per type
        int choice = 0;

        do {
            System.out.println("\n===== Multi-Vehicle Parking System =====");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Show Parking Status");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String input = sc.nextLine();
            try {
              choice = Integer.parseInt(input.trim());
            }
            catch (NumberFormatException e) { System.out.println("Invalid input! Enter a number."); continue; }

            switch (choice) {
                case 1:
                    System.out.print("Enter Vehicle Type (Car/Bike/Truck): ");
                    String type = sc.nextLine().trim();

                    lot.showAvailableSlots(type);

                    System.out.print("Enter Vehicle Number: ");
                    String num = sc.nextLine().trim();

                    
                    if (lot.isDuplicate(num)) {
                        System.out.println(" Vehicle number " + num + " is already parked!");
                        break;
                    }

                    System.out.print("Enter Owner Name: ");
                    String owner = sc.nextLine().trim();

                    Vehicle vehicle = new Vehicle(num, owner, type);
                    lot.parkVehicle(vehicle);
                    break;

                case 2:
                    System.out.print("Enter Vehicle Number to Remove: ");
                    String removeNum = sc.nextLine().trim();
                    lot.removeVehicle(removeNum);
                    break;

                case 3:
                    lot.showStatus();
                    break;

                case 4:
                    System.out.println("🚦 Exiting... Goodbye!");
                    break;

                default:
                    System.out.println(" Invalid choice! Select 1-4.");
            }
        } while (choice != 4);

        sc.close();
    }
}
