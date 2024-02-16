import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class hitastic {
    public static void main(String[] args) {
        PointsOfInterestApp poiApp = new PointsOfInterestApp();
        Scanner scanner = new Scanner(System.in);
        List<PointOfInterest> pointsOfInterest = new ArrayList<>();
        pointsOfInterest.add(new PointOfInterest("Eiffel Tower", "Historical Site", "Paris"));
        pointsOfInterest.add(new PointOfInterest("Statue of Liberty", "Historical Site", "New York"));
        pointsOfInterest.add(new PointOfInterest("The British Museum", "Museum", "London"));

        System.out.println("Welcome to Points of Interest App!");

        while (true) {
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String signUpUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String signUpPassword = scanner.nextLine();
                    poiApp.signUp(signUpUsername, signUpPassword);
                    System.out.println("User signed up successfully!");
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();

                    if (loginUsername.equals(poiApp.getAdminUser().getUsername()) &&
                            loginPassword.equals(poiApp.getAdminUser().getPassword())) {

                        AdminUser admin = poiApp.getAdminUser();
                        System.out.println("Nice! Admin logged!");

                        while (true) {
                            System.out.println("1. View all users");
                            System.out.println("2. Update user details");
                            System.out.println("3. Delete user");
                            System.out.println("4. Logout");
                            System.out.print("Choose an option: ");

                            int adminChoice = scanner.nextInt();
                            scanner.nextLine();
                            switch (adminChoice) {
                                case 1:
                                    admin.viewAllUsers(poiApp.regularUsers);
                                    break;
                                case 2:
                                    System.out.print("Enter username to update: ");
                                    String usernameToUpdate = scanner.nextLine();
                                    RegularUser userToUpdate = null;

                                    for (RegularUser user : poiApp.regularUsers) {
                                        if (user.getUsername().equals(usernameToUpdate)) {
                                            userToUpdate = user;
                                            break;
                                        }
                                    }

                                    if (userToUpdate != null) {
                                        System.out.print("Enter new password: ");
                                        String newPassword = scanner.nextLine();
                                        admin.updateUserDetails(userToUpdate, newPassword);
                                    } else {
                                        System.out.println("User not found.");
                                    }
                                    break;
                                case 3:
                                    System.out.print("Enter username to delete: ");
                                    String usernameToDelete = scanner.nextLine();
                                    RegularUser userToDelete = null;

                                    for (RegularUser user : poiApp.regularUsers) {
                                        if (user.getUsername().equals(usernameToDelete)) {
                                            userToDelete = user;
                                            break;
                                        }
                                    }
                                    admin.deleteUser(poiApp.regularUsers, userToDelete);
                                    break;
                                case 4:
                                    System.out.println("Logout successful!");
                                    break;
                                default:
                                    System.out.println("Invalid option. Try again.");
                                    break;
                            }
                            if (adminChoice == 4) {
                                break;
                            }
                    }
                    }else if (poiApp.login(loginUsername, loginPassword)!=null){
                    RegularUser loggedInUser=poiApp.login(loginUsername, loginPassword);

                        while (true) {
                            System.out.println("\nPointsOfInterest Console Application");
                            System.out.println("1. Search for Points of Interest");
                            System.out.println("2. Like a Point of Interest");
                            System.out.println("3. Comment on a Point of Interest");
                            System.out.println("4. View Comments on a Point of Interest");
                            System.out.println("5. Exit");
                            System.out.print("Choose an option: ");

                            choice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline left-over

                            switch (choice) {
                                case 1:
                                    System.out.print("Enter location or type to search: ");
                                    String searchTerm = scanner.nextLine();
                                    searchPointsOfInterest(pointsOfInterest, searchTerm);
                                    break;
                                case 2:
                                    likePointOfInterest(pointsOfInterest, scanner,loggedInUser);
                                    break;
                                case 3:
                                    commentOnPointOfInterest(pointsOfInterest, scanner, loggedInUser);
                                    break;
                                case 4:
                                    viewCommentsOnPointOfInterest(pointsOfInterest, scanner);
                                    break;
                                case 5:
                                    System.out.println("Exiting application.");
                                    scanner.close();
                                    return;
                                default:
                                    System.out.println("Invalid option. Please try again.");
                            }
                        }
                        }
                    else {
                        System.out.println("Login failed. User not found or incorrect credentials.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting Points of Interest App. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
    private static void searchPointsOfInterest(List<PointOfInterest> pointsOfInterest, String searchTerm) {
        System.out.println("Search Results:");
        for (PointOfInterest poi : pointsOfInterest) {
            if (poi.getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    poi.getType().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    poi.getLocation().toLowerCase().contains(searchTerm.toLowerCase())) {
                poi.displayInfo();
            }
        }
    }

    private static void likePointOfInterest(List<PointOfInterest> pointsOfInterest, Scanner scanner,RegularUser loggedInUser) {
        System.out.print("Enter the name of the Point of Interest to like: ");
        String name = scanner.nextLine();
        for (PointOfInterest poi : pointsOfInterest) {
            if (poi.getName().equalsIgnoreCase(name)) {
                poi.like();
                System.out.println("You liked " + poi.getName() + ". Total likes: " + poi.getLikes());
                return;
            }
        }
        System.out.println("Point of Interest not found.");
    }

    private static void commentOnPointOfInterest(List<PointOfInterest> pointsOfInterest, Scanner scanner,RegularUser loggedInUser) {
        System.out.print("Enter the name of the Point of Interest to comment on: ");
        String name = scanner.nextLine();
        for (PointOfInterest poi : pointsOfInterest) {
            if (poi.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter your comment: ");
                String commentText = scanner.nextLine();
                poi.addComment(new Comment(loggedInUser.getUsername(), commentText));
                System.out.println("Your comment has been added.");
                return;
            }
        }
        System.out.println("Point of Interest not found.");
    }
    private static void viewCommentsOnPointOfInterest(List<PointOfInterest> pointsOfInterest, Scanner scanner) {
        System.out.print("Enter the name of the Point of Interest to view comments: ");
        String name = scanner.nextLine();
        for (PointOfInterest poi : pointsOfInterest) {
            if (poi.getName().equalsIgnoreCase(name)) {
                System.out.println("Comments for " + poi.getName() + ":");
                poi.displayComments();
                return;
            }
        }
        System.out.println("Point of Interest not found.");
    }
}