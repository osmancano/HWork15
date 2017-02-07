package com.ironyard.data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by osmanidris on 2/5/17.
 */
@Entity
public class BootCamp {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOTCAMP_SEQ")
    @SequenceGenerator(name = "BOOTCAMP_SEQ", sequenceName = "BOOTCAMP_SEQ")
    private long id;
    private String name;
    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Instructor teacher;

    private String startDate;
    private String endDate;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Student> students;

    public BootCamp(){

    }
    public BootCamp(String name, String startDate, String endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Instructor getTeacher() {
        return teacher;
    }

    public void setTeacher(Instructor teacher) {
        this.teacher = teacher;
    }

    public String  getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
