package itiroBeto.com.github.APIHospital.service;

import itiroBeto.com.github.APIHospital.enums.AgreementPatientStatusEnum;
import itiroBeto.com.github.APIHospital.model.Agreement;
import itiroBeto.com.github.APIHospital.repository.AgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AgreementService {

    @Autowired
    AgreementRepository agreementRepository;

    public void create(Agreement agreement){
        agreementRepository.save(agreement);
    }

    public List<Agreement> findAll(){
        return agreementRepository.findAll();
    }

    public Optional<Agreement> unimedState(Long id){
        Optional<Agreement> optionalAgreement = agreementRepository.findById(id);
        if (optionalAgreement.isPresent()){
            Agreement unimedState = optionalAgreement.get();
            unimedState.setCompany(AgreementPatientStatusEnum.UNIMED);
            agreementRepository.save(unimedState);
        }
        return optionalAgreement;
    }

    public Optional<Agreement> hapvidaState(Long id){
        Optional<Agreement> optionalAgreement = agreementRepository.findById(id);
        if (optionalAgreement.isPresent()){
            Agreement hapvidaState = optionalAgreement.get();
            hapvidaState.setCompany(AgreementPatientStatusEnum.HAPVIDA);
            agreementRepository.save(hapvidaState);
        }
        return optionalAgreement;
    }

    public Optional<Agreement> susState(Long id){
        Optional<Agreement> optionalAgreement = agreementRepository.findById(id);
        if (optionalAgreement.isPresent()){
            Agreement susState = optionalAgreement.get();
            susState.setCompany(AgreementPatientStatusEnum.SUS);
            agreementRepository.save(susState);
        }
        return optionalAgreement;
    }

    public Optional<Agreement> particularState(Long id){
        Optional<Agreement> optionalAgreement = agreementRepository.findById(id);
        if (optionalAgreement.isPresent()){
            Agreement particularState = optionalAgreement.get();
            particularState.setCompany(AgreementPatientStatusEnum.PARTICULAR);
            agreementRepository.save(particularState);
        }
        return optionalAgreement;
    }

    public Optional<Agreement> bradescoMedState(Long id){
        Optional<Agreement> optionalAgreement = agreementRepository.findById(id);
        if (optionalAgreement.isPresent()){
            Agreement bradescoMedState = optionalAgreement.get();
            bradescoMedState.setCompany(AgreementPatientStatusEnum.BRADESCOMED);
            agreementRepository.save(bradescoMedState);
        }
        return optionalAgreement;
    }

    public Optional<Agreement> bancoDoBrasilMedState(Long id){
        Optional<Agreement> optionalAgreement = agreementRepository.findById(id);
        if (optionalAgreement.isPresent()){
            Agreement bancoDoBrasilMedState = optionalAgreement.get();
            bancoDoBrasilMedState.setCompany(AgreementPatientStatusEnum.BANCODOBRASILMED);
            agreementRepository.save(bancoDoBrasilMedState);
        }
        return optionalAgreement;
    }

    public Optional<Agreement> findById(Long id){
        return agreementRepository.findById(id);
    }

    public void updated(Long id, Agreement agreement){
        Optional<Agreement> agreementFromDb = agreementRepository.findById(id);


        if (agreementFromDb.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "convenio não encontrado");
        }

        Agreement agreementUpdated = agreementFromDb.get();
        agreementUpdated.setEmail(agreement.getEmail());
        agreementUpdated.setCompany(agreement.getCompany());

        agreementRepository.save(agreementUpdated);
    }
}
