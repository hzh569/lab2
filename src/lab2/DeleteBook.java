package lab2;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteBook extends ActionSupport {
	private String isbn;
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public String execute() {
		Connector c = new Connector();
		boolean s = c.deleteBook(isbn);
		c.close();
		if (s) return SUCCESS;
		else return ERROR;
	}
}
