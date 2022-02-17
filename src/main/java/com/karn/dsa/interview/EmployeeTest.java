package com.karn.dsa.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeTest{
	public static void main(String[] args) {
		new EmployeeTest().operate();
	}
	private void operate(){
		Employee ashish=new Employee(Employee.Gender.M,"ASHISH", 2L);
		Employee aditya=new Employee(Employee.Gender.M,"ADITYA", 1L);
		Employee sukanya=new Employee(Employee.Gender.F,"SUKANYA", 3L);
		List<Employee> list=new ArrayList<>();
		list.add(ashish);
		list.add(aditya);
		list.add(sukanya);
		System.out.println(list);

		Map<Long,Employee> map=new HashMap<>();
	 list.forEach(e-> map.put(e.getId(),e));
		System.out.println(map);

	}
}



class Employee{
private final Gender gender;
private final String name;
private final Long id;

Employee(Gender gender, String name, Long id){
this.gender=gender;
this.name=name;
this.id=id;
}

public Gender getGender(){
return gender;
} 
public String getName(){
return name;
}
public long getId(){
return id;
}
 enum Gender{
	M,
	F,
	N
}
public String toString(){
return id+" "+name;
}
}