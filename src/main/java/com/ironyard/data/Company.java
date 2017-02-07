package com.ironyard.data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by osmanidris on 2/5/17.
 */
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_SEQ")
    @SequenceGenerator(name = "COMPANY_SEQ", sequenceName = "COMPANY_SEQ")
    private long id;
    private String name;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address workAddress;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Instructor> teachers;

    public Company(){

    }
    public Company(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }

    public List<Instructor> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Instructor> teachers) {
        this.teachers = teachers;
    }
}
