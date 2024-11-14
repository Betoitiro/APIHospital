package itiroBeto.com.github.APIHospital.v1.controller;

import itiroBeto.com.github.APIHospital.v1.model.Exams;
import itiroBeto.com.github.APIHospital.v1.service.ExamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exams")
public class ExamsController {

    @Autowired
    ExamsService examsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Exams exams){
        examsService.createExams(exams);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Exams>findAll(){
        return examsService.findAll();
    }

    @PutMapping("/changeStateExams/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Optional<Exams> changeStateExams(@PathVariable Long id){
        return examsService.changeStateExams(id);
    }

    @PutMapping("/cancellStateExams/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Optional<Exams> cancellStateExams(@PathVariable Long id){
        return examsService.cancelledStateExams(id);
    }



    @GetMapping("/findexams/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Exams> findById(@PathVariable Long id){
        return examsService.findById(id);
    }

    //Zone patient
    @GetMapping("/findHistoryExams/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Exams> findByConsultationId(@PathVariable Long id){
        return examsService.findByConsultationId(id);
    }

}
