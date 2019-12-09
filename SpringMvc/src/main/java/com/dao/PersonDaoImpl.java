package com.dao;

import com.model.Persontb;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("personDao")
public class PersonDaoImpl implements PersonDao {
    @Autowired
    public SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveUpdate(Persontb person) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = Main.getSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(person);
            transaction.commit();
        } catch(Exception ex) { ex.printStackTrace();
            if(transaction != null) transaction.rollback();
        } finally {
            try {if(session != null) session.close();} catch(Exception ex) {}
        }
        this.sessionFactory.getCurrentSession().saveOrUpdate(person);
    }

    @Override
    public List<Persontb> getPerson() {
        Session session = null;
        List<Persontb> getlist = null;
        try {
            session = Main.getSession();
            String queryStr = "from Persontb" ;
            Query query = session.createQuery(queryStr);
            getlist = query.list();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            try {if(session != null) session.close();} catch(Exception ex) {}
        }
        return getlist;
    }
}
