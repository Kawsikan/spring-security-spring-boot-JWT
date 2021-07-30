package com.service.springsecurityjwt;

import com.service.springsecurityjwt.domain.Role;
import com.service.springsecurityjwt.domain.User;
import com.service.springsecurityjwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Kawsikan Kumaralingam", "Kawsikan", "1234", new ArrayList<>()));
            userService.saveUser(new User(null,"Michael John","Michael","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Pamal Ranasinghe ","Pamal","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Jeyakody Didula","Jeyakody","1234",new ArrayList<>()));

            userService.addRoleToUser("Kawsikan","ROLE_SUPER_ADMIN");
            userService.addRoleToUser("Kawsikan","ROLE_USER");
            userService.addRoleToUser("Kawsikan","ROLE_MANAGER");
            userService.addRoleToUser("Michael","ROLE_MANAGER");
            userService.addRoleToUser("Pamal","ROLE_ADMIN");
            userService.addRoleToUser("Jeyakody","ROLE_USER");



        };
    }

}
