import java.util.ArrayList;
import java.util.List;

class RegularUser extends User {
    private List<PointOfInterest> likes;
    private List<Comment> comments;

    public RegularUser(String username, String password) {
        super(username, password);
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public void likePOI(PointOfInterest poi) {
        likes.add(poi);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public List<PointOfInterest> getLikes() {
        return likes;
    }

    public List<Comment> getComments() {
        return comments;
    }
}