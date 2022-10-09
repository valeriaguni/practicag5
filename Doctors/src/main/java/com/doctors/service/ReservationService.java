package com.doctors.service;

import com.doctors.model.ReservationModel;
import com.doctors.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationModel> getAllReservations(){
        return reservationRepository.getAllReservations();
    }

    public Optional<ReservationModel> getReservation(Integer idReservation){
        return reservationRepository.getReservation(idReservation);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel){
        return reservationRepository.saveReservation(reservationModel);
    }

    public boolean deleteReservation(Integer idReservation){ return reservationRepository.deleteReservation(idReservation);
    }

    public ReservationModel updateReservation(ReservationModel reservationModel){ return reservationRepository.updateReservation(reservationModel);
    }

    public ReservationModel save(ReservationModel reservationModel) {

        if (reservationModel.getIdReservation() == null) {
            return reservationRepository.saveReservation(reservationModel);
        } else {
            Optional<ReservationModel> reservation1 = reservationRepository.getReservation(reservationModel.getIdReservation());
            if(reservation1.isEmpty()) {
                return reservationRepository.saveReservation(reservationModel);
            } else {
                return reservationModel;
            }
        }
    }

    public ReservationModel update(ReservationModel reservationModel) {
        if(reservationModel.getIdReservation()!=null) {
            Optional<ReservationModel>g= reservationRepository.getReservation(reservationModel.getIdReservation());
            if(!g.isEmpty()){
                if(reservationModel.getStartDate()!=null){
                    g.get().setStartDate(reservationModel.getStartDate());
                }
                if(reservationModel.getDevolutionDate()!=null){
                    g.get().setDevolutionDate(reservationModel.getDevolutionDate());
                }
                if(reservationModel.getStatus()!=null){
                    g.get().setStatus(reservationModel.getStatus());
                }
                return reservationRepository.saveReservation(g.get());
            }
        }
        return reservationModel;
    }
}
