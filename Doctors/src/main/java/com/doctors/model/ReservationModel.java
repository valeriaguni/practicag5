package com.doctors.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="reservation")
public class ReservationModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;

    private Date startDate;

    private Date devolutionDate;

    private String status="created";

    public ReservationModel() {
    }

    public ReservationModel(Date startDate, Date devolutionDate, String status) {
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
    }

    public ReservationModel(Integer idReservation, Date startDate, Date devolutionDate, String status) {
        this.idReservation= idReservation;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReservationModel{" +
                "idReservation=" + idReservation +
                ", startDate='" + startDate + '\'' +
                ", devolutionDate='" + devolutionDate + '\'' +
                ", status=" + status +
                '}';
    }

}
