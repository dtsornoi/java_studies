package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Person person = Person.builder()
                .id(1)
                .firstName("John")
                .lastName("Smith")
                .build();


        Configuration configuration = new Configuration().configure().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(person);

        transaction.commit();

    }
}
