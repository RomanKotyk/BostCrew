package com.test.testTask.utils;

/***
 * Class that contains static method for checking user input
 */
public class UserInputChecker {
    public static boolean headOfDepartment(String request){
        return request.matches("Who is head of department (.)*");
    }

    public static boolean departmentStatistics(String request){
        return request.matches("Show (.)* statistics.");
    }

    public static boolean showSalaryOfDepartment(String request){
        return request.matches("Show the average salary for the department (.)*.");
    }

    public static boolean countEmployeeOfDepartment(String request){
        return request.matches("Show count of employee for (.)*.");
    }

    public static boolean globalSearch(String request){
        return request.matches("Global search by (.)*.");
    }
}
