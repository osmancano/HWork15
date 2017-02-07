package com.ironyard.data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by osmanidris on 2/5/17.
 */
@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INSTRUCTOR_SEQ")
    @SequenceGenerator(name = "INSTRUCTOR_SEQ", sequenceName = "INSTRUCTOR_SEQ")
    private long id;
    private String name;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address homeAddress;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address workAddress;
    private String hireDate;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private BootCamp bootCampTaught;

    public Instructor(){

    }
    public Instructor(String name, String hireDate) {
        this.name = name;
        this.hireDate = hireDate;
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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public BootCamp getBootCampTaught() {
        return bootCampTaught;
    }

    public void setBootCampTaught(BootCamp bootCampTaught) {
        this.bootCampTaught = bootCampTaught;
    }
}
