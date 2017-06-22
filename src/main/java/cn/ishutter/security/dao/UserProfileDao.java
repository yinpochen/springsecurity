package cn.ishutter.security.dao;

import cn.ishutter.security.model.UserProfile;

import java.util.List;

/**
 * Created by chenyinpo on 2017/6/22.
 */
public interface UserProfileDao {
    List<UserProfile> findAll();
    UserProfile findByType(String type);
    UserProfile findById(int id);
}
