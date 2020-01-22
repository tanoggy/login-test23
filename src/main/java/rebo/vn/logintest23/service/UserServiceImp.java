package rebo.vn.logintest23.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rebo.vn.logintest23.model.database.User;
import rebo.vn.logintest23.model.rest.UserRest;
import rebo.vn.logintest23.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service(value = "userService")
public class UserServiceImp implements UserDetailsService {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userDao.findById(email);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(email);
        }
        User userGet = user.get();

        return new org.springframework.security.core.userdetails.User(userGet.getUserEmail(), userGet.getUserPassword(), getAuthority(userGet));


    }

    private List<SimpleGrantedAuthority> getAuthority(User user) {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + user.getRoleId().toUpperCase()));
    }


    public User saveToDb(UserRest user) {
        User newUser = new User();

        newUser.setUserEmail(user.getUserEmail());
        newUser.setUserFullName(user.getUserFullName());
        newUser.setUserPhone(user.getUserPhone());
        newUser.setUserPassword(bcryptEncoder.encode(user.getUserPassword()));
        newUser.setUserIsActive(true);
        newUser.setRoleId("User");

        return userDao.save(newUser);
    }


    public User findOne(String email) {
        return userDao.getOne(email);

    }

    public List<User> findAll() {

        return userDao.findAll();
    }




}
