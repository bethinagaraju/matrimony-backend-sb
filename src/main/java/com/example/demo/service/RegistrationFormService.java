package com.example.demo.service;

import com.example.demo.dto.RegistrationRequest;
import com.example.demo.entity.RegistrationForm;
import com.example.demo.entity.RegistrationFormNotes;
import com.example.demo.repository.RegistrationFormNotesRepository;
import com.example.demo.repository.RegistrationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationFormService {

    @Autowired
    private RegistrationFormRepository registrationFormRepository;

    @Autowired
    private RegistrationFormNotesRepository registrationFormNotesRepository;

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
        form.setSalary(request.getSalary());
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
        form.setNakshatram(request.getNakshatram());
        form.setPricecharging(request.getPricecharging());
        form.setEducation2(request.getEducation2());
        form.setEducation3(request.getEducation3());
        form.setCollegeName2(request.getCollegeName2());
        form.setCollegeName3(request.getCollegeName3());
        form.setSibling2(request.getSibling2());
        form.setSibling3(request.getSibling3());
        form.setSibling2info(request.getSibling2info());
        form.setSibling3info(request.getSibling3info());

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

public RegistrationForm updateRegistration(Long id, RegistrationRequest request) throws Exception {
    RegistrationForm form = registrationFormRepository.findById(id).orElse(null);
    if (form == null) {
        return null;
    }

    // Validate mandatory fields
    validateMandatoryFields(request);

    // Update fields
    form.setProfileFor(request.getProfileFor());
    form.setFirstName(request.getFirstName());
    form.setLastName(request.getLastName());
    form.setGender(request.getGender());
    form.setDateOfBirth(request.getDateOfBirth());
    form.setEmail(request.getEmail());
    form.setAreaCode(request.getAreaCode());
    form.setPhoneNumber(request.getPhoneNumber());
    form.setPlaceOfBirthCity(request.getPlaceOfBirthCity());
    form.setSalary(request.getSalary());
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

    form.setTimeOfBirth(request.getTimeOfBirth());
    form.setSiblings(request.getSiblings());
    form.setSiblingDetails(request.getSiblingDetails());
    form.setRasi(request.getRasi());
    form.setGothram(request.getGothram());
    form.setNakshatram(request.getNakshatram());
    form.setPricecharging(request.getPricecharging());
    form.setEducation2(request.getEducation2());
    form.setEducation3(request.getEducation3());
    form.setCollegeName2(request.getCollegeName2());
    form.setCollegeName3(request.getCollegeName3());
    form.setSibling2(request.getSibling2());
    form.setSibling3(request.getSibling3());
    form.setSibling2info(request.getSibling2info());
    form.setSibling3info(request.getSibling3info());

    // Handle image updates if new images provided
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

    public RegistrationForm updateTextFieldsOnly(Long id, RegistrationRequest request) throws Exception {
        RegistrationForm form = registrationFormRepository.findById(id).orElse(null);
        if (form == null) {
            throw new Exception("Registration form not found with id: " + id);
        }
        // Update only text fields if the request provides values; keep existing values otherwise
        if (request.getProfileFor() != null && !request.getProfileFor().isEmpty()) {
            form.setProfileFor(request.getProfileFor());
        }
        if (request.getFirstName() != null && !request.getFirstName().isEmpty()) {
            form.setFirstName(request.getFirstName());
        }
        if (request.getLastName() != null && !request.getLastName().isEmpty()) {
            form.setLastName(request.getLastName());
        }
        if (request.getSalary() != null && !request.getSalary().isEmpty()) {
            form.setSalary(request.getSalary());
        }
        if (request.getGender() != null && !request.getGender().isEmpty()) {
            form.setGender(request.getGender());
        }
        if (request.getDateOfBirth() != null) {
            form.setDateOfBirth(request.getDateOfBirth());
        }
        if (request.getEmail() != null && !request.getEmail().isEmpty()) {
            form.setEmail(request.getEmail());
        }
        if (request.getAreaCode() != null && !request.getAreaCode().isEmpty()) {
            form.setAreaCode(request.getAreaCode());
        }
        if (request.getPhoneNumber() != null && !request.getPhoneNumber().isEmpty()) {
            form.setPhoneNumber(request.getPhoneNumber());
        }
        if (request.getPlaceOfBirthCity() != null && !request.getPlaceOfBirthCity().isEmpty()) {
            form.setPlaceOfBirthCity(request.getPlaceOfBirthCity());
        }
        if (request.getHeight() != null && !request.getHeight().isEmpty()) {
            form.setHeight(request.getHeight());
        }
        if (request.getCountry() != null && !request.getCountry().isEmpty()) {
            form.setCountry(request.getCountry());
        }
        if (request.getCity() != null && !request.getCity().isEmpty()) {
            form.setCity(request.getCity());
        }
        if (request.getCaste() != null && !request.getCaste().isEmpty()) {
            form.setCaste(request.getCaste());
        }
        if (request.getOpenToAllCaste() != null) {
            form.setOpenToAllCaste(request.getOpenToAllCaste());
        }
        if (request.getAncestralPlace() != null && !request.getAncestralPlace().isEmpty()) {
            form.setAncestralPlace(request.getAncestralPlace());
        }
        if (request.getMaritalStatus() != null && !request.getMaritalStatus().isEmpty()) {
            form.setMaritalStatus(request.getMaritalStatus());
        }
        if (request.getFatherName() != null && !request.getFatherName().isEmpty()) {
            form.setFatherName(request.getFatherName());
        }
        if (request.getFatherProfession() != null && !request.getFatherProfession().isEmpty()) {
            form.setFatherProfession(request.getFatherProfession());
        }
        if (request.getMotherName() != null && !request.getMotherName().isEmpty()) {
            form.setMotherName(request.getMotherName());
        }
        if (request.getMotherProfession() != null && !request.getMotherProfession().isEmpty()) {
            form.setMotherProfession(request.getMotherProfession());
        }
        if (request.getEducation() != null && !request.getEducation().isEmpty()) {
            form.setEducation(request.getEducation());
        }
        if (request.getCollegeName() != null && !request.getCollegeName().isEmpty()) {
            form.setCollegeName(request.getCollegeName());
        }
        if (request.getOccupation() != null && !request.getOccupation().isEmpty()) {
            form.setOccupation(request.getOccupation());
        }
        if (request.getAdditionalInfo() != null && !request.getAdditionalInfo().isEmpty()) {
            form.setAdditionalInfo(request.getAdditionalInfo());
        }
        if (request.getFilledBy() != null && !request.getFilledBy().isEmpty()) {
            form.setFilledBy(request.getFilledBy());
        }
        if (request.getDrinkingHabit() != null && !request.getDrinkingHabit().isEmpty()) {
            form.setDrinkingHabit(request.getDrinkingHabit());
        }
        if (request.getSmokingHabit() != null && !request.getSmokingHabit().isEmpty()) {
            form.setSmokingHabit(request.getSmokingHabit());
        }
        if (request.getFoodHabits() != null && !request.getFoodHabits().isEmpty()) {
            form.setFoodHabits(request.getFoodHabits());
        }

        if (request.getTimeOfBirth() != null) {
            form.setTimeOfBirth(request.getTimeOfBirth());
        }
        if (request.getSiblings() != null && !request.getSiblings().isEmpty()) {
            form.setSiblings(request.getSiblings());
        }
        if (request.getSiblingDetails() != null && !request.getSiblingDetails().isEmpty()) {
            form.setSiblingDetails(request.getSiblingDetails());
        }
        if (request.getRasi() != null && !request.getRasi().isEmpty()) {
            form.setRasi(request.getRasi());
        }
        if (request.getGothram() != null && !request.getGothram().isEmpty()) {
            form.setGothram(request.getGothram());
        }
        if (request.getNakshatram() != null && !request.getNakshatram().isEmpty()) {
            form.setNakshatram(request.getNakshatram());
        }
        if (request.getPricecharging() != null && !request.getPricecharging().isEmpty()) {
            form.setPricecharging(request.getPricecharging());
        }
        if (request.getEducation2() != null && !request.getEducation2().isEmpty()) {
            form.setEducation2(request.getEducation2());
        }
        if (request.getEducation3() != null && !request.getEducation3().isEmpty()) {
            form.setEducation3(request.getEducation3());
        }
        if (request.getCollegeName2() != null && !request.getCollegeName2().isEmpty()) {
            form.setCollegeName2(request.getCollegeName2());
        }
        if (request.getCollegeName3() != null && !request.getCollegeName3().isEmpty()) {
            form.setCollegeName3(request.getCollegeName3());
        }
        if (request.getSibling2() != null && !request.getSibling2().isEmpty()) {
            form.setSibling2(request.getSibling2());
        }
        if (request.getSibling3() != null && !request.getSibling3().isEmpty()) {
            form.setSibling3(request.getSibling3());
        }
        if (request.getSibling2info() != null && !request.getSibling2info().isEmpty()) {
            form.setSibling2info(request.getSibling2info());
        }
        if (request.getSibling3info() != null && !request.getSibling3info().isEmpty()) {
            form.setSibling3info(request.getSibling3info());
        }

        // Do not update image paths - keep existing images as is

        // Save entity
        return registrationFormRepository.save(form);
    }

    public RegistrationForm updateSingleField(Long id, String fieldName, String fieldValue) throws Exception {
        RegistrationForm form = registrationFormRepository.findById(id).orElse(null);
        if (form == null) {
            throw new Exception("Registration form not found with id: " + id);
        }

        // Update the specific field based on fieldName
        switch (fieldName.toLowerCase()) {
            case "profilefor":
                form.setProfileFor(fieldValue);
                break;
            case "firstname":
                form.setFirstName(fieldValue);
                break;
            case "lastname":
                form.setLastName(fieldValue);
                break;
            case "salary":
                form.setSalary(fieldValue);
                break;
            case "gender":
                form.setGender(fieldValue);
                break;
            case "dateofbirth":
                form.setDateOfBirth(java.time.LocalDate.parse(fieldValue));
                break;
            case "placeofbirthcity":
                form.setPlaceOfBirthCity(fieldValue);
                break;
            case "email":
                form.setEmail(fieldValue);
                break;
            case "areacode":
                form.setAreaCode(fieldValue);
                break;
            case "phonenumber":
                form.setPhoneNumber(fieldValue);
                break;
            case "height":
                form.setHeight(fieldValue);
                break;
            case "country":
                form.setCountry(fieldValue);
                break;
            case "city":
                form.setCity(fieldValue);
                break;
            case "caste":
                form.setCaste(fieldValue);
                break;
            case "opentoallcaste":
                form.setOpenToAllCaste(Boolean.parseBoolean(fieldValue));
                break;
            case "ancestralplace":
                form.setAncestralPlace(fieldValue);
                break;
            case "maritalstatus":
                form.setMaritalStatus(fieldValue);
                break;
            case "fathername":
                form.setFatherName(fieldValue);
                break;
            case "fatherprofession":
                form.setFatherProfession(fieldValue);
                break;
            case "mothername":
                form.setMotherName(fieldValue);
                break;
            case "motherprofession":
                form.setMotherProfession(fieldValue);
                break;
            case "education":
                form.setEducation(fieldValue);
                break;
            case "collegename":
                form.setCollegeName(fieldValue);
                break;
            case "occupation":
                form.setOccupation(fieldValue);
                break;
            case "additionalinfo":
                form.setAdditionalInfo(fieldValue);
                break;
            case "filledby":
                form.setFilledBy(fieldValue);
                break;
            case "drinkinhabit":
                form.setDrinkingHabit(fieldValue);
                break;
            case "smokinhabit":
                form.setSmokingHabit(fieldValue);
                break;
            case "foodhabits":
                form.setFoodHabits(fieldValue);
                break;
            case "timeofbirth":
                form.setTimeOfBirth(java.time.LocalTime.parse(fieldValue));
                break;
            case "siblings":
                form.setSiblings(fieldValue);
                break;
            case "siblingdetails":
                form.setSiblingDetails(fieldValue);
                break;
            case "rasi":
                form.setRasi(fieldValue);
                break;
            case "gothram":
                form.setGothram(fieldValue);
                break;
            case "nakshatram":
                form.setNakshatram(fieldValue);
                break;
            case "pricecharging":
                form.setPricecharging(fieldValue);
                break;
            case "education2":
                form.setEducation2(fieldValue);
                break;
            case "education3":
                form.setEducation3(fieldValue);
                break;
            case "collegename2":
                form.setCollegeName2(fieldValue);
                break;
            case "collegename3":
                form.setCollegeName3(fieldValue);
                break;
            case "sibling2":
                form.setSibling2(fieldValue);
                break;
            case "sibling3":
                form.setSibling3(fieldValue);
                break;
            case "sibling2info":
                form.setSibling2info(fieldValue);
                break;
            case "sibling3info":
                form.setSibling3info(fieldValue);
                break;
            default:
                throw new IllegalArgumentException("Field '" + fieldName + "' is not recognized");
        }

        // Save entity
        return registrationFormRepository.save(form);
    }

    public boolean deleteRegistrationForm(Long id) {
        if (!registrationFormRepository.existsById(id)) {
            return false;
        }
        registrationFormRepository.deleteById(id);
        return true;
    }

    public RegistrationFormNotes addNote(Long registrationFormId, String noteText, String createdBy) {
        RegistrationForm form = registrationFormRepository.findById(registrationFormId).orElse(null);
        if (form == null) {
            throw new IllegalArgumentException("Registration form not found");
        }
        RegistrationFormNotes note = new RegistrationFormNotes();
        note.setRegistrationForm(form);
        note.setNoteText(noteText);
        note.setCreatedBy(createdBy);
        // maintain both sides of the relationship
        form.getNotes().add(note);
        // saving the note is sufficient because it is the owning side, but saving the form would also persist it via cascade
        return registrationFormNotesRepository.save(note);
    }

    public java.util.List<RegistrationFormNotes> getNotesByRegistrationFormId(Long registrationFormId) {
        return registrationFormNotesRepository.findByRegistrationFormId(registrationFormId);
    }

    public boolean deleteNote(Long noteId) {
        if (!registrationFormNotesRepository.existsById(noteId)) {
            return false;
        }
        registrationFormNotesRepository.deleteById(noteId);
        return true;
    }

    public RegistrationForm updateImage3(Long id, MultipartFile image3) throws Exception {
        if (image3 == null || image3.isEmpty()) {
            throw new IllegalArgumentException("image3 file is required");
        }

        RegistrationForm form = registrationFormRepository.findById(id).orElse(null);
        if (form == null) {
            return null;
        }

        // Upload file via existing SFTP service and set image3 path
        String uploadedUrl = sftpFileUploadService.uploadFile(image3);
        form.setImage3Path(uploadedUrl);

        return registrationFormRepository.save(form);
    }
}
