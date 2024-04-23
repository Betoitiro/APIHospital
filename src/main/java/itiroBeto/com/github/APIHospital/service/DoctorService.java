package itiroBeto.com.github.APIHospital.service;

import itiroBeto.com.github.APIHospital.model.Doctor;
import itiroBeto.com.github.APIHospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public void create (Doctor doctor){
        doctorRepository.save(doctor);
    }

    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }

    public Optional<Doctor> findById(Long id){
        return doctorRepository.findById(id);
    }

    public void deleteById(Long id){
        doctorRepository.deleteById(id);
    }


}
