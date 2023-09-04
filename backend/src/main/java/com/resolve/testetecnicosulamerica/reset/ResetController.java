package com.resolve.testetecnicosulamerica.reset;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "reset")
public class ResetController {

    private ResetService resetService;

    @PostMapping
    public ResponseEntity<String> reset(){
            this.resetService.reset();
            return ResponseEntity.status(200).body("OK");
    }

}