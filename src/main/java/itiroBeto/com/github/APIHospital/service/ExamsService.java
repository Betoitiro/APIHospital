package itiroBeto.com.github.APIHospital.service;

import itiroBeto.com.github.APIHospital.enums.ExamsPatientStatusEnum;
import itiroBeto.com.github.APIHospital.model.Exams;
import itiroBeto.com.github.APIHospital.repository.ExamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
public class ExamsService {
        @Autowired
        ExamsRepository examsRepository;

        public void createExams(Exams exams){
            exams.setStatus(ExamsPatientStatusEnum.PENDENTE);
            examsRepository.save(exams);
        }

        public Optional<Exams> changeStateExams (Long id){
            Optional<Exams> examsFromDb = examsRepository.findById(id);
            if (examsFromDb.isPresent()){
                Exams examsRealization = examsFromDb.get();
                examsRealization.setStatus(ExamsPatientStatusEnum.REALIZADO);
                examsRepository.save(examsRealization);
            }
            return examsFromDb;
        }

        public Optional<Exams> cancelledStateExams (Long id){
            Optional<Exams> examsFromDb = examsRepository.findById(id);
            if (examsFromDb.isPresent()){
                Exams examsCancelled = examsFromDb.get();
                examsCancelled.setStatus(ExamsPatientStatusEnum.CANCELADO);
                examsRepository.save(examsCancelled);
            }
            return examsFromDb;
        }

        public List<Exams> findAll(){
            return examsRepository.findAll();
        }

        public Optional<Exams> findById(Long id){
            return examsRepository.findById(id);
        }


        //zone patient

        @GetMapping("/findHistoryExams/{id}")
        @ResponseStatus(HttpStatus.OK)
        public Optional<Exams> findHistoryExamsId(Long id){
            return examsRepository.findById(id);
        }


}
