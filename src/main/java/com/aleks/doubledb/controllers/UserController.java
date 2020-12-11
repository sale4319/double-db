package com.aleks.doubledb.controllers;

import com.aleks.doubledb.models.User;
import com.aleks.doubledb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/oneuser")
    @ResponseBody
    public Optional<User> getUserById(Integer Id, Model model) {
        return userService.getUserById(Id);
    }

    @RequestMapping(value="/save", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value="/addNew", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
    public String addUser(@Valid User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "redirect:/users";
        }
        /*if(userService.checkUser(user.getId())){
            model.addAttribute("exist", true);
            return "redirect:/home";
        }*/

        userService.addUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    public String deleteUser(Integer Id) {
        userService.deleteUser(Id);
        return "redirect:/users";
    }

}

