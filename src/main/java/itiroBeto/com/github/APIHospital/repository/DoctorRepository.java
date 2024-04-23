package itiroBeto.com.github.APIHospital.repository;

import itiroBeto.com.github.APIHospital.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
