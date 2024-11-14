package itiroBeto.com.github.APIHospital.v1.repository;

import itiroBeto.com.github.APIHospital.v1.model.Exams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamsRepository extends JpaRepository<Exams, Long> {
    List<Exams> findByConsultationId(Long consultationId);
}
