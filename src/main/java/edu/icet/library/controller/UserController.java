package edu.icet.library.controller;

import edu.icet.library.model.User;
import edu.icet.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    final UserService service;
    //-------------------------------------
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody User user){
        service.addUser(user);
    }
    @GetMapping("/all")
    public List<User> all(){
        List<User> all = service.all();
        System.out.println(all);
        return all;
    }
}
