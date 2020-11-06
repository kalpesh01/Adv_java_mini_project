package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.BookDao;
import com.cdac.dto.Book;

@Service
public class BookServiceImple implements BookService{

	@Autowired
	private BookDao bookDao;

	@Override
	public List<Book> showSeats(Book book) {
		return bookDao.selectSeats(book);
	}

	@Override
	public void insertSeat(Book book) {
		bookDao.addSeat(book);
	}

	@Override
	public List<Book> findSeats(int userId) {
		return bookDao.getSeats(userId);
	}

	@Override
	public void removeSeat(int userId, int seatNo, String sect) {
		bookDao.deleteSeat(userId,seatNo,sect);
		
	}	

}
