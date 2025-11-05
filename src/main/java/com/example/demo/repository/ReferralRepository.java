package com.example.demo.repository;

import com.example.demo.entity.Referral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferralRepository extends JpaRepository<Referral, Long> {

    @Query("SELECT r FROM Referral r WHERE r.fromProfile.id = :profileId OR r.toProfile.id = :profileId")
    List<Referral> findByProfileId(@Param("profileId") Long profileId);

    @Query("SELECT r FROM Referral r WHERE r.fromProfile.id = :profileId")
    List<Referral> findReferralsFromProfile(@Param("profileId") Long profileId);

    @Query("SELECT r FROM Referral r WHERE r.toProfile.id = :profileId")
    List<Referral> findReferralsToProfile(@Param("profileId") Long profileId);

    @Query("SELECT COUNT(r) > 0 FROM Referral r WHERE (r.fromProfile.id = :fromProfileId AND r.toProfile.id = :toProfileId) OR (r.fromProfile.id = :toProfileId AND r.toProfile.id = :fromProfileId)")
    boolean existsByFromProfileIdAndToProfileId(@Param("fromProfileId") Long fromProfileId, @Param("toProfileId") Long toProfileId);
}
