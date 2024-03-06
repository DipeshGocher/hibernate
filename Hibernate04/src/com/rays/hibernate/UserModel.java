package com.rays.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class UserModel {

	public void add(UserDTO dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(dto);

		tx.commit();

		session.close();

	}

	public void update(UserDTO dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.update(dto);

		tx.commit();

		session.close();
	}

	public void delete(UserDTO dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.delete(dto);

		tx.commit();

		session.close();

	}

	public List search(UserDTO dto, int pageNo, int pageSize) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Criteria c = session.createCriteria(UserDTO.class);

		if (dto != null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				c.add(Restrictions.eq("firstName", dto.getFirstName()));

			}
		}

		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;
			c.setFirstResult(pageNo);
			c.setMaxResults(pageSize);
		}
		
		List list = c.list();

		return list;	
	}
	
	public UserDTO findByPk(int id) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
	Session session = 	sf.openSession();
	
	UserDTO dto = (UserDTO) session.get(UserDTO.class, id);
	
	return dto;
	
	}
	
	public UserDTO authenticate(String loginId, String password) {
		
		UserDTO dto = null;
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
	Query q = session.createQuery("from UserDTO where loginId = ? and password = ?");
	
	q.setString(0,loginId);
	q.setString(1, password);
	
	List list = q.list();
	
	if (list.size()>0) {
		
		dto = (UserDTO) list.get(0);
	}	
		return dto;
}
}
