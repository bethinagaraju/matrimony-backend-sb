package com.example.demo.controller;

import com.example.demo.entity.Referral;
import com.example.demo.entity.ReferralNotes;
import com.example.demo.service.ReferralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @CrossOrigin(origins = "https://bandhammatrimony.com")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/referrals")
public class ReferralController {

    @Autowired
    private ReferralService referralService;

    @PostMapping
    public ResponseEntity<?> createReferral(@RequestBody Map<String, Long> request) {
        try {
            Long fromProfileId = request.get("fromProfileId");
            Long toProfileId = request.get("toProfileId");
            if (fromProfileId == null || toProfileId == null) {
                return ResponseEntity.badRequest().body("fromProfileId and toProfileId are required");
            }
            Referral referral = referralService.createReferral(fromProfileId, toProfileId);
            return ResponseEntity.ok(referral);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> request) {
        try {
            String fromProfileStatus = request.get("fromProfileStatus");
            String toProfileStatus = request.get("toProfileStatus");
            if (fromProfileStatus == null || toProfileStatus == null) {
                return ResponseEntity.badRequest().body("fromProfileStatus and toProfileStatus are required");
            }
            Referral referral = referralService.updateStatus(id, fromProfileStatus, toProfileStatus);
            return ResponseEntity.ok(referral);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/{id}/notes")
    public ResponseEntity<?> addNote(@PathVariable Long id, @RequestBody Map<String, String> request) {
        try {
            String noteText = request.get("noteText");
            String createdBy = request.get("createdBy");
            if (noteText == null || createdBy == null) {
                return ResponseEntity.badRequest().body("noteText and createdBy are required");
            }
            ReferralNotes note = referralService.addNote(id, noteText, createdBy);
            return ResponseEntity.ok(note);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Referral>> getAllReferrals() {
        List<Referral> referrals = referralService.getAllReferrals();
        return ResponseEntity.ok(referrals);
    }

    @GetMapping("/{id}/notes")
    public ResponseEntity<?> getNotes(@PathVariable Long id) {
        try {
            List<ReferralNotes> notes = referralService.getNotesByReferralId(id);
            return ResponseEntity.ok(notes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/profile/{profileId}")
    public ResponseEntity<?> getReferralsByProfileId(@PathVariable Long profileId) {
        try {
            List<Referral> referrals = referralService.getReferralsByProfileId(profileId);
            return ResponseEntity.ok(referrals);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}/additional-fields")
    public ResponseEntity<?> updateAdditionalFields(@PathVariable Long id, @RequestBody Map<String, String> request) {
        try {
            String thistootherprofile = request.get("thistootherprofile");
            String othertothisprofile = request.get("othertothisprofile");
            String bothconnections = request.get("bothconnections");
            Referral referral = referralService.updateAdditionalFields(id, thistootherprofile, othertothisprofile, bothconnections);
            return ResponseEntity.ok(referral);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReferral(@PathVariable Long id) {
        try {
            boolean deleted = referralService.deleteReferral(id);
            if (deleted) {
                return ResponseEntity.ok("Referral deleted successfully. ID: " + id);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }



    // Add this inside ReferralController.java

@GetMapping("/{id}")
public ResponseEntity<?> getReferralById(@PathVariable Long id) {
    try {
        Referral referral = referralService.getReferralById(id);
        return ResponseEntity.ok(referral);
    } catch (IllegalArgumentException e) {
        // Return 404 Not Found if the ID doesn't exist
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
    }
}


@GetMapping("/{id}/status-details")
    public ResponseEntity<?> getReferralStatusDetails(@PathVariable Long id) {
        try {
            // 1. Fetch the full referral using your service
            // (Assumes you added the getReferralById method to Service from the previous step)
            // If you haven't added it, use referralService.getReferralById(id) logic here directly.
            Referral referral = referralService.getReferralById(id); 

            // 2. Create a map to hold ONLY the specific fields you want
            Map<String, String> response = new HashMap<>();
            
            response.put("fromProfileStatus", referral.getFromProfileStatus());
            response.put("toProfileStatus", referral.getToProfileStatus());
            response.put("thistootherprofile", referral.getThistootherprofile());
            response.put("othertothisprofile", referral.getOthertothisprofile());
            response.put("bothconnections", referral.getBothconnections());

            // 3. Return the filtered map
            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

}
