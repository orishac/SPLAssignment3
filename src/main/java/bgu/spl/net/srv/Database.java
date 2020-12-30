package bgu.spl.net.srv;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Passive object representing the Database where all courses and users are stored.
 * <p>
 * This class must be implemented safely as a thread-safe singleton.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You can add private fields and methods to this class as you see fit.
 */
public class Database {
	private ConcurrentHashMap<Integer, Course> courses;
	private ConcurrentHashMap<String, User> users;

	private static class DatabaseHolder {
		private static final Database instance = new Database();
	}


	//to prevent user from creating new Database
	private Database() {
		courses = new ConcurrentHashMap<>();
		users = new ConcurrentHashMap<String, User>();
	}

	/**
	 * Retrieves the single instance of this class.
	 */
	public static Database getInstance() {
		return DatabaseHolder.instance;
	}

	public boolean adminRegister(String username, String password) {
		Admin admin = new Admin(username, password);
		users.putIfAbsent(username, admin);
		return true;
	}

	public void studentRegister(String username, String password) {
		Student student = new Student(username, password);
		users.putIfAbsent(username, student);
	}

	public void login(String username, String password) {
		if(!users.contains(username)) {
			//sends an error
		}
		else {
			if(!users.get(username).isSamePassword(password)) {
				//sends an error
			}
			else {
				if(users.get(username).isLoggedIn()) {
					//sends an error
				}
			}
		}
	}

	public void logout() {

	}

	/*private void courseReg(String courseNum) {
		if(!courses.contains(courseNum)) {
			//send an error
		}
		else {
			if(!courses.get(courseNum).isAvailable()) {
				//sends an error
			}
			if()
		}
	}

	 */

	public void KdamCheck(String courseNum) {
		courses.get(courseNum).getKdam();
	}


	public String courseStats(String username) {
		return users.get(username).getStats();
	}

	public void isRegisterd(String courseNum) {

	}

	public void unregister(String courseNum) {

	}

	private void getCourses() {

	}



	
	/**
	 * loades the courses from the file path specified 
	 * into the Database, returns true if successful.
	 */
	boolean initialize(String coursesFilePath) {
		// TODO: implement
		return false;
	}


}
