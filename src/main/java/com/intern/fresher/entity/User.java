package com.intern.fresher.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Primary;

import java.util.UUID;

@Entity
@Table(name = "UserData", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue
    @Column(name = "userid")
    private UUID userid;

    @Column(name = "username")
    private String username;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "avatar")
    private String avatar;

    @Column(name =  "address")
    private String address;

    @Column(name = "age")
    private int age;
}
