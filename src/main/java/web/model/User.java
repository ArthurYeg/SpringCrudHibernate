package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Last_name")
    private String Last_name;

    @Column(name = "Age")
    private int Age;

    @Column(name = "Email")
    private String Email;

    public User() {
    }

    public User(int id, String Name, String Last_name, int Age, String Email) {

        this.id=id;
        this.Name = Name;
        this.Last_name = Last_name;
        this.Age = Age;
        this.Email = Email;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public String getLast_name() {
        return Last_name;
    }
    public void setLast_name(String Last_name) {
        this.Last_name = Last_name;
    }
    public int getAge() {
        return Age;
    }
    public void setAge(int Age) {
        this.Age = Age;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {

        return "User{" +
                "id=" + id +
                ", name='" + Name + '\'' +
                ", last_name='" + Last_name + '\'' +
                ", age=" + Age +
                ", email='" + Email + '\'' +
                '}';
    }
}





