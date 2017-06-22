package cn.ishutter.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by chenyinpo on 2017/6/20.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    /*@Autowired
    public void configGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("bruce").password("abc123").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("dba").password("dba123").roles("ADMIN","DBA");
    }*/
    @Autowired
    @Qualifier("customUserDetailsService")
    public UserDetailsService userDetailsService;

    @Autowired
    public void configGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }



 /*   @Autowired
    private CustomSuccessHandler customSuccessHandler;
*/

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/","/home").permitAll()
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/dba/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .and().formLogin().loginPage("/login") //.successHandler(customSuccessHandler)
                .usernameParameter("ssoid").passwordParameter("password")
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }

}
