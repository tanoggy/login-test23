package rebo.vn.logintest23.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rebo.vn.logintest23.config.ApiResponse;
import rebo.vn.logintest23.model.database.User;
import rebo.vn.logintest23.model.rest.UserRest;
import rebo.vn.logintest23.service.UserServiceImp;

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

    @GetMapping
    public ApiResponse<List<User>> listUser() {
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.", userService.findAll());
    }


    @GetMapping
    @RequestMapping("/test")
    public String test() {
        return "ahihi ok";
    }


}
