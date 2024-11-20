package com.aws.aws_deployment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @GetMapping
    public ResponseEntity<String> getMessage()
    {
            return ResponseEntity.ok("Aws Deployment Successfully Completed");
    }
    @GetMapping("/name")
    public ResponseEntity<String> getName(@RequestParam String name)
    {
        return ResponseEntity.ok(String.format("Hello %s",name));
    }
}
