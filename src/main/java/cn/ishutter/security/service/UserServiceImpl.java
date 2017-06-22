package cn.ishutter.security.service;

import cn.ishutter.security.dao.UserDao;
import cn.ishutter.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chenyinpo on 2017/6/21.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

   @Autowired
   private UserDao userDao;

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public User findBySso(String sso) {
        return userDao.findBySSO(sso);
    }
}
