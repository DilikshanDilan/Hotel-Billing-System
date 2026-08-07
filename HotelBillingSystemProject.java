import java.util.InputMismatchException;
import java.util.Scanner;

class Customer {
    String name, contact, checkInDate, checkOutDate;

    Customer(String name, String contact, String checkInDate, String checkOutDate) {
        this.name = name;
        this.contact = contact;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public void displayCustomerDetails() {
        System.out.println("\n-- Customer Details --");
        System.out.println("Customer Name  : " + name);
        System.out.println("Contact Number : " + contact);
        System.out.println("Check-in Date  : " + checkInDate);
        System.out.println("Check-out Date : " + checkOutDate);
    }
}

class Room {
    String roomType;
    int daysStayed;

    Room(String roomType, int daysStayed) {
        this.roomType = roomType;
        this.daysStayed = daysStayed;
    }

    public int getRoomCharge() {
        switch (roomType.toLowerCase()) {
            case "single": return daysStayed * 3000;
            case "double": return daysStayed * 5000;
            case "deluxe": return daysStayed * 8000;
            case "suite":  return daysStayed * 12000;
            default: return 0;
        }
    }

    public void displayRoomDetails() {
        System.out.println("\n-- Room Details --");
        System.out.println("Room Type      : " + capitalize(roomType));
        System.out.println("Days Stayed    : " + daysStayed);
        System.out.println("Room Charges   : Rs. " + getRoomCharge());
    }

    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}

class Services {
    int foodCharge, laundryCharge, serviceCharge;

    Services(int foodCharge, int laundryCharge, int serviceCharge) {
        this.foodCharge = foodCharge;
        this.laundryCharge = laundryCharge;
        this.serviceCharge = serviceCharge;
    }

    public int getTotalServiceCharge() {
        return foodCharge + laundryCharge + serviceCharge;
    }

    public void displayServices() {
        System.out.println("\n-- Extra Services --");
        System.out.println("Food           : Rs. " + foodCharge);
        System.out.println("Laundry        : Rs. " + laundryCharge);
        System.out.println("Room Service   : Rs. " + serviceCharge);
        System.out.println("Service Total  : Rs. " + getTotalServiceCharge());
    }
}

class Bill {
    int roomCharge, serviceCharge;
    double discount;
    double taxRate = 0.10;

    Bill(int roomCharge, int serviceCharge, double discount) {
        this.roomCharge = roomCharge;
        this.serviceCharge = serviceCharge;
        this.discount = discount;
    }

    public void printFinalBill() {
        int subTotal = roomCharge + serviceCharge;
        double tax = subTotal * taxRate;
        double total = subTotal + tax - discount;

        System.out.println("\n------- FINAL BILL -------");
        System.out.printf("Subtotal        : Rs. %.2f%n", (double) subTotal);
        System.out.printf("Tax (10%%)       : Rs. %.2f%n", tax);
        System.out.printf("Discount        : Rs. %.2f%n", discount);
        System.out.println("-----------------------------");
        System.out.printf("TOTAL BILL      : Rs. %.2f%n", total);
        System.out.println("=============================");
        System.out.println("Thank you for staying with us!");
    }
}

public class HotelBillingSystemProject {

    // Reads a non-empty line of text, re-prompting on blank input.
    private static String readNonEmptyLine(Scanner sc, String prompt) {
        String value;
        while (true) {
            System.out.print(prompt);
            value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    // Reads an integer within [min, max], re-prompting on invalid or out-of-range input.
    private static int readIntInRange(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(sc.nextLine().trim());
                if (value < min || value > max) {
                    System.out.println("Please enter a value between " + min + " and " + max + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter digits only.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("======= HOTEL BILLING SYSTEM =======");

            // Customer Details
            String name = readNonEmptyLine(sc, "Enter Customer Name: ");
            String contact = readNonEmptyLine(sc, "Enter Contact Number: ");
            String checkIn = readNonEmptyLine(sc, "Enter Check-in Date (YYYY-MM-DD): ");
            String checkOut = readNonEmptyLine(sc, "Enter Check-out Date (YYYY-MM-DD): ");

            Customer customer = new Customer(name, contact, checkIn, checkOut);
            customer.displayCustomerDetails();

            // Room Selection
            System.out.println("\nSelect Room Type:");
            System.out.println("1. Single - Rs. 3000/day");
            System.out.println("2. Double - Rs. 5000/day");
            System.out.println("3. Deluxe - Rs. 8000/day");
            System.out.println("4. Suite  - Rs. 12000/day");
            int roomOption = readIntInRange(sc, "Enter option (1-4): ", 1, 4);

            String roomType;
            switch (roomOption) {
                case 1: roomType = "single"; break;
                case 2: roomType = "double"; break;
                case 3: roomType = "deluxe"; break;
                default: roomType = "suite";
            }

            int daysStayed = readIntInRange(sc, "Enter Number of Days Stayed: ", 1, 365);

            Room room = new Room(roomType, daysStayed);
            room.displayRoomDetails();

            // Service Charges
            System.out.println("\nEnter Service Charges:");
            int foodCharge = readIntInRange(sc, "Food Charges: Rs. ", 0, 1_000_000);
            int laundryCharge = readIntInRange(sc, "Laundry Charges: Rs. ", 0, 1_000_000);
            int serviceCharge = readIntInRange(sc, "Room Service Charges: Rs. ", 0, 1_000_000);

            Services services = new Services(foodCharge, laundryCharge, serviceCharge);
            services.displayServices();

            // Calculate Total Charges
            int roomCharge = room.getRoomCharge();
            int totalServiceCharge = services.getTotalServiceCharge();

            double discount;
            switch (roomType) {
                case "single": discount = 500; break;
                case "double": discount = 1000; break;
                case "deluxe": discount = 1500; break;
                default: discount = 2000;
            }

            Bill bill = new Bill(roomCharge, totalServiceCharge, discount);
            bill.printFinalBill();

        } catch (InputMismatchException e) {
            System.out.println("\nUnexpected input error. Please restart the program and enter valid data.");
        } finally {
            sc.close();
        }
    }
}
