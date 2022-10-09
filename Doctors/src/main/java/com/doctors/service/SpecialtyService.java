package com.doctors.service;

import com.doctors.model.SpecialtyModel;
import com.doctors.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<SpecialtyModel> getAllSpecialties(){
        return specialtyRepository.getAllSpecialties();
    }

    public Optional<SpecialtyModel> getSpecialty(Integer id){
        return specialtyRepository.getSpecialty(id);
    }

    public SpecialtyModel saveSpecialty(SpecialtyModel specialtyModel){
        return specialtyRepository.saveSpecialty(specialtyModel);
    }

    public boolean deleteSpecialty(Integer id){
        return specialtyRepository.deleteSpecialty(id);
    }

    public SpecialtyModel updateSpecialty(SpecialtyModel specialtyModel){
        return specialtyRepository.updateSpecialty(specialtyModel);
    }

    public SpecialtyModel save(SpecialtyModel specialtyModel) {

        if (specialtyModel.getId() == null) {
            return specialtyRepository.saveSpecialty(specialtyModel);
        } else {
            Optional<SpecialtyModel> specialty1 = specialtyRepository.getSpecialty(specialtyModel.getId());
            if(specialty1.isEmpty()) {
                return specialtyRepository.saveSpecialty(specialtyModel);
            } else {
                return specialtyModel;
            }
        }
    }

    public SpecialtyModel update(SpecialtyModel specialtyModel) {
        if(specialtyModel.getId()!=null) {
            Optional<SpecialtyModel>g= specialtyRepository.getSpecialty(specialtyModel.getId());
            if(!g.isEmpty()){
                if(specialtyModel.getName()!=null){
                    g.get().setName(specialtyModel.getName());
                }
                if(specialtyModel.getDescription()!=null){
                    g.get().setDescription(specialtyModel.getDescription());
                }
                return specialtyRepository.saveSpecialty(g.get());
            }
        }
        return specialtyModel;
    }
}
