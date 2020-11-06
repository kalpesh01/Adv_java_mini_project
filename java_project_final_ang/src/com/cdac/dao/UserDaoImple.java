package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.User;

@Repository
public class UserDaoImple implements UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void insertUser(User user) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(user);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
	}

	@Override
	public boolean checkUser(User user) {
		boolean b = hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from User where emailId = ? and userPass = ?");
				q.setString(0, user.getEmailId());
				q.setString(1, user.getUserPass());
				List<User> li = q.list();
				boolean flag = !li.isEmpty();
				if(flag) {
				user.setUserId(li.get(0).getUserId()); 
				user.setFirstName(li.get(0).getFirstName());
				}
				tr.commit();
				session.flush();
				session.close();
				return flag;
			}
			
		});
		return b;
	}
	
	
	@Override
	public boolean checkEmail(User user) {
		boolean b = hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from User where emailId = ?");
				q.setString(0, user.getEmailId());
				
				List<User> li = q.list();
				boolean flag = !li.isEmpty();
				
				if(flag) {
				user.setUserId(li.get(0).getUserId());
				}
				tr.commit();
				session.flush();
				session.close();
				return flag;
			}
			
		});
		return b;
	}
	
	
	
	
	@Override
	public boolean updateuser(User user) {
		boolean b = hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from User where emailId = ?");
				q.setString(0, user.getEmailId());
				List<User> li = q.list();
//				
				boolean flag = !li.isEmpty();
				
				session.update(user);
				
				tr.commit();
				session.flush();
				session.close();
				return flag;
			}
			
		});
		return b;
	}

	@Override
	public boolean verify_mail(User user) {
		boolean b = hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from User where emailId = ?");
				q.setString(0, user.getEmailId());
				List<User> li = q.list();
				boolean flag = !li.isEmpty();
				if(flag) {
				user.setEmailId(li.get(0).getEmailId()); 
				user.setUserId(li.get(0).getUserId());
				}
				tr.commit();
				session.flush();
				session.close();
				return flag;
			}
			
		});
		return b;
	}

	@Override
	public void resetpass(User user) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				
//				Expense ex = (Expense)session.get(Expense.class, expense.getExpenseId());
//				ex.setItemName(expense.getItemName());
//				ex.setPrice(expense.getPrice());
//				ex.setPurchaseDate(expense.getPurchaseDate()); 
				
				session.update(user);
				
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});}

	

	
		
	}

	

	
	

