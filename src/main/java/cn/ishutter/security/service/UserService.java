package cn.ishutter.security.service;

import cn.ishutter.security.model.User;

/**
 * Created by chenyinpo on 2017/6/21.
 */

public interface UserService {
    User findById(int id);
    User findBySso(String sso);
}
