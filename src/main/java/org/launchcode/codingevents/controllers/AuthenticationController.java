package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

    @Controller
    public class AuthenticationController {

        @Autowired
        UserRepository userRepository;

    }

