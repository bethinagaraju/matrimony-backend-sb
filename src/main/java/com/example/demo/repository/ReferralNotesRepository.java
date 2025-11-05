package com.example.demo.repository;

import com.example.demo.entity.ReferralNotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferralNotesRepository extends JpaRepository<ReferralNotes, Long> {
    List<ReferralNotes> findByReferralId(Long referralId);
}
