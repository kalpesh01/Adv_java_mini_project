package com.cdac.dao;

import java.util.List;
import com.cdac.dto.Book;


public interface BookDao {
	List<Book> selectSeats(Book book);
	void addSeat(Book book);
	List<Book> getSeats(int userId);
	void deleteSeat(int userId,int seatNo,String sect);
	
}
