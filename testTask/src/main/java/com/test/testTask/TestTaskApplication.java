package com.test.testTask;


import com.test.testTask.domains.Lector;
import com.test.testTask.enums.TypeLector;
import com.test.testTask.services.DepartmentServiceImpl;
import com.test.testTask.services.LectorServiceImpl;
import com.test.testTask.utils.UserInputChecker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
public class TestTaskApplication {


	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(TestTaskApplication.class, args);
		DepartmentServiceImpl service = applicationContext.getBean(DepartmentServiceImpl.class);
		LectorServiceImpl lectorService = applicationContext.getBean(LectorServiceImpl.class);
		Scanner scan = new Scanner(System.in);
		String userRequest;
		String requestItem;
		while (true){
			System.out.println("Input your request!");
			userRequest = scan.nextLine();
			if(UserInputChecker.headOfDepartment(userRequest)){
				requestItem = userRequest.replace("Who is head of department ", "");
				String head = service.getHeadOfDepartment(requestItem).getName();
				System.out.printf("Head of %s department is %s\n", requestItem, head);

			}
			if(UserInputChecker.showSalaryOfDepartment(userRequest)) {
				requestItem = userRequest.replace("Show the average salary for the department ", "");
				requestItem = requestItem.substring(0,requestItem.length()-1);
				double averageSalary = service.getAverageSalaryOfDepartment(requestItem);
				System.out.printf("The average salary of %s is %.2f\n", requestItem, averageSalary);
			}
			if (UserInputChecker.countEmployeeOfDepartment(userRequest)){
				requestItem = userRequest.replace("Show count of employee for ", "");
				requestItem = requestItem.substring(0,requestItem.length()-1);
				int countEmployee = service.getDepartmentByName(requestItem).getLectors().size();
				System.out.printf("%d\n", countEmployee);

			}
			if (UserInputChecker.globalSearch(userRequest)){
				requestItem = userRequest.replace("Global search by ", "");
				List<Lector> lectors = lectorService.getLectorsByTemplate(requestItem);
				String listString = lectors.stream().map(Object::toString).collect(Collectors.joining(", "));
				System.out.println(listString);
			}
			if (UserInputChecker.departmentStatistics(userRequest)){
				requestItem = userRequest.replace("Show ", "");
				requestItem = requestItem.replace(" statistics.", "");
				List<Lector> lectors = service.getDepartmentByName(requestItem).getLectors();
				int professor = lectors.stream().filter(lector -> lector.getDegree() == TypeLector.Professor).collect(Collectors.toList()).size();
				int assistant = lectors.stream().filter(lector -> lector.getDegree() == TypeLector.Assistant).collect(Collectors.toList()).size();
				int associateProfessor = lectors.stream().filter(lector -> lector.getDegree() == TypeLector.Associate_professor).collect(Collectors.toList()).size();
				System.out.printf("assistans - %d.\n" +
								  "associate professors - %d\n" +
								  "professors - %d\n", assistant, associateProfessor, professor);
			}
		}
	}
}
