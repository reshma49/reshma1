package com.fengjing.framework.hibernate.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fengjing.framework.hibernate.model.Department;
import com.fengjing.framework.hibernate.model.Employee;
import com.fengjing.framework.hibernate.service.EmployeeService;


@ContextConfiguration(locations={"classpath:spring-hibernate.xml"})
@RunWith(value=SpringJUnit4ClassRunner.class)
public class EmployeeServiceImplTest {
	
	@Resource(name="employeeServiceImplHibernate4")
	private EmployeeService employeeService;
	
	@Test
	public void save(){
		Employee employee=new Employee();
		
		employee.setEmpname("����");
		employee.setSex("Ů");
		employee.setLocation("��������");
		
		Department department=new Department();
		department.setDeptname("���Բ�");
		
		employee.setDepartment(department);
		
		employeeService.add(employee);
		
	}
	
	
	@Test
	public void listAll(){
		List<Employee> lists=employeeService.query(" from Employee ");
		for (Employee employee : lists) {
			System.out.println(employee.getEmpname()+"\t"+employee.getId()+"\t"+employee.getDepartment().getId()+"\t"+employee.getDepartment().getDeptname());
		}
	}
	
	
	
	@Test
	public void modify(){
		List<Employee> list=employeeService.query(" from com.fengjing.framework.hibernate.model.Employee employee where employee.id = 1 ");
		Employee employee = list.get(0);
		
		employee.setEmpname("��xx");
		employee.setSex("��");
		employee.setLocation("�й�����");
		
		employee.getDepartment().setDeptname("����Ժ");
		
		employeeService.update(employee);
	}
	
}
