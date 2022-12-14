package com.doctors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="message")
public class MessageModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;

    @Column(name = "messageText", nullable = false, length = 250)
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private DoctorModel doctor;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private ClientModel client;

    public MessageModel() {
    }

    public MessageModel(String messageText) {
        this.messageText = messageText;
    }

    public MessageModel(Integer idMessage, String messageText) {
        this.idMessage = idMessage;
        this.messageText = messageText;
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

    @Override
    public String toString() {
        return "MessageModel{" +
                "idMessage=" + idMessage +
                ", messageText='" + messageText + '\'' +
                ", doctor=" + doctor +
                ", client=" + client +
                ", messageText='" + messageText + '\'' +
                '}';
    }
}
