import java.util.*;
public class InstagramWilson {

}
class User implements Comparable {
    private String first;
    private String last;
    private String username;
    private boolean followBack;
    public User(boolean followBack, String first, String last, String username) {

    }
    public String getFirst() {
        return first;
    }
    public String getLast() {
        return last;
    }
    public boolean getFollow() {
        return followBack;
    }
    public void setFirst(String first) {
        this.first = first;
    }
    public void setLast(String last) {
        this.last = last;
    }
    public void unfollow() {
        this.followBack = false;
    }
    public boolean equals(User other) {
        return this.username.equalsIgnoreCare(other.getUsername());
    }
    private String followString() {
        if(followBack) return "You are following this person";
        else return "You are not following this person";
    }
    public String toString() {
        return String.format("Username: %1$s\nFirst Name: %2$s\nLast Name: %3$s\n\n%4$s\n", this.username, this.getFirst(), this.getLast(), followString());
    }
}
class SocialMedia {

}
class Driver {

}
class YourDriver {

}
