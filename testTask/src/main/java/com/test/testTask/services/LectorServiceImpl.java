package com.test.testTask.services;

import com.test.testTask.domains.Lector;
import com.test.testTask.repositories.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LectorServiceImpl implements LectorService {

    @Autowired
    LectorRepository lectorRepository;

    @Override
    public Lector getLectorById(Long id) {
        return lectorRepository.getById(id);
    }

    @Override
    public List<Lector> getLectorsByTemplate(String template) {
        List<Lector> lectors = new ArrayList<>();
        lectors = lectorRepository.getAllLector();
        lectors.stream().filter(lector -> lector.getSurname().contains(template) || lector.getName().contains(template));
        return lectors;
    }

    @Override
    public List<Lector> getAllLectors() {
        List<Lector> lectors = new ArrayList<>();
        lectors = lectorRepository.getAllLector();
        return lectors;
    }
}
