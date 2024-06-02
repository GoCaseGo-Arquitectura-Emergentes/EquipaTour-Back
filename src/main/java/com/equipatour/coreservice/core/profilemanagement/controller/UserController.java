package com.equipatour.coreservice.core.profilemanagement.controller;

import com.equipatour.coreservice.core.profilemanagement.beans.UserBean;
import com.equipatour.coreservice.core.profilemanagement.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// import com.google.gson.Gson;


@Log4j2
@Api
@RestController
@RequestMapping("/service/user")
@Tag(name = "UserController", description = "User EndPoint")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

//    @Autowired
//    private Gson gson;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: ", e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long userId) {
        try {
            return new ResponseEntity<>(userService.getById(userId), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: ", e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody UserBean userBean) {
        try {
            userService.createUser(userBean);
            return new ResponseEntity<>("created", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long userId, @RequestBody UserBean userBean) {
        try {
            userService.updateUser(userId, userBean);
            return new ResponseEntity<>("updated", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long userId) {
        try {
            userService.deleteUser(userId);
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}