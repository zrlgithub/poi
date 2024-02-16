import java.util.ArrayList;
import java.util.List;

public class PointOfInterest {
    private String name;
    private String type; // e.g., "Historical Site", "Museum"
    private String location; // e.g., "Paris", "New York"
    private int likes; // To track the number of likes
    private List<Comment> comments; // To store comments

    // Constructor
    public PointOfInterest(String name, String type, String location) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.likes = 0; // Initialize likes to 0
        this.comments = new ArrayList<>(); // Initialize the comments list
    }

    // Method to increment the like count
    public void like() {
        likes++;
    }

    // Method to add a comment to the point of interest
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    // Method to display information about the point of interest
    public void displayInfo() {
        System.out.println("Name: " + name + ", Type: " + type + ", Location: " + location + ", Likes: " + likes);
        if (!comments.isEmpty()) {
            System.out.println("Comments:");
            for (Comment comment : comments) {
                comment.displayComment();
            }
        } else {
            System.out.println("No comments yet.");
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public int getLikes() {
        return likes;
    }

    // Method to display all comments for this point of interest
    public void displayComments() {
        if (comments.isEmpty()) {
            System.out.println("No comments yet.");
            return;
        }
        for (Comment comment : comments) {
            comment.displayComment();
        }
    }
}
