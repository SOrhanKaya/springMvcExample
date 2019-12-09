package com.dao;

import com.model.Persontb;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class Main {

    private static SessionFactory sessionFactory = null;

    static {
        try{
            loadSessionFactory();
        }catch(Exception e){
            System.err.println("Exception while initializing hibernate util.. ");
            e.printStackTrace();
        }
    }
    public static void loadSessionFactory(){

        Configuration configuration = new Configuration();
        configuration.configure("/hibernate.cfg.xml");
        configuration.addResource("/Persontb.hbm.xml");
        configuration.addAnnotatedClass(Persontb.class);
        ServiceRegistry srvcReg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(srvcReg);
    }

    public static Session getSession() throws HibernateException {

        Session retSession=null;
        try {
            retSession = sessionFactory.openSession();
        }catch(Throwable t){
            System.err.println("Exception while getting session.. ");
            t.printStackTrace();
        }
        if(retSession == null) {
            System.err.println("session is discovered null");
        }

        return retSession;
    }


    }
