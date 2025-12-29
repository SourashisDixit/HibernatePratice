package com.jspiders.main;

import com.jspiders.AddressEntity;
import com.jspiders.StudentEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OneToManyAllOperation {
    static Scanner sc=new Scanner(System.in);
    static SessionFactory sessionFactory;
    static {
        Configuration configuration= new Configuration();
        configuration.configure("hibernate.cfg.xml");
        System.out.println("Loading Configuration ✅");

      sessionFactory  = configuration.buildSessionFactory();
        System.out.println("Session Factory is Create✅");

    }

    public static void main(String[] args) {
  //  setStudentAndAddress();
//updateStudentById();
        updateAddressById();
    }

    public static void setStudentAndAddress(){

        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            System.out.println("First Add Student Information :");
            StudentEntity studentEntity = new StudentEntity();

            System.out.println("Enter the Student :");
            String name = sc.nextLine();
            studentEntity.setName(name);

            System.out.println("ADD the Address Information :--->");
            AddressEntity addressEntity = new AddressEntity();


            System.out.println("Enter the City Name :");
            String city = sc.nextLine();

            addressEntity.setCity(city);

            System.out.println("Enter the PinCode :-->");
            Long pincode = sc.nextLong();
            addressEntity.setPincode(pincode);

            //link both table -----

            List<AddressEntity>address=new ArrayList<>();
            address.add(addressEntity);


            studentEntity.setAddressEntities(address);
            addressEntity.setStudent(studentEntity);

            session.persist(studentEntity);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DATA IS NOT STORED IN DATA BASE ❌");
        }

    }


    public static void updateStudentById(){

        System.out.println("Enter the New Name ");
        String name=sc.nextLine();

        System.out.println("Enter the id :");
        Long id=sc.nextLong();


String HqlQry="update StudentEntity s set s.name=:name where s.id=:id";
try {
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    int rowAffected = session.createQuery(HqlQry).
            setParameter("name",name).setParameter("id",id)
            .executeUpdate();
       if(rowAffected>0){
           System.out.println(rowAffected +" Rows Successfully Updated ✅");
       }else{
           System.out.println(id +" Not Found ?");
       }
    transaction.commit();
    session.close();


} catch (HibernateException e) {
    e.printStackTrace();
}
    }

    public static void updateAddressById(){
        System.out.println("Enter the New Pin-code :");
        Long pincode=sc.nextLong();

        System.out.println("Enter the Existing City :");
        String city=sc.next();

        String HqlQry="update AddressEntity a set a.pincode =:pincode where a.city=:city";

        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            int rows = session.createQuery(HqlQry).setParameter("pincode", pincode)
                    .setParameter("city", city)
                    .executeUpdate();

             if(rows>0){
                 System.out.println(rows +" Rows Successfully Updated ✅");
             }else{
                 System.out.println(city + "not Found ?");
             }

            transaction.commit();
session.close();
        } catch (HibernateException e) {
            e.printStackTrace();

        }





    }




}
