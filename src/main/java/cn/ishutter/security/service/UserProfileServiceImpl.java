package cn.ishutter.security.service;

import cn.ishutter.security.dao.UserProfileDao;
import cn.ishutter.security.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chenyinpo on 2017/6/22.
 */
@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileDao userProfileDao;

    @Override
    public UserProfile findById(Integer id) {
        return userProfileDao.findById(id);
    }

    @Override
    public List<UserProfile> findAll() {
        return userProfileDao.findAll();
    }

    @Override
    public UserProfile findByType(String type) {
        return userProfileDao.findByType(type);
    }
}
