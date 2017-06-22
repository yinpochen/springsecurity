package cn.ishutter.security.dao;

import cn.ishutter.security.model.User;

/**
 * Created by chenyinpo on 2017/6/21.
 */
public interface UserDao {
    User findById(int id);
    User findBySSO(String sso);
}
