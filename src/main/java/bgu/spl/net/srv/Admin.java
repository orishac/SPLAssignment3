package bgu.spl.net.srv;

public class Admin extends User{

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public String getStats() {
        return null;
    }
}
