package com.doctors.controller;

import com.doctors.model.DoctorModel;
import com.doctors.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctor")
@CrossOrigin(origins = "*")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/all")
    public List<DoctorModel> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Optional <DoctorModel> getDoctor(@PathVariable Integer id){
        return doctorService.getDoctor(id);
    }

    @PostMapping("/save")
    public DoctorModel saveDoctor(@RequestBody DoctorModel doctorModel){
        return doctorService.saveDoctor(doctorModel);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteDoctor(@PathVariable Integer id){
        return doctorService.deleteDoctor(id);
    }

    @PutMapping("/update")
    public DoctorModel updateDoctor(@RequestBody DoctorModel doctorModel){
        return doctorService.updateDoctor(doctorModel);
    }
}
