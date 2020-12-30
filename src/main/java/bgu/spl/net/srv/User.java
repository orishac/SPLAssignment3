package bgu.spl.net.srv;

public abstract class User {
    private String username;
    private String password;
    private boolean isLoggedIn;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        isLoggedIn = false;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void loginStatus(boolean login) {
        isLoggedIn = login;
    }

    public boolean isSamePassword(String password) {
        return (this.password==password);
    }

    public abstract String getStats();
}
