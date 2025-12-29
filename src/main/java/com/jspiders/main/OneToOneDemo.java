//package com.jspiders.main;
//
//import com.jspiders.AddressEntity;
//import com.jspiders.StudentEntity;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//import java.util.Scanner;
//
//public class OneToOneDemo {
//    private static SessionFactory sessionFactory = null;
//
//
//   static Scanner sc=new Scanner(System.in);
//    static{
//        System.out.println("1.Load Configuration ✅");
//        Configuration config = new Configuration();
//        config.configure("hibernate.cfg.xml");
//
//        System.out.println("2.Create SessionFactory");
//        sessionFactory = config.buildSessionFactory();
//    }
//
//    public static void main(String[] args) {
//
//        addStudentWithAddress();
//
//    }
//
//    public static void addStudentWithAddress() {
//        try (Session session = sessionFactory.openSession()) {
//            Transaction transaction = session.beginTransaction();
//
//            StudentEntity student = new StudentEntity();
//            student.setName("Sourashis");
//
//            AddressEntity address = new AddressEntity();
//            address.setCity("Bhadrak");
//            address.setPincode(756100L);
//
//            //link
//            student.setAddress(address);
//            address.setStudent(student);
//
//            session.persist(student);
//            transaction.commit();
//        }
//    }
//
//
//
//    }
//
//
//
//
