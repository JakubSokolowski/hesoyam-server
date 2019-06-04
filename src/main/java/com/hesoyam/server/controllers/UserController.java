package com.hesoyam.server.controllers;

import com.hesoyam.server.models.User;
import com.hesoyam.server.service.UserService;
import com.hesoyam.server.validation.RegistrationValidateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController{

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertUser(@Validated({RegistrationValidateGroup.class}) @RequestBody User user){
        if(userService.save(user)){
            return new ResponseEntity<String>("You have successfully registered!", HttpStatus.OK);
        }
        else
            return new ResponseEntity<String[]>( new String[] {"Someone already has that username!"} ,
                            HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public void loginUser(){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
