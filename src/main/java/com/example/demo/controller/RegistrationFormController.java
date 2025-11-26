package com.example.demo.controller;

import com.example.demo.dto.RegistrationRequest;
import com.example.demo.entity.RegistrationForm;
import com.example.demo.service.RegistrationFormService;
import com.example.demo.entity.RegistrationFormNotes;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
// @CrossOrigin(origins = "https://bandhammatrimony.com")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/registration")
public class RegistrationFormController {

    @Autowired
    private RegistrationFormService registrationFormService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@ModelAttribute RegistrationRequest request) {
        try {
            RegistrationForm savedForm = registrationFormService.saveRegistration(request);
            return ResponseEntity.ok(""+savedForm.getId());
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

@PutMapping("/forms/{id}")
public ResponseEntity<?> updateRegistrationForm(@PathVariable Long id, @ModelAttribute RegistrationRequest request) {
    try {
        RegistrationForm updatedForm = registrationFormService.updateRegistration(id, request);
        if (updatedForm != null) {
            return ResponseEntity.ok("Registration form updated successfully! ID: " + updatedForm.getId());
        } else {
            return ResponseEntity.notFound().build();
        }
    } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().body("Validation Error: " + e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error: " + e.getMessage());
    }
}

    @PutMapping("/forms/{id}/text-update")
    public ResponseEntity<?> updateTextFieldsOnly(@PathVariable Long id, @ModelAttribute RegistrationRequest request) {
        try {
            RegistrationForm updatedForm = registrationFormService.updateTextFieldsOnly(id, request);
            if (updatedForm != null) {
                return ResponseEntity.ok("Registration form text fields updated successfully! ID: " + updatedForm.getId());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }

    @PatchMapping("/forms/{id}/field")
    public ResponseEntity<?> updateSingleField(@PathVariable Long id, @RequestParam String fieldName, @RequestParam String fieldValue) {
        try {
            RegistrationForm updatedForm = registrationFormService.updateSingleField(id, fieldName, fieldValue);
            if (updatedForm != null) {
                return ResponseEntity.ok("Field '" + fieldName + "' updated successfully! ID: " + updatedForm.getId());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/forms/{id}")
    public ResponseEntity<?> deleteRegistrationForm(@PathVariable Long id) {
        try {
            boolean deleted = registrationFormService.deleteRegistrationForm(id);
            if (deleted) {
                return ResponseEntity.ok("Registration form deleted successfully. ID: " + id);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/forms/{id}/notes")
    public ResponseEntity<?> addNote(@PathVariable Long id, @RequestBody Map<String, String> request) {
        try {
            String noteText = request.get("noteText");
            String createdBy = request.get("createdBy");
            if (noteText == null || createdBy == null) {
                return ResponseEntity.badRequest().body("noteText and createdBy are required");
            }
            RegistrationFormNotes note = registrationFormService.addNote(id, noteText, createdBy);
            return ResponseEntity.ok(note);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/forms/{id}/notes")
    public ResponseEntity<?> getNotes(@PathVariable Long id) {
        try {
            java.util.List<RegistrationFormNotes> notes = registrationFormService.getNotesByRegistrationFormId(id);
            return ResponseEntity.ok(notes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/forms/notes/{noteId}")
    public ResponseEntity<?> deleteNote(@PathVariable Long noteId) {
        try {
            boolean deleted = registrationFormService.deleteNote(noteId);
            if (deleted) {
                return ResponseEntity.ok("Note deleted successfully. ID: " + noteId);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/forms/{id}/image3")
    public ResponseEntity<?> updateImage3(@PathVariable Long id, @RequestParam("image3") MultipartFile image3) {
        try {
            RegistrationForm updatedForm = registrationFormService.updateImage3(id, image3);
            if (updatedForm != null) {
                return ResponseEntity.ok("Image3 uploaded successfully! ID: " + updatedForm.getId());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }
}
