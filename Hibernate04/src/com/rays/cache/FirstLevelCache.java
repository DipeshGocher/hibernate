package com.rays.cache;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.hibernate.UserDTO;

public class FirstLevelCache {
	
	public static void main(String[] args) {
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	Session session = sf.openSession();
	
	Transaction tx = session.beginTransaction();
	
	UserDTO dto1 = (UserDTO) session.get(UserDTO.class, 1);
	
	System.out.print(" "+dto1.getId());
	System.out.print(" "+dto1.getFirstName());
	System.out.print(" "+dto1.getLastName());
	System.out.print(" "+dto1.getLoginId());
	System.out.print(" "+dto1.getPassword());
	System.out.print(" "+dto1.getDob());
	System.out.println(" "+dto1.getAddress());
	
	
	//  session.evict(dto1);
	
	UserDTO dto2 = (UserDTO) session.get(UserDTO.class,1);
	
	System.out.print(" "+dto2.getId());
	System.out.print(" "+dto2.getFirstName());
	System.out.print(" "+dto2.getLastName());
	System.out.print(" "+dto2.getLoginId());
	System.out.print(" "+dto2.getPassword());
	System.out.print(" "+dto2.getDob());
	System.out.print(" "+dto2.getAddress());
			
	}
	
}
