package hello.toby.user.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {

    private String id;
    private String name;
    private String password;

    public User() {
    }

    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
