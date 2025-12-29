package com.jspiders;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String city;
    private Long pincode;

//    @OneToOne
//    @JoinColumn(name = "student_id")



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_id")
    private StudentEntity student;

    public long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public Long getPincode() {
        return pincode;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
}
