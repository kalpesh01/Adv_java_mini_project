package com.cdac.cntr;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.cdac.dto.Book;
import com.cdac.dto.User;
import com.cdac.service.BookService;

@Controller
@SessionAttributes("book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/prep_book_seat_form.htm",method = RequestMethod.GET)
	public String prep_book_form(ModelMap map) {
		map.put("book", new Book());
		return "book_form";
	}
	
	@RequestMapping(value = "/available_seats.htm",method = RequestMethod.POST)
	public String availableSeats(Book book,ModelMap map,HttpSession session) {
		List<Book> li=bookService.showSeats(book);
		map.put("blist",li);
		return "booking";
	}
	
	@RequestMapping(value = "/add_seat.htm",method = RequestMethod.GET)
	public String addSeat(Book book,ModelMap map,HttpSession session) { 
		
		int userId = ((User)session.getAttribute("user")).getUserId();
		String mailId = ((User)session.getAttribute("user")).getEmailId();
		book.setUserId(userId);
		book.setMailId(mailId);
		
		bookService.insertSeat(book);
		
		List<Book> li=bookService.showSeats(book);
		map.put("blist",li);
		return "booking";
	}
	

	@RequestMapping(value = "/prep_see_list.htm",method = RequestMethod.GET)
	public String seeList(ModelMap map,HttpSession session) { 
		
		int userId = ((User)session.getAttribute("user")).getUserId();
		
		List<Book> li=bookService.findSeats(userId);
		map.put("mlist",li);
		return "my_list";
	}
	
	
	@RequestMapping(value = "/seat_delete.htm",method = RequestMethod.GET)
	public String expenseDelete(@RequestParam Map<String,String> requestParms,ModelMap map,HttpSession session) {
		int seatNo=Integer.parseInt(requestParms.get("seatNumber"));
		String sect=requestParms.get("sect");
		
		int userId = ((User)session.getAttribute("user")).getUserId();
		
		bookService.removeSeat(userId,seatNo,sect); 
		
		List<Book> li=bookService.findSeats(userId);
		map.put("mlist",li);
		return "my_list";
	}
	
	
	@RequestMapping(value = "/seat_update_form.htm",method = RequestMethod.GET)
		public String seatUpdate(@RequestParam Map<String,String> requestParms,ModelMap map,HttpSession session,Book book) { 
		int seatNo=Integer.parseInt(requestParms.get("seatNumber"));
		String sect=requestParms.get("sect");
		
		int userId = ((User)session.getAttribute("user")).getUserId();
		bookService.removeSeat(userId,seatNo,sect);
		return "book_form";
	}
	
}
