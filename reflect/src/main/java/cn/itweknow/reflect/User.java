package cn.itweknow.reflect;

public class User {

    private int id;

    private String userName;

    public User() {
    }

    private User(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private void sayHello(String value) {
        System.out.println("Hello," + value);
    }
}
