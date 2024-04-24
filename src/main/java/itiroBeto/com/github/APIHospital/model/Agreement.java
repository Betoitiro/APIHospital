package itiroBeto.com.github.APIHospital.model;

import itiroBeto.com.github.APIHospital.enums.AgreementPatientStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Agreement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String email;

    @Enumerated(EnumType.STRING)
    private AgreementPatientStatusEnum status;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AgreementPatientStatusEnum getStatus() {
        return status;
    }

    public void setStatus(AgreementPatientStatusEnum status) {
        this.status = status;
    }
}
