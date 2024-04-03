package com.learning.springboot_mongodb.controller;

import com.learning.springboot_mongodb.entity.User;
import com.learning.springboot_mongodb.service.impl.EmployeeServiceImpl;
import com.learning.springboot_mongodb.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @GetMapping("/users")
    public String listOfUsers(Model model){
        model.addAttribute("user",userService.getAllUsers());
        return "users";
    }


    @GetMapping("/user/new")
    public String createUserForm(){
        return "create_user";
    }

    @PostMapping("/user/new/add")
    public String saveUser(@ModelAttribute("user") User user){
        userService.createUser(user);
        return "redirect:/users";
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

}
