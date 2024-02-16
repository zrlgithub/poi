import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {
    private String text;
    private String user; // Assuming a simple string to represent the user for now
    private LocalDateTime timestamp; // To record when the comment was made

    // Constructor
    public Comment(String user, String text) {
        this.user = user;
        this.text = text;
        this.timestamp = LocalDateTime.now(); // Set the timestamp to the current time
    }

    // Getter methods
    public String getText() {
        return text;
    }

    public String getUser() {
        return user;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Setter method for text, in case a comment needs to be edited
    public void setText(String text) {
        this.text = text;
    }

    // Method to display comment information, including the timestamp
    public void displayComment() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTimestamp = timestamp.format(formatter);
        System.out.println(user + " (" + formattedTimestamp + "): " + text);
    }
}
