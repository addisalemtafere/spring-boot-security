package com.example.demo;

import com.example.demo.entities.Role;
import com.example.demo.entities.Users;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}

	@Autowired
	public void autheticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository) throws Exception {

	    if (userRepository.count()==0){
	        userRepository.save(new Users("user","user", Arrays.asList(new Role("user"))));
        }

//        builder.inMemoryAuthentication()
//                .withUser("user").password("user").roles("user");

        builder.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
                return new CustomUserDetials (userRepository.findByUserName(s));
            }
        });
    }
}
