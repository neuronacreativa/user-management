package org.nc.usermanagement.infrastructure.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("backend")
public class UserController {

    @GetMapping("/")
    public String home() {
        // TODO: Add Users and Roles Lists
        // TODO: and Users and Roles creation forms
        // TODO: Add Tests
        return "home";
    }

}
