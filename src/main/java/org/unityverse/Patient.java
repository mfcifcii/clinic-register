package org.unityverse;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Patient {

    @NotBlank(message = "Ad boş olamaz")
    private String name;

    @NotBlank(message = "Soyad boş olamaz")
    private String surname;

    @NotBlank(message = "Telefon boş olamaz")
    @Pattern(regexp = "^[0-9]{10,11}$", message = "Telefon 10 veya 11 haneli olmalıdır")
    private String phoneNumber;

    @NotBlank(message = "Email boş olamaz")
    @Email(message = "Geçerli bir email giriniz")
    private String email;

    private int patientNo;

    public Patient() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(int patientNo) {
        this.patientNo = patientNo;
    }
}