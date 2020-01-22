package rebo.vn.logintest23.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rebo.vn.logintest23.config.ApiResponse;
import rebo.vn.logintest23.model.database.User;
import rebo.vn.logintest23.model.rest.UserRest;
import rebo.vn.logintest23.repository.UserRepository;
import rebo.vn.logintest23.security.JwtTokenUtil;
import rebo.vn.logintest23.service.UserServiceImp;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImp userService;


    @PostMapping
    @RequestMapping("/register")
    public ApiResponse saveUser(@RequestBody UserRest user) {
        User userResponse = userService.saveToDb(user);

        ApiResponse response = new ApiResponse(HttpStatus.OK.value(),
                "Đăng ký thành công", userResponse);
        return response;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping
    public String listUser(HttpServletRequest req) {
//        String email = JwtTokenUtil.getEmailFromRequest(req);
        return "Has role ADMIN";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/role-user", method = RequestMethod.GET)
    @GetMapping
    public String returnUser() {
//        String email = JwtTokenUtil.getEmailFromRequest(req);
        return "Has role USER";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/role-admin", method = RequestMethod.GET)
    @GetMapping
    public String returnAdmin() {
//        String email = JwtTokenUtil.getEmailFromRequest(req);
        return "Has role ADMIN";
    }



    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getUserList() {
        return userService.findAll();
    }


}
