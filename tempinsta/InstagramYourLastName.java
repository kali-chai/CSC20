import java.util.*;

public class InstagramYourLastName { /* no code here */ }

class User implements Comparable {
	private String first;
	private String last;
	private String username;
	private boolean followBack; 
	private int id;

	public User(boolean followBack, String first, String last, String username, int id) {
		this.followBack = followBack;
		this.first = first;
		this.last = last;
		this.username = username;
		this.id = id;
	}

	public boolean getFollow() {
		return this.followBack;
	}

	public void unfollow() {
		this.followBack = false;
	}

	public void follow() {
		this.followBack = true;
	}

	public String getFirst() {
		return this.first;
	}

	public String getLast() {
		return this.last;
	}

	public void setFirst(String first) {
		this.first = first;
	}
	
	public void setLast(String last) {
		this.last = last;
	}

	public String getUsername() {
		return this.username;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int compareTo(Object o) {
		// is it supposed to be this.username.compareTo(o.username)?
		return this.username.compareTo(((User)o).getUsername());
	}

	public boolean equals(User other) {
		return this.username.equalsIgnoreCase(other.username);
	}

	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append("User name: ");
		out.append(this.getUsername());
		out.append("\nName: ");
		out.append(this.getFirst());
		out.append("\nLast name: ");
		out.append(this.getLast());
		if (this.getFollow()) {
			out.append("\nYou are following this person.");
		} else {
			out.append("\nYou are not following this person.");
		}
		return out.toString();
	}
}

class Instagram {
	private ArrayList<User> app;

	Instagram() {
		app = new ArrayList<User>();
	}

	public void followBack(String first, String last) {
		for (User user : this.app) {
			if (user.getFirst().equals(first) && user.getLast().equals(last)) {
				user.follow();
				break;
			}
		}
	}

	public boolean follow(boolean followBack, String first, String last, String username, int id) {
		
		// how does it want the users to be ordered?
		User user = new User(followBack, first, last, username, id);
		if (this.app.contains(user)) return false;
		this.app.add(user);
		return true;
	}

	// This method removes the person from the list meaning that they are not following you and you are not following them
	public boolean delete(String first, String last ) {
		for (int i = 0; i < this.followersNum(); i++) {
			User user = this.app.get(i);
			if (user.getFirst().equals(first) && user.getLast().equals(last)) {
				this.app.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean find(String first, String last) {
		for (User user : this.app) {
			if (user.getFirst().equals(first) && user.getLast().equals(last)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<User >getList() {
		return app;
	}

	public int followersNum() {
		return this.app.size();
	}

	public int followingsNum() {
		int followings = 0;
		for (User user : this.app) {
			if (user.getFollow()) followings++;
		}
		return followings;
	} 

	public String toString() { 
		StringBuilder out = new StringBuilder();
		for (User user : this.app) {
			out.append(user.toString());
			out.append("\n");
		}
		return out.toString();
	}
}

// create your own driver here
// Must create a list with 5 users.
// Make sure to call all the methods you wrote
class MyDriver {
	public static void main(String[] args) {
		//your code here: should be similar to the given driver below
	}
}

/*below is a sample driver. Do not remove this driver from your code when sub,itting it*/
class Driver{
	public static void main(String[]args) {
		Instagram myInsta = new Instagram();

		/*Adding followers to your list*/
		/*the boolean field indicates whether you want to follow them back*/
		myInsta.follow(true, "Matthew", "Philips", "MatPhil", 12414); // must modify this line to include the added attribute
		myInsta.follow(false, "Gary", "Kane",  "GKane", 135463); //// must modify this line to include the added attribute
		myInsta.follow(true, "Robert", "Kenny",  "RKenny", 23541); //// must modify this line to include the added attribute
		myInsta.follow(true, "Bill", "Fitch", "BillF", 23546);//// must modify this line to include the added attribute
		myInsta.follow(false, "Trevor", "Schlulz", "TrevorS", 2352423);//// must modify this line to include the added attribute

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
		myInsta.follow(true, "Elon", "Musk", "ElonM", 5425);

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
