package com.aws.aws_deployment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/*
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @GetMapping
    public ResponseEntity<String> getMessage()
    {
            return ResponseEntity.ok("Aws Deployment Successfully Completed");
    }
    @GetMapping("/dev")
    public ResponseEntity<String> get()
    {
        return ResponseEntity.ok("Oğuzhan SEÇGEL");
    }
    @GetMapping("/name")
    public ResponseEntity<String> getName(@RequestParam String name)
    {
        return ResponseEntity.ok(String.format("Hello %s",name));
    }
}
*/
@Controller
public class MessageController {

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/dev")
    public String getDev() {
        return "dev";
    }

    @GetMapping("/name")
    public String getName(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}