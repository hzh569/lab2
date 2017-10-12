package lab2;
import java.util.Iterator;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

public class SearchByName extends ActionSupport {
	private String name;
	private List<LBook> books;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<LBook> getBooks() {
		return books;
	}

	public void setBooks(List<LBook> books) {
		this.books = books;
	}
	
	@Override
	public String execute() {
		Connector c = new Connector();
		books = c.searchBook(name);
		c.close();
		return SUCCESS;
	}

}
