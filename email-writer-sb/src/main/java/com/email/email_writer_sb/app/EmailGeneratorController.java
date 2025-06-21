package com.email.email_writer_sb.app;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class EmailGeneratorController {

    private final EmailGeneratorService emailGeneratorService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest) {
        String response = emailGeneratorService.generateEmailReply(emailRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from SmartEmailReplyAssistant!";
    }

    @GetMapping("/test")
    public String test() {
        return "SmartEmailReplyAssistant backend is running!";
    }
}
