package com.example.demo.service;

import com.example.demo.entity.Referral;
import com.example.demo.entity.ReferralNotes;
import com.example.demo.entity.RegistrationForm;
import com.example.demo.repository.ReferralNotesRepository;
import com.example.demo.repository.ReferralRepository;
import com.example.demo.repository.RegistrationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReferralService {

    @Autowired
    private ReferralRepository referralRepository;

    @Autowired
    private ReferralNotesRepository referralNotesRepository;

    @Autowired
    private RegistrationFormRepository registrationFormRepository;

    public Referral createReferral(Long fromProfileId, Long toProfileId) {
        Optional<RegistrationForm> fromProfile = registrationFormRepository.findById(fromProfileId);
        Optional<RegistrationForm> toProfile = registrationFormRepository.findById(toProfileId);

        if (fromProfile.isEmpty() || toProfile.isEmpty()) {
            throw new IllegalArgumentException("Invalid profile IDs");
        }

        if (referralRepository.existsByFromProfileIdAndToProfileId(fromProfileId, toProfileId)) {
            throw new IllegalArgumentException("Referral already exists between these profiles");
        }

        Referral referral = new Referral();
        referral.setFromProfile(fromProfile.get());
        referral.setToProfile(toProfile.get());
        referral.setFromProfileStatus("Pending");
        referral.setToProfileStatus("Pending");

        return referralRepository.save(referral);
    }

    public Referral updateStatus(Long id, String fromProfileStatus, String toProfileStatus) {
        Optional<Referral> optionalReferral = referralRepository.findById(id);
        if (optionalReferral.isEmpty()) {
            throw new IllegalArgumentException("Referral not found");
        }

        Referral referral = optionalReferral.get();
        referral.setFromProfileStatus(fromProfileStatus);
        referral.setToProfileStatus(toProfileStatus);

        return referralRepository.save(referral);
    }

    public ReferralNotes addNote(Long referralId, String noteText, String createdBy) {
        Optional<Referral> optionalReferral = referralRepository.findById(referralId);
        if (optionalReferral.isEmpty()) {
            throw new IllegalArgumentException("Referral not found");
        }

        ReferralNotes note = new ReferralNotes();
        note.setReferral(optionalReferral.get());
        note.setNoteText(noteText);
        note.setCreatedBy(createdBy);

        return referralNotesRepository.save(note);
    }

    public List<Referral> getAllReferrals() {
        return referralRepository.findAll();
    }

    public List<ReferralNotes> getNotesByReferralId(Long referralId) {
        return referralNotesRepository.findByReferralId(referralId);
    }

    public List<Referral> getReferralsByProfileId(Long profileId) {
        return referralRepository.findByProfileId(profileId);
    }

    public Referral updateAdditionalFields(Long id, String thistootherprofile, String othertothisprofile, String bothconnections) {
        Optional<Referral> optionalReferral = referralRepository.findById(id);
        if (optionalReferral.isEmpty()) {
            throw new IllegalArgumentException("Referral not found");
        }

        Referral referral = optionalReferral.get();
        if (thistootherprofile != null) {
            referral.setThistootherprofile(thistootherprofile);
        }
        if (othertothisprofile != null) {
            referral.setOthertothisprofile(othertothisprofile);
        }
        if (bothconnections != null) {
            referral.setBothconnections(bothconnections);
        }

        return referralRepository.save(referral);
    }

    public boolean deleteReferral(Long id) {
        Optional<Referral> optionalReferral = referralRepository.findById(id);
        if (optionalReferral.isEmpty()) {
            return false;
        }
        // delete any notes associated with this referral first (if repository supports cascading you may skip)
        List<ReferralNotes> notes = referralNotesRepository.findByReferralId(id);
        if (notes != null && !notes.isEmpty()) {
            referralNotesRepository.deleteAll(notes);
        }
        referralRepository.deleteById(id);
        return true;
    }


    // Add this inside ReferralService.java

// public Referral getReferralById(Long id) {
//     return referralRepository.findById(id)
//             .orElseThrow(() -> new IllegalArgumentException("Referral not found with ID: " + id));
// }

public Referral getReferralById(Long id) {
        return referralRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Referral not found with ID: " + id));
    }

}
