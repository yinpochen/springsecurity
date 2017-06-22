package cn.ishutter.security.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by chenyinpo on 2017/6/21.
 */
@Entity
@Table(name = "USER_PROFILE")
@Data
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TYPE",length = 15,unique = true,nullable = false)
    private String type = UserProfileType.USER.getUserProfileType();





}
