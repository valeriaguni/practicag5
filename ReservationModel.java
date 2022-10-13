package com.doctors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="reservation")

public class ReservationModel implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";


    @ManyToOne
    @JoinColumn(name = "doctorId")
    @JsonIgnoreProperties("reservations")
    private DoctorModel doctor;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"reservations", "messages"})
    private ClientModel client;


    @OneToOne(mappedBy = "reservations")
    @JsonIgnoreProperties("reservations")
    private ScoreModel score;

    public ReservationModel() {
    }

    public ReservationModel(Integer idReservation, Date startDate, Date devolutionDate, String status, DoctorModel doctor, ClientModel client, ScoreModel score) {
        this.idReservation = idReservation;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.doctor = doctor;
        this.client = client;
        this.score = score;
    }

    public ReservationModel(Date startDate, Date devolutionDate, String status, DoctorModel doctor, ClientModel client, ScoreModel score) {
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.doctor = doctor;
        this.client = client;
        this.score = score;
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

    public DoctorModel getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorModel doctor) {
        this.doctor = doctor;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public ScoreModel getScore() {
        return score;
    }

    public void setScore(ScoreModel score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ReservationModel{" +
                "idReservation=" + idReservation +
                ", startDate=" + startDate +
                ", devolutionDate=" + devolutionDate +
                ", status='" + status + '\'' +
                ", doctor=" + doctor +
                ", client=" + client +
                ", score=" + score +
                '}';
    }
}