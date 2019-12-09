package com.service;

import com.model.Persontb;

import java.util.List;

public interface PersonService {
    public void saveUpdate(Persontb person);
    public List<Persontb> getPerson();
}

