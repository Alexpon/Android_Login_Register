package mbp.alexpon.com.login_register;

/**
 * Created by apple on 15/7/30.
 */
public class User {
    String name, username, password;
    int age;

    public User(String name, int age, String username, String password){
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password){
        this.name = "";
        this.age = -1;
        this.username = username;
        this.password = password;
    }



}
