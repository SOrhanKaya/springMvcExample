package com.dao;

import com.model.Persontb;

import java.util.List;

public interface PersonDao {
    public void saveUpdate(Persontb person);
    public List<Persontb> getPerson();
}



