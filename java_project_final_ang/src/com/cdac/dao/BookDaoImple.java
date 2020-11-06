package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Book;


@Repository
public class BookDaoImple implements BookDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Book> selectSeats(Book book) {
		List<Book> bookList = hibernateTemplate.execute(new HibernateCallback<List<Book>>() {

			@Override
			public List<Book> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Book where section = ? and userId=?");
				q.setString(0, book.getSection());
				q.setInteger(1, 0);
				List<Book> li = q.list();
				System.out.println(li); 
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
			
		});
		return bookList;
	}
	
	
	@Override
	public void addSeat(Book book) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				
				Query q=session.createSQLQuery("update Book set user_id=?, email_id=? where seat_no=? and section=?");
				q.setInteger(0, book.getUserId());
				q.setString(1, book.getMailId());
				q.setInteger(2, book.getSeatNo());
				q.setString(3, book.getSection());
				q.executeUpdate();
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
	}


	@Override
	public List<Book> getSeats(int userId) {
		List<Book> bookList = hibernateTemplate.execute(new HibernateCallback<List<Book>>() {

			@Override
			public List<Book> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Book where userId=?");
				q.setInteger(0, userId);
				List<Book> li = q.list();
				System.out.println(li); 
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
			
		});
		return bookList;
	}


	@Override
	public void deleteSeat(int userId, int seatNo, String sect) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q=session.createSQLQuery("update Book set user_id=?, email_id=? where seat_no=? and section=? and user_id=?");
				q.setInteger(0, 0);
				q.setString(1, "none");
				q.setInteger(2, seatNo);
				q.setString(3, sect);
				q.setInteger(4, userId);
				q.executeUpdate();
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
		
	}
	

}
