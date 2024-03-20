package org.jspiders.springdatasecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    @GetMapping("/access-denied")
    public String getAccessDeniedPage()
    {
        return "access-denied";
    }
}

