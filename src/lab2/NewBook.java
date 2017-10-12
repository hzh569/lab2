package lab2;
import com.opensymphony.xwork2.ActionSupport;

public class NewBook extends ActionSupport {
	private String isbn;
	private String title;
	private String publisher;
	private String publishDate;
	private String price;
	private String authorName;
	private int authorAge;
	private String authorCountry;
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getAuthorAge() {
		return authorAge;
	}
	public void setAuthorAge(int authorAge) {
		this.authorAge = authorAge;
	}
	public String getAuthorCountry() {
		return authorCountry;
	}
	public void setAuthorCountry(String authorCountry) {
		this.authorCountry = authorCountry;
	}
	
	@Override
	public String execute() {
		Connector c = new Connector();
		c.addBook(isbn, title, authorName, authorAge, authorCountry, publisher, publishDate, price);
		c.close();
		return SUCCESS;
	}
}
