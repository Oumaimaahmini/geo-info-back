package com.geoInfo.project.service;

import com.geoInfo.project.dao.UserRepository;
import com.geoInfo.project.model.Intermediaire;
import com.geoInfo.project.security.UserDetailsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService  implements UserDetailsService {

    @Autowired
    private UserRepository iuser ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("userDetails called");
        Optional<Intermediaire> user = iuser.findByUsername(username);

        user.orElseThrow(()->new UsernameNotFoundException("not found"));
        System.out.println(user) ;
        return user.map(UserDetailsImp::new).get();
    }

}
