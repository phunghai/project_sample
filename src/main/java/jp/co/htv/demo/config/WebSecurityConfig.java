package jp.co.htv.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import jp.co.htv.demo.service.UserDetailsServiceImpl;

/**
 * Web security configuration class
 * @author Nguyen Phung Hai
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;
	
	/**
	 * default constructor
	 */
    public WebSecurityConfig() {
        super();
    }


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login.html")
                .failureUrl("/login-error.html")
            .and()
                .logout()
                .logoutSuccessUrl("/index.html")
            .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/shared/**").hasAnyRole("USER","ADMIN")
            .and()
                .exceptionHandling()
                .accessDeniedPage("/403.html");

    }


    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()); 
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
