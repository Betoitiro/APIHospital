package itiroBeto.com.github.APIHospital.service;

import itiroBeto.com.github.APIHospital.enums.ConsultationPatientStatusEnum;
import itiroBeto.com.github.APIHospital.model.Consultation;
import itiroBeto.com.github.APIHospital.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService {
    @Autowired
    ConsultationRepository consultationRepository;

    public void create (Consultation consultation){
        consultation.setStatus(ConsultationPatientStatusEnum.CONFIRMADA);
        consultationRepository.save(consultation);
    }

    public List<Consultation> findAll(){
        return consultationRepository.findAll();
    }

    public Optional<Consultation> changeState(Long id, Consultation consultation){
        Optional<Consultation> optionalConsultation = consultationRepository.findById(id);
        if (optionalConsultation.isEmpty()){
            Consultation existingConsultation = optionalConsultation.get();
            existingConsultation.setStatus(ConsultationPatientStatusEnum.REALIZADA);
            consultationRepository.save(existingConsultation);
        }
        return optionalConsultation;

    }

    public Optional<Consultation> cancelledState(Long id, Consultation consultation){
        Optional<Consultation> optionalConsultation = consultationRepository.findById(id);
        if (optionalConsultation.isEmpty()){
            Consultation cancellConsultation = optionalConsultation.get();
            cancellConsultation.setStatus(ConsultationPatientStatusEnum.CANCELADA);
            consultationRepository.save(cancellConsultation);
        }
        return optionalConsultation;
    }

    public Optional<Consultation> findById(Long id){
        return consultationRepository.findById(id);
    }
}
