package com.api.book.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entity.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

//    private static List<Book> list = new ArrayList<>();
//
//    static {
//        list.add(new Book(12, "Java Complete Reference", "XYZ"));
//        list.add(new Book(14, "Head First to java", "ABC"));
//        list.add(new Book(16, "Think in Java", "LML"));
//    }

    // get all books
    public List<Book> getAllBook() {
    	List<Book> list =(List<Book>) this.bookRepository.findAll();
        return list;
    }

    // get single book by id
    public Book getBookById(int id) {
        Book book = null;
        try {
			//book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        	book = this.bookRepository.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return book;
    }
    
    //ADD BOOK
    public Book addBook(Book b) {
    	Book result = bookRepository.save(b);
    	return result;
    }

    // delete
    public void deletebook(int bid) {
       // list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
    	this.bookRepository.deleteById(bid);
    }

    // UPDATE
    public void updateBook(Book book, int bookId) {
//        list = list.stream().map(b -> {
//            if (b.getId() == bookId) {
//                b.setTitle(book.getTitle());
//                b.setAuthor(book.getAuthor());
//            }
//            return b;
//        }).collect(Collectors.toList());
    	book.setId(bookId);
    	bookRepository.save(book);
    }

}
