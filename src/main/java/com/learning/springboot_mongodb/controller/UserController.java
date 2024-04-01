package com.learning.springboot_mongodb.controller;

import com.learning.springboot_mongodb.entity.User;
import com.learning.springboot_mongodb.service.impl.EmployeeServiceImpl;
import com.learning.springboot_mongodb.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/index")
    public String listOfUsers(Model model){
        model.addAttribute("user",userService.getAllUsers());
        return "users";
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody User user){
        return userService.newUser(user);
    }
}
