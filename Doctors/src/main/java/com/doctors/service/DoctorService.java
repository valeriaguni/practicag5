package com.doctors.service;

import com.doctors.model.DoctorModel;
import com.doctors.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorModel> getAllDoctors(){
        return doctorRepository.getAllDoctors();
    }

    public Optional<DoctorModel> getDoctor(Integer id){
        return doctorRepository.getDoctor(id);
    }

    public DoctorModel saveDoctor(DoctorModel doctorModel){
        return doctorRepository.saveDoctor(doctorModel);
    }

    public boolean deleteDoctor(Integer id){
        return doctorRepository.deleteDoctor(id);
    }

    public DoctorModel updateDoctor(DoctorModel doctorModel){
        return doctorRepository.updateDoctor(doctorModel);
    }

    public DoctorModel save(DoctorModel doctorModel) {

        if (doctorModel.getId() == null) {
            return doctorRepository.saveDoctor(doctorModel);
        } else {
            Optional<DoctorModel> doctor1 = doctorRepository.getDoctor(doctorModel.getId());
            if(doctor1.isEmpty()) {
                return doctorRepository.saveDoctor(doctorModel);
            } else {
                return doctorModel;
            }
        }
    }

    public DoctorModel update(DoctorModel doctorModel) {
        if(doctorModel.getId()!=null) {
            Optional<DoctorModel>g= doctorRepository.getDoctor(doctorModel.getId());
            if(!g.isEmpty()){
                if(doctorModel.getName()!=null){
                    g.get().setName(doctorModel.getName());
                }
                if(doctorModel.getDepartment()!=null){
                    g.get().setDepartment(doctorModel.getDepartment());
                }
                if(doctorModel.getYear()!=null){
                    g.get().setYear(doctorModel.getYear());
                }
                if(doctorModel.getDescription()!=null){
                    g.get().setDescription(doctorModel.getDescription());
                }
                return doctorRepository.saveDoctor(g.get());
            }
        }
        return doctorModel;
    }
}
