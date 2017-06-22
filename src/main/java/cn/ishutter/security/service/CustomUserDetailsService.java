package cn.ishutter.security.service;

import cn.ishutter.security.model.User;
import cn.ishutter.security.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyinpo on 2017/6/21.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String ssoid) throws UsernameNotFoundException {
        User user = userService.findBySso(ssoid);
        if(user == null){
            throw new UsernameNotFoundException("User name not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getSsoid(),user.getPassword(),user.getState().equals("Active")
                    ,true,true,true,getGrantedAuthorities(user));
    }

    private List<? extends GrantedAuthority> getGrantedAuthorities(User user) {
       List<GrantedAuthority> authorities = new ArrayList<>();
       for(UserProfile userProfile: user.getUserProfiles()){
           authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
       }
       return authorities;
    }
}
