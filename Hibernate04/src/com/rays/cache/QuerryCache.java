package com.rays.cache;

import java.util.Iterator;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.hibernate.UserDTO;

public class QuerryCache {
	
	public static void main(String[] args) {
		
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
	Query q1 = session.createQuery("from UserDTO where id = 1");
	
	 q1.setCacheable(true);
	
	List list1 = q1.list();
	
	Iterator it  = list1.iterator();
	
	while (it.hasNext()) {
		
		UserDTO dto1 = (UserDTO) it.next();
		
		System.out.print(" "+dto1.getId());
		System.out.print(" "+dto1.getFirstName());
		System.out.print(" "+dto1.getLastName());
		System.out.print(" "+dto1.getLoginId());
		System.out.print(" "+dto1.getPassword());
		System.out.print(" "+dto1.getDob());
		System.out.println(" "+dto1.getAddress());
	
	}
		
		
		Query q2 = session.createQuery("from UserDTO where id = 1");
		
		q2.setCacheable(true);
		
		q2.setCacheMode(CacheMode.REFRESH);
		
		List list2 = q2.list();
		
		Iterator it2 = list2.iterator();
		
		while (it2.hasNext()) {
			
			UserDTO  dto2 = (UserDTO) it2.next();
			
			System.out.print(" "+dto2.getId());
			System.out.print(" "+dto2.getFirstName());
			System.out.print(" "+dto2.getLastName());
			System.out.print(" "+dto2.getLoginId());
			System.out.print(" "+dto2.getPassword());
			System.out.print(" "+dto2.getDob());
			System.out.println(" "+dto2.getAddress());
			
		}
			
			tx.commit();
			
			session.close();
						
		}
	}
