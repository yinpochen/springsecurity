package cn.ishutter.security.model;

import lombok.Data;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenyinpo on 2017/6/21.
 */
@Entity
@Table(name="APP_USER")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "SSO_ID",unique = true,nullable = false)
    private String ssoid;
    @Column(name = "PASSWORD",nullable = false)
    private String password;
    @Column(name = "FIRST_NAME",nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME",nullable = false)
    private String lastName;
    @Column(name = "EMAIL",nullable = false)
    private String email;
    @Column(name = "STATE",nullable = false)
    private String state = State.ACTIVE.getState();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "APP_USER_USER_PROFILE",
               joinColumns = {@JoinColumn(name = "USER_ID")},
               inverseJoinColumns = {@JoinColumn(name = "USER_PROFILE_ID")}
              )
    private Set<UserProfile> userProfiles  = new HashSet<UserProfile>();
}
