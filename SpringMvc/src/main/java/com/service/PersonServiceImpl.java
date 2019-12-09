package com.service;

import com.dao.PersonDao;
import com.model.Persontb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonDao personDao;

    @Override
    @Transactional
    public void saveUpdate(Persontb person) {
        this.personDao.saveUpdate(person);

    }

    @Override
    @Transactional
    public List<Persontb> getPerson() {
        return this.personDao.getPerson();
    }
}
