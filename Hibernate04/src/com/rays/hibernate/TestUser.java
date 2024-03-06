package com.rays.hibernate;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;


public class TestUser {
	
	public static void main(String[] args) throws Exception {
		
	
	
	// testAdd();
		// testUpdate();
		// testDelete();
		// testSearch();
		// TestGet();
		testAuthenticate();
		
	}

	private static void testAuthenticate() {
		
		UserModel model = new UserModel();
		
		UserDTO dto = model.authenticate("dipesh@gmail.com", "123");
		
		if(dto!= null){
			
			System.out.print(" "+dto.getId());
			System.out.print(" "+dto.getFirstName());
			System.out.print(" "+dto.getLastName());
			System.out.print(" "+dto.getLoginId());
			System.out.print(" "+dto.getPassword());
			System.out.print(" "+dto.getDob());
			System.out.println(dto.getAddress());
			
		}else {
				System.out.println("user not found");
			}
						
	}

	private static void TestGet() {
		
		UserModel model = new UserModel();
		
		UserDTO dto = model.findByPk(4);
		
		System.out.print(" "+dto.getId());
		System.out.print(" "+dto.getFirstName());
		System.out.print(" "+dto.getLastName());
		System.out.print(" "+dto.getLoginId());
		System.out.print(" "+dto.getPassword());
		System.out.print(" "+dto.getDob());
		System.out.println(" "+dto.getAddress());
	}

	private static void testSearch() {
		
		UserDTO dto = new UserDTO();
		
		dto.setFirstName("dipesh");
		
		UserModel model = new UserModel();
		
		List list = model.search(dto,0,4);
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			
			dto = (UserDTO) it.next();
			
			System.out.print(" "+dto.getId());
			System.out.print(" "+dto.getFirstName());
			System.out.print(" "+dto.getLastName());
			System.out.print(" "+dto.getLoginId());
			System.out.print(" "+dto.getPassword());
			System.out.print(" "+dto.getDob());
			System.out.println(" "+dto.getAddress());
			
		}
			
	}

	private static void testDelete() {

		UserDTO dto = new UserDTO();
		dto.setId(5);
		
		UserModel model = new UserModel();
		model.delete(dto);
		
	}

	private static void testUpdate() throws Exception {

		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
		
         UserDTO dto = new UserDTO();
		dto.setId(3);
		dto.setFirstName("silky");
		dto.setLastName("kataria");
		dto.setLoginId("silky@gmail.com");
		dto.setPassword("123");
		dto.setDob(sdf.parse("2001-04-09"));
		dto.setAddress("kota");
		
		UserModel model = new UserModel();
		model.update(dto);
	}

	private static void testAdd() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
		
		UserDTO dto = new UserDTO();
		
		dto.setFirstName("nikhil");
		dto.setLastName("khandait");
		dto.setLoginId("nikhil@gmail.com");
		dto.setPassword("123");
		dto.setDob(sdf.parse("2001-04-09"));
		dto.setAddress("indore");
		
		UserModel model = new UserModel();
		model.add(dto);
		
	}
	
}
