package cn.ishutter.security.service;

import cn.ishutter.security.model.UserProfile;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chenyinpo on 2017/6/22.
 */

@Component
public interface UserProfileService {
    UserProfile findById(Integer id);
    List<UserProfile> findAll();
    UserProfile findByType(String type);
}
