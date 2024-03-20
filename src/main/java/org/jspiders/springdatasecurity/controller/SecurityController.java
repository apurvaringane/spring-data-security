package org.jspiders.springdatasecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SecurityController {
    @GetMapping("/message")
    public String getMessage()
    {
        return "welcome";
    }

    @GetMapping("/admin")
    public String getAdminPage()
    {
        return "admin";
    }

    @GetMapping("/hr")
    public String getHrPage()
    {
        return "hr";
    }

    @GetMapping("/tracker")
    public String getTrackerPage()
    {
        return "tracker";
    }
}
