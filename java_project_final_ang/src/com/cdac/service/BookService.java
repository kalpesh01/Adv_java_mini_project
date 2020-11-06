package com.cdac.service;

import java.util.List;
import com.cdac.dto.Book;

public interface BookService {
	
	List<Book> showSeats(Book book);
	void insertSeat(Book book);
	List<Book> findSeats(int userId);
	void removeSeat(int userId,int seatNo,String sect);
}
