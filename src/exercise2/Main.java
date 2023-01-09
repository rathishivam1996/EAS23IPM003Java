package exercise2;

import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Reservation reservation;

    public static void main(String[] args) {
        CustomerList customerList = CustomerList.getCustomers();
        customerList.createRandomCustomers(5);

        GuestHouse guestHouse = GuestHouse.getInstance();
        guestHouse.createRandomRooms(10, 3);

        ReservationList reservationList = ReservationList.getInstance();

        int ch;
        Scanner scn = new Scanner(System.in);

        lp:
        while (true) {
            displayMenu();
            System.out.print(Color.BLUE);
            System.out.println("Make a choice:");
            System.out.print(Color.RESET);

            ch = scn.nextInt();
            scn.nextLine();

            switch (ch) {
                case 1 -> {
                    System.out.print(Color.MAGENTA);
                    System.out.println("1: Register - registers a customer");
                    System.out.println("Enter the customer name");
                    String firstName = scn.nextLine();

                    System.out.println("Enter the customer email address");

                    String email = scn.nextLine();

                    Customer customer = new Customer(firstName, email);
                    customerList.addCustomer(customer);
                    System.out.print(Color.YELLOW);
                    System.out.println("customer is Registered as =>");
                    System.out.println(customer);
                    System.out.print(Color.RESET);
                }
                case 2 -> {
                    System.out.print(Color.MAGENTA);
                    System.out.println("2: Book - Book a room");
                    System.out.println("Enter the customer name");

                    String customerName = scn.nextLine();
                    Customer customer = customerList.findCustomerByName(customerName);

                    if (customer == null) {
                        System.out.print(Color.RED);
                        System.out.println("Customer with the given name does not exist. " +
                                "Register the customer first");
                        break;
                    }
                    System.out.print(Color.MAGENTA);
                    System.out.println("Enter Requested room number");

                    int roomNum = scn.nextInt();
                    scn.nextLine();
                    boolean isRoomAvailable = reservationList.isRoomAvailable(roomNum);
                    if (!isRoomAvailable) {
                        System.out.print(Color.RED);
                        System.out.println("The requested room is not available. " +
                                "Please select a different room");
                        break;
                    }
                    Room room = guestHouse.getRoomById(roomNum);
                    System.out.print(Color.YELLOW);
                    System.out.println("your selected room is => ");
                    System.out.println(room);

                    Date reservationDate = new Date();

                    System.out.print(Color.MAGENTA);
                    System.out.println("Enter num of days of reservation");
                    int numOfDays = scn.nextInt();
                    scn.nextLine();

                    int reservationAmount = room.getRoomPricePerDay() * numOfDays;

                    reservationList.makeReservation(customer.getCustomerId(), roomNum,
                            reservationDate, numOfDays, reservationAmount);
                    Reservation reservation = reservationList.findReservationByCustomerId(customer.getCustomerId());
                    System.out.print(Color.YELLOW);
                    System.out.println("Reservation done =>");
                    System.out.println(reservation);
                    System.out.print(Color.RESET);
                }
                case 3 -> {
                    System.out.print(Color.MAGENTA);
                    System.out.println("3: Check Status - Check for the rooms present status (Vacant/Booked");
                    guestHouse.displayRoomsStatus();
                    System.out.print(Color.RESET);
                }
                case 4 -> {

                }
                case 5 -> {
                    System.out.print(Color.MAGENTA);
                    System.out.println("5: All Bookings - Display all bookings for a specific time period mentioned");
                    System.out.print(Color.YELLOW);
                    reservationList.displayAllReservations();
                    System.out.print(Color.RESET);
                }
                case 6 -> {
                    System.out.print(Color.MAGENTA);
                    System.out.println("6: All customers - Display all the registered customer details");
                    System.out.print(Color.YELLOW);
                    customerList.displayCustomers();
                    System.out.print(Color.RESET);
                }
                case 7 -> {
                    System.out.print(Color.MAGENTA);
                    System.out.println("7: All Rooms - Display all the room details");
                    System.out.print(Color.YELLOW);
                    guestHouse.displayRooms();
                    System.out.print(Color.RESET);
                }
                case 8 -> {
                    System.out.print(Color.MAGENTA);
                    System.out.println("8: Display Room by type - Display Room by type");
                    guestHouse.displayRoomByType();
                    System.out.print(Color.RESET);
                }
                case 9 -> {
                    System.out.print(Color.RED);
                    System.out.println("9: Quit - Program termination");
                    System.out.println("Terminating the program");
                    System.out.print(Color.RESET);
                    break lp;
                }
                default -> {
                    System.out.print(Color.RED);
                    System.out.println("Invalid choice! Please make a valid choice.");
                    System.out.print(Color.RESET);
                }
            }
        }
        scn.close();
    }

    public static void displayMenu() {
        System.out.println();
        System.out.print(Color.BLUE);
        System.out.println("=========================================================");
        System.out.println("1: Register - registers a customer");
        System.out.println("2: Book - Book a room");
        System.out.println("3: Check Status - Check for the rooms present status (Vacant/Booked");
        System.out.println("4: Email - Change/Update email address of the customer");
        System.out.println("5: All Bookings - Display all bookings for a specific time period mentioned");
        System.out.println("6: All customers - Display all the registered customer details");
        System.out.println("7: All Rooms - Display all the room details");
        System.out.println("8: Display Room by type - Display Room by type");
        System.out.println("9: Quit - Program termination");
        System.out.println("=========================================================");
        System.out.print(Color.RESET);
        System.out.println();
    }
}