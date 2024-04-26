package itiroBeto.com.github.APIHospital.controller;

import itiroBeto.com.github.APIHospital.model.Exams;
import itiroBeto.com.github.APIHospital.service.ExamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.EnumMap;
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


    //Zone patient


}
