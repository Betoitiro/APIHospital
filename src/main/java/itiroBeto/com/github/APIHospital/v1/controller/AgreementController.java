package itiroBeto.com.github.APIHospital.v1.controller;

import itiroBeto.com.github.APIHospital.v1.model.Agreement;
import itiroBeto.com.github.APIHospital.v1.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/agreement")
public class AgreementController {
    @Autowired
    AgreementService agreementService;

    @PostMapping
    public void create(@RequestBody Agreement agreement){
        agreementService.create(agreement);
    }

    @PutMapping("/addunimedState/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Optional<Agreement> UnimedState(@PathVariable Long id){
        return agreementService.unimedState(id);
    }

    @PutMapping("/addsusState/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Optional<Agreement> susState(@PathVariable Long id){
        return agreementService.susState(id);
    }

    @PutMapping("/addparticularState/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Optional<Agreement> particularState(@PathVariable Long id){
        return agreementService.particularState(id);
    }

    @PutMapping("/addbradescoState/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Optional<Agreement> bradescoMedState(@PathVariable Long id){
        return agreementService.bradescoMedState(id);
    }

    @PutMapping("/addhapvidaState/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Optional<Agreement> hapvidaState(@PathVariable Long id){
        return agreementService.hapvidaState(id);
    }

    @PutMapping("/addbancoBrasilState/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Optional<Agreement> bancoDoBrasilMedState(@PathVariable Long id){
        return agreementService.bancoDoBrasilMedState(id);
    }


    @PutMapping("/reload/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updated(@PathVariable Long id, @RequestBody Agreement agreement){
        agreementService.updated(id, agreement);
    }

}
