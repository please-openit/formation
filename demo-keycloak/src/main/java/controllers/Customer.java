package controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/customers")
public class Customer {

    @GetMapping(path = "/")
    public String customers(Principal principal, Model model) {
        return "customers";
    }
}
