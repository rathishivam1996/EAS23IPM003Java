package exercise3;

import exercise3.Room.Room;
import exercise3.Room.RoomCategory;

import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Reservation reservation;
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        CustomerList customerList = CustomerList.getCustomers();
        customerList.createRandomCustomers(5);

        GuestHouse guestHouse = GuestHouse.getInstance();
        guestHouse.createRandomStayRooms(5, 3);
        guestHouse.createRandomConferenceHalls();
        guestHouse.createRandomPartyHalls();

        ReservationList reservationList = ReservationList.getInstance();

        int ch = 0;

        lp:
        while (true) {
            displayMenu();
            System.out.print(Color.BLUE);
            System.out.println("Make a choice:");
            System.out.print(Color.RESET);

            if (scn.hasNextInt()) {
                ch = scn.nextInt();
                scn.nextLine();
            } else {
                scn.next();
                System.out.println(Color.RED);
                System.out.println("Sorry!! could not understand you.");
            }

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
                    System.out.println("2: create room");
                    try {
                        System.out.println("Please enter a Room number in Range [1, 100]");
                        int roomNum = scn.nextInt();
                        if (roomNum <= 0 || roomNum > 100) {
                            throw new IllegalArgumentException("Invalid Room Number.");
                        }
                        System.out.println("Please enter a Room capacity in Range [1, 500]");
                        int roomCapacity = scn.nextInt();
                        if (roomCapacity <= 0 || roomCapacity > 500) {
                            throw new IllegalArgumentException("Invalid Room Capacity.");
                        }
                        System.out.println("Please enter a Room price in Range [1000, 100000]");
                        int roomPricePerDay = scn.nextInt();
                        if (roomPricePerDay < 1000 || roomPricePerDay > 100000) {
                            throw new IllegalArgumentException("Invalid Room Capacity.");
                        }
                        System.out.println("Please enter a Room availability in Range [true, false]");
                        boolean roomAvailability = scn.nextBoolean();
                        Room room = new Room(roomNum, roomPricePerDay, roomCapacity, roomAvailability);
                    } catch (IllegalArgumentException e) {
                        System.out.println(Color.RED);
                        System.out.println("Invalid room details. Please enter valid details.");
                    }
                }
                case 3 -> {
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
                    displayBookMenu(guestHouse);
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
                    System.out.println("3: Check Status - Check for the rooms present status (Vacant/Booked");
                    guestHouse.displayRoomsByStatus();
                    System.out.print(Color.RESET);
                }
                case 8 -> {
                    displayRoomByCategoryMenu(guestHouse);
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

    public static void displayBookMenu(GuestHouse guestHouse) {
        int ch = 0;
        System.out.print(Color.MAGENTA);
        System.out.println("2: Please select room type");
        System.out.println("    1: All Stay Rooms");
        System.out.println("    2: All Conference Halls");
        System.out.println("    3: All Party Halls");
        System.out.println("    4: Terminate Room Submenu");
        if (scn.hasNextInt()) {
            ch = scn.nextInt();
            scn.nextLine();
        } else {
            scn.next();
            System.out.println(Color.RED);
            System.out.println("Sorry!! could not understand you.");
        }
        switch (ch) {
            case 1 -> {
                System.out.print(Color.MAGENTA);
                System.out.println("    1: All Stay Rooms");
                System.out.print(Color.YELLOW);
                guestHouse.displayRoomByCategory(RoomCategory.STAY_ROOM);
                break;
            }
            case 2 -> {
                System.out.print(Color.MAGENTA);
                System.out.println("    2: All Conference Halls");
                System.out.print(Color.YELLOW);
                guestHouse.displayRoomByCategory(RoomCategory.CONFERENCE_HALL);
                break;
            }
            case 3 -> {
                System.out.print(Color.MAGENTA);
                System.out.println("    3: All Party Halls");
                System.out.print(Color.YELLOW);
                guestHouse.displayRoomByCategory(RoomCategory.PARTY_HALL);
                break;
            }
            case 4 -> {
                System.out.println("    4: Terminate Room Submenu");
                System.out.print(Color.RESET);
                break;
            }
        }

    }

    public static void displayRoomByCategoryMenu(GuestHouse guestHouse) {
        int ch = 0;
        lp:
        while (true) {
            System.out.print(Color.MAGENTA);
            System.out.println("8: All Rooms - Display all the room details");
            System.out.println("    1: All Stay Rooms");
            System.out.println("    2: All Conference Halls");
            System.out.println("    3: All Party Halls");
            System.out.println("    4: Terminate Room Submenu");
            if (scn.hasNextInt()) {
                ch = scn.nextInt();
                scn.nextLine();
            } else {
                scn.next();
                System.out.println(Color.RED);
                System.out.println("Sorry!! could not understand you.");
            }

            switch (ch) {
                case 1 -> {
                    System.out.print(Color.MAGENTA);
                    System.out.println("    1: All Stay Rooms");
                    System.out.print(Color.YELLOW);
                    guestHouse.displayRoomByCategory(RoomCategory.STAY_ROOM);
                }
                case 2 -> {
                    System.out.print(Color.MAGENTA);
                    System.out.println("    2: All Conference Halls");
                    System.out.print(Color.YELLOW);
                    guestHouse.displayRoomByCategory(RoomCategory.CONFERENCE_HALL);
                }
                case 3 -> {
                    System.out.print(Color.MAGENTA);
                    System.out.println("    3: All Party Halls");
                    System.out.print(Color.YELLOW);
                    guestHouse.displayRoomByCategory(RoomCategory.PARTY_HALL);
                }
                case 4 -> {
                    System.out.print(Color.RED);
                    System.out.println("    4: Terminate Room Submenu");
                    System.out.print(Color.RESET);
                    break lp;
                }
            }
        }
    }

    public static void displayMenu() {
        System.out.println();
        System.out.print(Color.BLUE);
        System.out.println("=========================================================");
        System.out.println("1: Register - registers a customer");
        System.out.println("2: Create Room");
        System.out.println("3: Book - Book a room");
        System.out.println("4: Email - Change/Update email address of the customer");
        System.out.println("5: All Bookings - Display all bookings for a specific time period mentioned");
        System.out.println("6: All customers - Display all the registered customer details");
        System.out.println("7: Check Status - Check for the rooms present status (Vacant/Booked");
        System.out.println("8: All Rooms - Display all the room details");
        System.out.println("9: Quit - Program termination");
        System.out.println("=========================================================");
        System.out.print(Color.RESET);
        System.out.println();
    }
}