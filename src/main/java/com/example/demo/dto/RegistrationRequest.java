package com.example.demo.dto;

import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;
import java.time.LocalTime;

public class RegistrationRequest {

    // Mandatory fields
    private String profileFor;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String email;
    private String areaCode;
    private String phoneNumber;
    private String placeOfBirthCity;
    private String placeOfBirthState;
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
    private MultipartFile image1;
    private MultipartFile image2;
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
    private MultipartFile image3;
    private MultipartFile image4;
    private MultipartFile image5;
    private String pricecharging;
    private String education2;
    private String education3;
    private String collegeName2;
    private String collegeName3;

    // Getters and Setters
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

    public String getPlaceOfBirthState() {
        return placeOfBirthState;
    }

    public void setPlaceOfBirthState(String placeOfBirthState) {
        this.placeOfBirthState = placeOfBirthState;
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

    public MultipartFile getImage1() {
        return image1;
    }

    public void setImage1(MultipartFile image1) {
        this.image1 = image1;
    }

    public MultipartFile getImage2() {
        return image2;
    }

    public void setImage2(MultipartFile image2) {
        this.image2 = image2;
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

    public MultipartFile getImage3() {
        return image3;
    }

    public void setImage3(MultipartFile image3) {
        this.image3 = image3;
    }

    public MultipartFile getImage4() {
        return image4;
    }

    public void setImage4(MultipartFile image4) {
        this.image4 = image4;
    }

    public MultipartFile getImage5() {
        return image5;
    }

    public void setImage5(MultipartFile image5) {
        this.image5 = image5;
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
}
