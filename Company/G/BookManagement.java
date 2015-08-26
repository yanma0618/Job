package G;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class BookManagement {
	static List<Book> books;
	static HashMap<String , List<Book>> bba;
	static HashMap<String , List<Book>> bbt;
	public static void main(String[] args){
		List<Book> books=new ArrayList<Book>();
		books.add(new Book("a", "ta1"));
		books.add(new Book("b","tb2"));
		books.add(new Book("a", "ta2"));
		books.add(new Book("b","tb1"));
		books.add(new Book("c", "tc1"));
		books.add(new Book("c","tc2"));
		
	}
	
	static List<Book> findbookbyauthor(String author){
		bba=new HashMap<String, List<Book>>();
		for(Book book:books){
			if(bba.containsKey(book.author)){
				bba.get(book.author).add(book);
			}else{
				List<Book> tmp=new ArrayList<Book>();
				tmp.add(book);
				bba.put(book.author,tmp);
			}	
		}
		return bba.get(author);
	}
	
	static List<Book> findbookbytitle(String title){
		bbt=new HashMap<String, List<Book>>();
		for(Book book:books){
			if(bbt.containsKey(book.title)){
				bbt.get(book.title).add(book);
			}else{
				List<Book> tmp=new ArrayList<Book>();
				tmp.add(book);
				bbt.put(book.title,tmp);
			}	
		}
		return bbt.get(title);
	}
}

class Book{
	String author;
	String title;
	int rating;
	PriorityQueue<User> queue;
	int queueSize=20;
	User user;
	public Book(String a, String t){
		this.author=a;
		this.title=t;
		queue=new PriorityQueue<User>(queueSize, new Comparator<User>(){

			public int compare(User o1, User o2) {
				return o2.rating-o1.rating;
			}
			
		});
	}
	
	public boolean goodRating(int rating){
		return this.rating>=rating;
	}
	
	public void enQueue(User u){
		queue.add(u);
	}
	
	public void assginUser(User u){
		u.addBook(this);
		this.user=u;
	}
}

class User{
	String name;
	int rating;
	List<Book> books;
	public User(String n, int rat){
		this.name=n;
		this.rating = rat;
		books=new ArrayList<Book>();
	}
	
	public void addBook(Book book){
		books.add(book);
	}
	
}