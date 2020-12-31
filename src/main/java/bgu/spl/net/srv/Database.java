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
		return true;
	}

	public boolean login(String username, String password) {
		if(!users.contains(username)) {
			return false;
		}
		else {
			if(!users.get(username).isSamePassword(password)) {
				return false;
			}
			else {
				if(users.get(username).isLoggedIn()) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean logout() {
        return true;
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
		return true;
	}



	public String KdamCheck(int courseNum) {
		return courses.get(courseNum).getKdam();
	}


	public String studentStats(String username) {
		return users.get(username).getStats();
	}

	public String courseStats(int courseNum) {
		return courses.get(courseNum).getStats();
	}

	public boolean isRegisterd(int courseNum) {
		return courses.get(courseNum).checkIfStudentRegistered("username");
	}

	public boolean unregister(int courseNum) {
		return courses.get(courseNum).deleteStudent("username");
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
