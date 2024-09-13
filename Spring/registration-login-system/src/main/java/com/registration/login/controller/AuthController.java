package com.registration.login.controller;

import com.registration.login.dto.UserDto;
import com.registration.login.entity.User;
import com.registration.login.service.UserService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.*;
import java.util.List;

@Controller
@AllArgsConstructor
public class AuthController {

    private UserService userService;


    //handler method to handle home page request
    @GetMapping("/index")
    public String home()
    {
         return "index";
    }


    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model)
    {
        //create model to store the data
        UserDto user = new UserDto();
        model.addAttribute("user",user);

        return "register";
    }



    //handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model)
    {
        User existingUser = userService.findUserByEmail(userDto.getEmail());
        if(existingUser != null)
        {
            result.rejectValue("email",null,"User Already Exists With this mail");
        }

        if (result.hasErrors())
        {
            model.addAttribute("user",userDto);
            return "register";
        }
        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    //handler method to get all users request
    @GetMapping("/users")
    public String allUsers(Model model)
    {
        List<UserDto> userDtos = userService.findAllUsers();
        model.addAttribute("users",userDtos);
        return "users";
    }

    //handler method to handle login request

    @GetMapping("/login")
    public String login(){
        return "login";
    }



}
