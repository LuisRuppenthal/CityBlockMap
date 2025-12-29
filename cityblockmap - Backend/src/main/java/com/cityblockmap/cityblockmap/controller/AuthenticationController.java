package com.cityblockmap.cityblockmap.controller;

import com.cityblockmap.cityblockmap.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate")
    public String authenticate(){
        return authenticationService.authenticate();
    }

}
