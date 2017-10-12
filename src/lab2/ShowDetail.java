package lab2;
import com.opensymphony.xwork2.ActionSupport;

public class ShowDetail extends ActionSupport {
	private String isbn;
	private Book book;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String execute() {
		Connector c = new Connector();
		book = c.showBookDetail(isbn);
		c.close();
		return SUCCESS;
	}
}
