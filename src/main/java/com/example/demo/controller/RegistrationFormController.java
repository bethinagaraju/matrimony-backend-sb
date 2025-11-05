package com.example.demo.controller;

import com.example.demo.dto.RegistrationRequest;
import com.example.demo.entity.RegistrationForm;
import com.example.demo.service.RegistrationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/registration")
public class RegistrationFormController {

    @Autowired
    private RegistrationFormService registrationFormService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@ModelAttribute RegistrationRequest request) {
        try {
            RegistrationForm savedForm = registrationFormService.saveRegistration(request);
            return ResponseEntity.ok("Registration successful! ID: " + savedForm.getId());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/forms")
    public ResponseEntity<List<RegistrationForm>> getAllRegistrationForms() {
        List<RegistrationForm> forms = registrationFormService.getAllRegistrationForms();
        return ResponseEntity.ok(forms);
    }

    @GetMapping("/forms/{id}")
    public ResponseEntity<?> getRegistrationFormById(@PathVariable Long id) {
        RegistrationForm form = registrationFormService.getRegistrationFormById(id);
        if (form != null) {
            return ResponseEntity.ok(form);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/forms/{id}/pricecharging")
    public ResponseEntity<?> updatePriceCharging(@PathVariable Long id, @RequestBody String newPriceCharging) {
        RegistrationForm updatedForm = registrationFormService.updatePriceCharging(id, newPriceCharging);
        if (updatedForm != null) {
            return ResponseEntity.ok("Price charging updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
