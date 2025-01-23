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

    @Column(name = "Last_Name")
    private String Last_Name;

    @Column(name = "Age")
    private int Age;

    @Column(name = "Email")
    private String Email;

    public User() {
    }

    public User(int id, String Name, String Last_Name, int Age, String Email) {

        this.id=id;
        this.Name = Name;
        this.Last_Name = Last_Name;
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
    public String getLast_Name() {
        return Last_Name;
    }
    public void setLast_Name(String Last_name) {
        this.Last_Name = Last_Name;
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
                ", Last_Name='" + Last_Name + '\'' +
                ", age=" + Age +
                ", email='" + Email + '\'' +
                '}';
    }
}





