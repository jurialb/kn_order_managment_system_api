package kn.kn_order_managment_system_api.dto;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class CustomerDTO {

    private int registrationCode;
    private String fullName;
    private String email;
    private String telephone;
    public CustomerDTO() {
    }
    public CustomerDTO(int registrationCode, String fullName, String email, String telephone) {
        this.registrationCode = registrationCode;
        this.fullName = fullName;
        this.email = email;
        this.telephone = telephone;
    }

    public int getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(int registrationCode) {
        this.registrationCode = registrationCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
