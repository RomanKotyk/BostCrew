package com.test.testTask.services;

import com.test.testTask.domains.Department;
import com.test.testTask.domains.Lector;
import com.test.testTask.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    LectorServiceImpl lectorService;

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.getByName(name);
    }

    @Override
    public Lector getHeadOfDepartment(String name) {
        return lectorService.getLectorById(departmentRepository.getByName(name).getHeadLectorId());
    }

    @Override
    public double getAverageSalaryOfDepartment(String name) {
        Department department = departmentRepository.getByName(name);
        List<Lector> lectorList = department.getLectors();
        double sumSalary = 0;
        for(Lector lector : lectorList){
            sumSalary += lector.getSalary();
        }

        return sumSalary/lectorList.size();
    }
}
