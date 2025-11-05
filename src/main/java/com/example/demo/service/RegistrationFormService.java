package com.example.demo.service;

import com.example.demo.dto.RegistrationRequest;
import com.example.demo.entity.RegistrationForm;
import com.example.demo.repository.RegistrationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class RegistrationFormService {

    @Autowired
    private RegistrationFormRepository registrationFormRepository;

    @Autowired
    private SftpFileUploadService sftpFileUploadService;

    public RegistrationForm saveRegistration(RegistrationRequest request) throws Exception {
        // Validate mandatory fields
        validateMandatoryFields(request);

        // Create entity
        RegistrationForm form = new RegistrationForm();
        form.setProfileFor(request.getProfileFor());
        form.setFirstName(request.getFirstName());
        form.setLastName(request.getLastName());
        form.setGender(request.getGender());
        form.setDateOfBirth(request.getDateOfBirth());
        form.setEmail(request.getEmail());
        form.setAreaCode(request.getAreaCode());
        form.setPhoneNumber(request.getPhoneNumber());
        form.setPlaceOfBirthCity(request.getPlaceOfBirthCity());
        form.setPlaceOfBirthState(request.getPlaceOfBirthState());
        form.setHeight(request.getHeight());
        form.setCountry(request.getCountry());
        form.setCity(request.getCity());
        form.setCaste(request.getCaste());
        form.setOpenToAllCaste(request.getOpenToAllCaste());
        form.setAncestralPlace(request.getAncestralPlace());
        form.setMaritalStatus(request.getMaritalStatus());
        form.setFatherName(request.getFatherName());
        form.setFatherProfession(request.getFatherProfession());
        form.setMotherName(request.getMotherName());
        form.setMotherProfession(request.getMotherProfession());
        form.setEducation(request.getEducation());
        form.setCollegeName(request.getCollegeName());
        form.setOccupation(request.getOccupation());
        form.setAdditionalInfo(request.getAdditionalInfo());
        form.setFilledBy(request.getFilledBy());
        form.setDrinkingHabit(request.getDrinkingHabit());
        form.setSmokingHabit(request.getSmokingHabit());
        form.setFoodHabits(request.getFoodHabits());

        // Optional fields
        form.setTimeOfBirth(request.getTimeOfBirth());
        form.setSiblings(request.getSiblings());
        form.setSiblingDetails(request.getSiblingDetails());
        form.setRasi(request.getRasi());
        form.setGothram(request.getGothram());
        form.setPricecharging(request.getPricecharging());
        form.setEducation2(request.getEducation2());
        form.setEducation3(request.getEducation3());
        form.setCollegeName2(request.getCollegeName2());
        form.setCollegeName3(request.getCollegeName3());

        // Save images
        if (request.getImage1() != null && !request.getImage1().isEmpty()) {
            form.setImage1Path(sftpFileUploadService.uploadFile(request.getImage1()));
        }
        if (request.getImage2() != null && !request.getImage2().isEmpty()) {
            form.setImage2Path(sftpFileUploadService.uploadFile(request.getImage2()));
        }
        if (request.getImage3() != null && !request.getImage3().isEmpty()) {
            form.setImage3Path(sftpFileUploadService.uploadFile(request.getImage3()));
        }
        if (request.getImage4() != null && !request.getImage4().isEmpty()) {
            form.setImage4Path(sftpFileUploadService.uploadFile(request.getImage4()));
        }
        if (request.getImage5() != null && !request.getImage5().isEmpty()) {
            form.setImage5Path(sftpFileUploadService.uploadFile(request.getImage5()));
        }

        // Save entity
        return registrationFormRepository.save(form);
    }

    private void validateMandatoryFields(RegistrationRequest request) {
        if (request.getProfileFor() == null || request.getProfileFor().isEmpty()) {
            throw new IllegalArgumentException("Profile For is mandatory");
        }
        if (request.getFirstName() == null || request.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("First Name is mandatory");
        }
        if (request.getLastName() == null || request.getLastName().isEmpty()) {
            throw new IllegalArgumentException("Last Name is mandatory");
        }
        if (request.getGender() == null || request.getGender().isEmpty()) {
            throw new IllegalArgumentException("Gender is mandatory");
        }
        if (request.getDateOfBirth() == null) {
            throw new IllegalArgumentException("Date of Birth is mandatory");
        }
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email is mandatory");
        }
        if (request.getAreaCode() == null || request.getAreaCode().isEmpty()) {
            throw new IllegalArgumentException("Area Code is mandatory");
        }
        if (request.getPhoneNumber() == null || request.getPhoneNumber().isEmpty()) {
            throw new IllegalArgumentException("Phone Number is mandatory");
        }
        if (request.getPlaceOfBirthCity() == null || request.getPlaceOfBirthCity().isEmpty()) {
            throw new IllegalArgumentException("Place of Birth City is mandatory");
        }
        if (request.getPlaceOfBirthState() == null || request.getPlaceOfBirthState().isEmpty()) {
            throw new IllegalArgumentException("Place of Birth State is mandatory");
        }
        if (request.getHeight() == null || request.getHeight().isEmpty()) {
            throw new IllegalArgumentException("Height is mandatory");
        }
        if (request.getCountry() == null || request.getCountry().isEmpty()) {
            throw new IllegalArgumentException("Country is mandatory");
        }
        if (request.getCity() == null || request.getCity().isEmpty()) {
            throw new IllegalArgumentException("City is mandatory");
        }
        if (request.getCaste() == null || request.getCaste().isEmpty()) {
            throw new IllegalArgumentException("Caste is mandatory");
        }
        if (request.getMaritalStatus() == null || request.getMaritalStatus().isEmpty()) {
            throw new IllegalArgumentException("Marital Status is mandatory");
        }
        if (request.getFatherName() == null || request.getFatherName().isEmpty()) {
            throw new IllegalArgumentException("Father Name is mandatory");
        }
        if (request.getFatherProfession() == null || request.getFatherProfession().isEmpty()) {
            throw new IllegalArgumentException("Father Profession is mandatory");
        }
        if (request.getMotherName() == null || request.getMotherName().isEmpty()) {
            throw new IllegalArgumentException("Mother Name is mandatory");
        }
        if (request.getMotherProfession() == null || request.getMotherProfession().isEmpty()) {
            throw new IllegalArgumentException("Mother Profession is mandatory");
        }
        if (request.getEducation() == null || request.getEducation().isEmpty()) {
            throw new IllegalArgumentException("Education is mandatory");
        }
        if (request.getCollegeName() == null || request.getCollegeName().isEmpty()) {
            throw new IllegalArgumentException("College Name is mandatory");
        }
        if (request.getOccupation() == null || request.getOccupation().isEmpty()) {
            throw new IllegalArgumentException("Occupation is mandatory");
        }
        if (request.getImage1() == null || request.getImage1().isEmpty()) {
            throw new IllegalArgumentException("Image 1 is mandatory");
        }
        if (request.getImage2() == null || request.getImage2().isEmpty()) {
            throw new IllegalArgumentException("Image 2 is mandatory");
        }
        if (request.getAdditionalInfo() == null || request.getAdditionalInfo().isEmpty()) {
            throw new IllegalArgumentException("Additional Information is mandatory");
        }
        if (request.getFilledBy() == null || request.getFilledBy().isEmpty()) {
            throw new IllegalArgumentException("Name of the person who filled this form is mandatory");
        }
        if (request.getDrinkingHabit() == null || request.getDrinkingHabit().isEmpty()) {
            throw new IllegalArgumentException("Drinking Habit is mandatory");
        }
        if (request.getSmokingHabit() == null || request.getSmokingHabit().isEmpty()) {
            throw new IllegalArgumentException("Smoking Habit is mandatory");
        }
        if (request.getFoodHabits() == null || request.getFoodHabits().isEmpty()) {
            throw new IllegalArgumentException("Food Habits is mandatory");
        }
    }

    public List<RegistrationForm> getAllRegistrationForms() {
        return registrationFormRepository.findAll();
    }

    public RegistrationForm getRegistrationFormById(Long id) {
        return registrationFormRepository.findById(id).orElse(null);
    }

    public RegistrationForm updatePriceCharging(Long id, String newPriceCharging) {
        RegistrationForm form = registrationFormRepository.findById(id).orElse(null);
        if (form == null) {
            return null;
        }
        form.setPricecharging(newPriceCharging);
        return registrationFormRepository.save(form);
    }
}
