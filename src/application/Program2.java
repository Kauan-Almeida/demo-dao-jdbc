package application;

import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: Department findById ====");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: Department findByAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department dep : list) {
			System.out.println(dep);
		}
		
		System.out.println("\n=== TEST 3: Department inserd ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);		
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: Department Update ===");
		Department dep2 = departmentDao.findById(10);
		dep2.setName("Food");
		departmentDao.update(dep2); 
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: Department Delete===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}
