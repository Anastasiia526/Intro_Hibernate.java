package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {

        Animal cat = new Animal();
        cat.setName("Cat");
        cat.setAge(2);
        cat.setTail(true);
        Animal dog = new Animal();
        dog.setName("Dog");
        dog.setAge(7);
        dog.setTail(true);
        Animal hamster = new Animal();
        hamster.setName("Hamster");
        hamster.setAge(1);
        hamster.setTail(false);

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(cat);
        session.persist(dog);
        session.persist(hamster);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}