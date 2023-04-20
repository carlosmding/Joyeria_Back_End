package co.shop.luxury.model;

import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@NamedQuery(name="User.findByEmailId", query = "select u from User u where u.email=:email")
@NamedQuery(name="User.getAllUser", query = "select new co.shop.luxury.wrapper.UserWrapper(u.id, u.name, u.email, u.contactNumber, u.status) from User u where u.role='user'" )
@NamedQuery(name="User.updateStatus", query = "update User u set u.status=:status where u.id=:id" )
@NamedQuery(name="User.getAllAdmin", query = "select u.email from User u where u.role='admin'" )

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table (name = "user")
public class User {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column (name = "contactNumber")
    private String contactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;

    @Column(name = "role")
    private String role;


}