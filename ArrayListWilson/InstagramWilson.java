import java.util.*;
public class InstagramWilson {

}
class User implements Comparable {
    private String first;
    private String last;
    public String username;
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
    public void follow() {
        this.followBack = true;
    }
    public boolean equals(User other) {
        return this.username.equalsIgnoreCase(other.username);
    }
    private String followString() {
        if(followBack) return "You are following this person";
        else return "You are not following this person";
    }
    public String toString() {
        return String.format("Username: %1$s\nFirst Name: %2$s\nLast Name: %3$s\n\n%4$s\n", this.username, this.getFirst(), this.getLast(), followString());
    }
    public int compareTo(Object o) {
        User other = (User) o;
        if(this.first.equalsIgnoreCase(other.first)) {
            return this.last.compareToIgnoreCase(other.last);
        }
        return this.first.compareToIgnoreCase(other.first);
    }

}
class Instagram {
    private ArrayList<User> app;
    public Instagram() {
        app = new ArrayList<User>();
    }
    public void followBack(String first, String last) {
        for(User u : app) {
            if(u.getFirst().equalsIgnoreCase(first) && u.getLast().equalsIgnoreCase(last)) {
                u.follow();
                break;
            }
        }
    }
    public boolean follow(boolean followBack, String first, String last) {
        
    }
}
class Driver{
   public static void main(String[]args) {
      Instagram myInsta = new Instagram();
      
    	/*Adding followers to your list*/
      /*the boolean field indicates whether you want to follow them back*/
      myInsta.follow(true, "Matthew", "Philips", "MatPhil"); // must modify this line to include the added attribute
      myInsta.follow(false, "Gary", "Kane",  "GKane"); //// must modify this line to include the added attribute
      myInsta.follow(true, "Robert", "Kenny",  "RKenny"); //// must modify this line to include the added attribute
      myInsta.follow(true, "Bill", "Fitch", "BillF");//// must modify this line to include the added attribute
      myInsta.follow(false, "Trevor", "Schlulz", "TrevorS");//// must modify this line to include the added attribute
      
    	/*Displaying your followers*/
      System.out.println("Your followers informations\n");
      System.out.println(myInsta);
    	
      /*Unfollowing a user*/
      System.out.println("Removing Robert Kenny from your followers list");
      myInsta.delete("Robert", "Kenny");
   	
      /*Displaying the list*/
      System.out.println("List of followers after removing Robert Kenny");
      System.out.println(myInsta);
   	
      /*adding a new follower*/
      System.out.println("Adding Elon Musk to your list of followers");
      myInsta.follow(true, "Elon", "Musk", "ElonM");
      
      /*Dipslying the followers*/
      System.out.println("List of your followers:");
      System.out.println(myInsta);
   	
      /*Searching for a follower*/
      System.out.println("Searching for Stonewall Jackson(StonW) in your followers list");
      if(myInsta.find("Jackson", "Stonewall") == false) {
         System.out.println("Stonewall Jackson is not in your list of followers");
         System.out.println("\n***************************");   
         System.out.println("You are following " + myInsta.followersNum() + " people");
      
         System.out.println("You have " + myInsta.followingsNum() + " followers");  
         System.out.println(myInsta);
         Scanner kb = new Scanner(System.in);
         System.out.println("Enter the first name and the last name of  of the person that you want to follow back: ");
      
         String first =kb.next();
         String last = kb.next();
          
         myInsta.followBack(first, last);
      
         System.out.println(myInsta);
      
      }
   	
   }
}
class YourDriver {

}
