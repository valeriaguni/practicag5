package com.doctors.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name="doctor")
public class DoctorModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private String department;

    private Date year;

    private String description;

    public DoctorModel() {
    }

    public DoctorModel(String name, String department, Date year, String description) {
        this.name = name;
        this.department = department;
        this.year = year;
        this.description = description;
    }

    public DoctorModel(Integer id, String name, String department, Date year, String description) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.year = year;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DoctorModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", year='" + year + '\'' +
                ", description='" + description +
               '}';
    }
}
