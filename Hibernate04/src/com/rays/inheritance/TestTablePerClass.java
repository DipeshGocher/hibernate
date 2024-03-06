package com.rays.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestTablePerClass {

	
	public static void main(String[] args) {
		
		
		CreditCardPayment ccp = new CreditCardPayment();
		
		ccp.setAmount(1000);
		ccp.setCcType("visa");
		ccp.setPaymentType("imps");
		
		Cash c = new Cash();
		
		c.setAmount(2000);
		c.setPaymentType("cash");
		
		Cheque ch = new Cheque();
		
		ch.setAmount(5000);
		ch.setPaymentType("deposite");
		ch.setBankNumber("BOB");
		ch.setChqNumber("BOB6564367");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(ccp);
		
		session.save(c);
		
		session.save(ch);
		
		tx.commit();
		
		session.close();		
	}
}
