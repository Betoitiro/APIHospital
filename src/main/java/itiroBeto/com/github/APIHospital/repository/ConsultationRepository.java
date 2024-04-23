package itiroBeto.com.github.APIHospital.repository;

import itiroBeto.com.github.APIHospital.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
