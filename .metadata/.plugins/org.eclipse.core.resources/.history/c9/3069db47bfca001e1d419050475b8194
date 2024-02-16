import java.util.List;

class AdminUser extends User {
    public AdminUser(String username, String password) {
        super(username, password);
    }

    public void viewAllUsers(List<? extends User> users) {
        System.out.println("List of Users:");
        for (User user : users) {
            System.out.println("Username: " + user.getUsername());
        }
    }
    public void updateUserDetails(RegularUser user, String newPassword) {
        user.setPassword(newPassword);
    }

    public void deleteUser(List<RegularUser> users, RegularUser user) {
        if (users.contains(user)) {
            users.remove(user);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found.");
        }
    }
}