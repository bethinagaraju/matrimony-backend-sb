package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "registration_form")
public class RegistrationForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Mandatory fields
    private String profileFor;
    private String firstName;

    // Adding optional salary field
    private String salary;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String email;
    private String areaCode;
    private String phoneNumber;
    private String placeOfBirthCity;
    
    private String height;
    private String country;
    private String city;
    private String caste;
    private Boolean openToAllCaste;
    private String ancestralPlace;
    private String maritalStatus;
    private String fatherName;
    private String fatherProfession;
    private String motherName;
    private String motherProfession;
    private String education;
    private String collegeName;
    private String occupation;
    private String image1Path;
    private String image2Path;
    private String additionalInfo;
    private String filledBy;
    private String drinkingHabit;
    private String smokingHabit;
    private String foodHabits;

    // Optional fields
    private LocalTime timeOfBirth;
    private String siblings;
    private String siblingDetails;
    private String rasi;
    private String gothram;
    private String nakshatram;
    private String image3Path;
    private String image4Path;
    private String image5Path;
    private String pricecharging;
    private String education2;
    private String education3;
    private String collegeName2;
    private String collegeName3;
    private String sibling2;
    private String sibling3;
    private String sibling2info;
    private String sibling3info;

    @OneToMany(mappedBy = "registrationForm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistrationFormNotes> notes = new ArrayList<>();

    // Default constructor
    public RegistrationForm() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfileFor() {
        return profileFor;
    }

    public void setProfileFor(String profileFor) {
        this.profileFor = profileFor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPlaceOfBirthCity() {
        return placeOfBirthCity;
    }

    public void setPlaceOfBirthCity(String placeOfBirthCity) {
        this.placeOfBirthCity = placeOfBirthCity;
    }



    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public Boolean getOpenToAllCaste() {
        return openToAllCaste;
    }

    public void setOpenToAllCaste(Boolean openToAllCaste) {
        this.openToAllCaste = openToAllCaste;
    }

    public String getAncestralPlace() {
        return ancestralPlace;
    }

    public void setAncestralPlace(String ancestralPlace) {
        this.ancestralPlace = ancestralPlace;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherProfession() {
        return fatherProfession;
    }

    public void setFatherProfession(String fatherProfession) {
        this.fatherProfession = fatherProfession;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherProfession() {
        return motherProfession;
    }

    public void setMotherProfession(String motherProfession) {
        this.motherProfession = motherProfession;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getImage1Path() {
        return image1Path;
    }

    public void setImage1Path(String image1Path) {
        this.image1Path = image1Path;
    }

    public String getImage2Path() {
        return image2Path;
    }

    public void setImage2Path(String image2Path) {
        this.image2Path = image2Path;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getFilledBy() {
        return filledBy;
    }

    public void setFilledBy(String filledBy) {
        this.filledBy = filledBy;
    }

    public String getDrinkingHabit() {
        return drinkingHabit;
    }

    public void setDrinkingHabit(String drinkingHabit) {
        this.drinkingHabit = drinkingHabit;
    }

    public String getSmokingHabit() {
        return smokingHabit;
    }

    public void setSmokingHabit(String smokingHabit) {
        this.smokingHabit = smokingHabit;
    }

    public String getFoodHabits() {
        return foodHabits;
    }

    public void setFoodHabits(String foodHabits) {
        this.foodHabits = foodHabits;
    }

    public LocalTime getTimeOfBirth() {
        return timeOfBirth;
    }

    public void setTimeOfBirth(LocalTime timeOfBirth) {
        this.timeOfBirth = timeOfBirth;
    }

    public String getSiblings() {
        return siblings;
    }

    public void setSiblings(String siblings) {
        this.siblings = siblings;
    }

    public String getSiblingDetails() {
        return siblingDetails;
    }

    public void setSiblingDetails(String siblingDetails) {
        this.siblingDetails = siblingDetails;
    }

    public String getRasi() {
        return rasi;
    }

    public void setRasi(String rasi) {
        this.rasi = rasi;
    }

    public String getGothram() {
        return gothram;
    }

    public void setGothram(String gothram) {
        this.gothram = gothram;
    }

    public String getNakshatram() {
        return nakshatram;
    }

    public void setNakshatram(String nakshatram) {
        this.nakshatram = nakshatram;
    }

    public String getImage3Path() {
        return image3Path;
    }

    public void setImage3Path(String image3Path) {
        this.image3Path = image3Path;
    }

    public String getImage4Path() {
        return image4Path;
    }

    public void setImage4Path(String image4Path) {
        this.image4Path = image4Path;
    }

    public String getImage5Path() {
        return image5Path;
    }

    public void setImage5Path(String image5Path) {
        this.image5Path = image5Path;
    }

    public String getPricecharging() {
        return pricecharging;
    }

    public void setPricecharging(String pricecharging) {
        this.pricecharging = pricecharging;
    }

    public String getEducation2() {
        return education2;
    }

    public void setEducation2(String education2) {
        this.education2 = education2;
    }

    public String getEducation3() {
        return education3;
    }

    public void setEducation3(String education3) {
        this.education3 = education3;
    }

    public String getCollegeName2() {
        return collegeName2;
    }

    public void setCollegeName2(String collegeName2) {
        this.collegeName2 = collegeName2;
    }

    public String getCollegeName3() {
        return collegeName3;
    }

    public void setCollegeName3(String collegeName3) {
        this.collegeName3 = collegeName3;
    }

    public String getSibling2() {
        return sibling2;
    }

    public void setSibling2(String sibling2) {
        this.sibling2 = sibling2;
    }

    public String getSibling3() {
        return sibling3;
    }

    public void setSibling3(String sibling3) {
        this.sibling3 = sibling3;
    }

    public String getSibling2info() {
        return sibling2info;
    }

    public void setSibling2info(String sibling2info) {
        this.sibling2info = sibling2info;
    }

    public String getSibling3info() {
        return sibling3info;
    }

    public void setSibling3info(String sibling3info) {
        this.sibling3info = sibling3info;
    }

    public String getSalary() {
        return salary;
    }
    
    public void setSalary(String salary) {
        this.salary = salary;
    }

    public List<RegistrationFormNotes> getNotes() {
        return notes;
    }

    public void setNotes(List<RegistrationFormNotes> notes) {
        this.notes = notes;
    }
}
    