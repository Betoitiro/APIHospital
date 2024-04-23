package itiroBeto.com.github.APIHospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String appointmentDateTime;
    private String Description;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    Patient patient;


}
