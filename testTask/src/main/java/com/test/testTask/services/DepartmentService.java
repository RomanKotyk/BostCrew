package com.test.testTask.services;

import com.test.testTask.domains.Department;
import com.test.testTask.domains.Lector;

/***
 * The interface for working with Department objects
 */
public interface DepartmentService {
    /***
     * To get department from DB by name
     * @param name - name of department
     * @return department
     */
    Department getDepartmentByName(String name);

    /***
     * To get head of department by name
     * @param name - name of department
     * @return head of department
     */
    Lector getHeadOfDepartment(String name);

    /***
     * To calculate average salary of department
     * @param name - name of department
     * @return average salary
     */
    double getAverageSalaryOfDepartment(String name);
}
