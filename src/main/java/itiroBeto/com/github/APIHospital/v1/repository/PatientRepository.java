package itiroBeto.com.github.APIHospital.v1.repository;

import itiroBeto.com.github.APIHospital.v1.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {


}
