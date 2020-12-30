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

	public boolean studentRegister(String username, String password) {
		Student student = new Student(username, password);
		users.putIfAbsent(username, student);
	}

	public boolean login(String username, String password) {
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
		return false;
	}

	public boolean logout() {

        return false;
    }

	public boolean courseReg(int courseNum) {
		if(!courses.contains(courseNum)) {
			return false;
		}
		else {
			if(!courses.get(courseNum).isAvailable()) {
				return false;
			}
		}
	}



	public boolean KdamCheck(int courseNum) {
		courses.get(courseNum).getKdam();
		return true;
	}


	public String studentStats(String username) {
		return users.get(username).getStats();
	}

	public String courseStats(int courseNum) {
		return courses.get(courseNum).getStats();
	}

	public boolean isRegisterd(int courseNum) {

	}

	public boolean unregister(int courseNum) {

	}

	public void getCourses() {

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
