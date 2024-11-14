package itiroBeto.com.github.APIHospital.v1.controller;

import itiroBeto.com.github.APIHospital.v1.model.Doctor;
import itiroBeto.com.github.APIHospital.v1.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;


    //Doctor administrative departament
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Doctor doctor){
        doctorService.create(doctor);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> findAll(){
        return doctorService.findAll();
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updated(@RequestBody Doctor doctor, @PathVariable Long id){
        doctorService.updated(id, doctor);
    }



}
