package cn.ishutter.security.config;

import cn.ishutter.security.model.UserProfile;
import cn.ishutter.security.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


/**
 * Created by chenyinpo on 2017/6/22.
 */

@Component
public class RoleToUserProfileConverter implements Converter<Object,UserProfile> {

    @Autowired
    UserProfileService userProfileService;

    @Override
    public UserProfile convert(Object element){
        Integer id = Integer.parseInt((String) element);
        UserProfile profile = userProfileService.findById(id);
        return profile;
    }



}
