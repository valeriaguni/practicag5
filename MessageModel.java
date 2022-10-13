package com.doctors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class MessageModel implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    @JsonIgnoreProperties({"messages", "reservations" })
    private DoctorModel doctor;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages", "reservations" })
    private ClientModel client;

    public MessageModel() {
    }

    public MessageModel(Integer idMessage, String messageText, DoctorModel doctor, ClientModel client) {
        this.idMessage = idMessage;
        this.messageText = messageText;
        this.doctor = doctor;
        this.client = client;
    }

    public MessageModel(String messageText, DoctorModel doctor, ClientModel client) {
        this.messageText = messageText;
        this.doctor = doctor;
        this.client = client;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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

    @Override
    public String toString() {
        return "MessageModel{" +
                "idMessage=" + idMessage +
                ", messageText='" + messageText + '\'' +
                ", doctor=" + doctor +
                ", client=" + client +
                '}';
    }
}