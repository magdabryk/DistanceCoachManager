package pl.camp.it.distance.coaching.manager.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Repository
@Entity(name = "tuser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String login;
    private String password;
    private String email;

    public static class UserBuilder {
        User user = new User();

        public UserBuilder id(int id) {
            this.user.setId(id);
            return this;
        }

        public UserBuilder name(String name) {
            this.user.setName(name);
            return this;
        }

        public UserBuilder surname(String surname) {
            this.user.setSurname(surname);
            return this;
        }

        public UserBuilder login(String login) {
            this.user.setLogin(login);
            return this;
        }

        public UserBuilder password(String password) {
            this.user.setPassword(password);
            return this;
        }

        public UserBuilder email(String email) {
            this.user.setEmail(email);
            return this;}

            public User build () {
                return this.user;
            }

            public UserBuilder clone (User user){
                id(user.getId())
                        .name(user.getName())
                        .surname(user.getSurname())
                        .login(user.getLogin())
                        .password(user.getPassword())
                        .email(user.getEmail());
                return this;
        }
    }
}


