package com.oxg.app;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.json.JSONArray;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonFactory;
import com.oxg.app.data.Employee;
import com.oxg.app.repository.EmployeeRepository;


@Component
public class EmployeeCommandLineRunner implements CommandLineRunner {
	
private final EmployeeRepository repository;
	
	
	public EmployeeCommandLineRunner(EmployeeRepository repository) {
		super();
		this.repository = repository;
	}



	@Override
	public void run(String... args) throws Exception {
		/*
		Stream.of("Kentucky Brunch Brand Stout", "Good Morning", "Very Hazy", "King Julius",
                "Budweiser", "Coors Light", "PBR").forEach(name-> 
                repository.save(new Beer(name))
                		);
		repository.findAll().forEach(System.out::println);
		*/
		ArrayList<Employee>answer = this.readJSONFile();
		answer.forEach(employee->{
			System.out.println(employee.getLastName());
			repository.save(employee);
		});
		repository.findAll().forEach(System.out::println);
		
	}
	
	
	private ArrayList<Employee> readJSONFile() {
		JsonFactory jfactory = new JsonFactory();
		Integer id, age;
		Integer salary;
		String firstName, lastName, position, office, sex, startDate;
		String fileName = "/Users/olegg/work/angular4/ng4-employee-tracker/src/assets/api/employees.json"; 
	
		ArrayList<Employee> result = new ArrayList<Employee>(); 
		try{
            String text = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);

            //JSONObject obj = new JSONObject(text);
          //JSONArray arr = obj.getJSONArray("employees");
            JSONArray arr = new JSONArray(text);
            

            for(int i = 0; i < arr.length(); i++){
                lastName = arr.getJSONObject(i).getString("lastName");
                firstName = arr.getJSONObject(i).getString("firstName");
                position = arr.getJSONObject(i).getString("position");
                office = arr.getJSONObject(i).getString("office");
                sex = arr.getJSONObject(i).getString("sex");
                startDate = arr.getJSONObject(i).getString("startDate");
                id = new Integer(arr.getJSONObject(i).getInt("id"));
                age = new Integer(arr.getJSONObject(i).getInt("age"));
                salary = new Integer(arr.getJSONObject(i).getInt("salary"));
                System.out.println("id, lastName, salary : " + id  + ", " + lastName + ", "+ salary);
                System.out.println(firstName  + ", " + position + ", "+ age);
                
                result.add(new Employee(id, firstName, lastName,
                			position, office, sex, age, startDate, salary));
            }           
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
		return result;
	}
	
	
	/*
	@Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() 
    {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("dbc:mysql://localhost:3306/test");
        driverManagerDataSource.setUsername("olegg");
        driverManagerDataSource.setPassword("gabba1123");

        return driverManagerDataSource;
    } */
	
	public static void main(String[] args) {
		/*
		EmployeeCommandLineRunner runner = new EmployeeCommandLineRunner();
		ArrayList<Employee>answer = runner.readJSONFile();
		answer.forEach(employee->System.out.println(employee.getLastName()));
		*/
	}
}
