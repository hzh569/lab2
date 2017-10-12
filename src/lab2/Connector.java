package lab2;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connector {
	private Connection con = null;
	private Statement st = null;
	
	public Connector() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//String url = "jdbc:mysql://127.0.0.1:3306/Data?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3306/app_bookhzh";
			//String user = "root"; //用户名
			String user = "345ojxnmn2";
			//String psw = "2810"; //密码
			String psw = "ix4izlx3hwjilm4kj2j02m4hyy0m2x05ym42k0kh";
			con = DriverManager.getConnection(url, user, psw); //建立连接
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void addBook(String ISBN, String Title, String AuthorName, int AuthorAge,
			String AuthorCountry, String Publisher, String PublishDate, String Price) {
		try {
			ResultSet rs = st.executeQuery("select * from Author where Name = '" 
					+ AuthorName + "';");
			int AuthorID;
			if (rs.next()) {
				AuthorID = rs.getInt("AuthorID");
			} else {
				st.executeUpdate("insert into Author (Name, Age, Country) VALUES ('" +
						AuthorName + "', " + AuthorAge + ", '" + AuthorCountry + "');");
				rs = st.executeQuery("select * from Author where Name = '" 
						+ AuthorName + "';");
				rs.next();
				AuthorID = rs.getInt("AuthorID");
			}
			st.executeUpdate("insert into Book (ISBN, Title, AuthorID, Publisher," + 
					" PublishDate, Price) values ('" + ISBN + "', '" + Title + "', " +
					AuthorID + ", '" + Publisher + "', '"+ PublishDate + "', '" + Price + "');");
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<LBook> searchBook(String AuthorName) {
		List<LBook> list = new ArrayList<LBook>();
		try {
			ResultSet rs = st.executeQuery("select * from Author where Name = '" 
					+ AuthorName + "'");
			int id;
			if (rs.next()) {
				id = rs.getInt("AuthorID");
				ResultSet rs2 = st.executeQuery("select * from Book where AuthorID = " + id);
				while (rs2.next()) {
					list.add(new LBook(rs2.getString("ISBN"), rs2.getString("Title")));
				}
				if (rs2 != null) rs2.close();
			}
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Book showBookDetail(String isbn) {
		Book book = new Book();
		book.setIsbn(isbn);
		try {
			ResultSet rs = st.executeQuery("select * from Book where ISBN = '" 
					+ isbn + "';");
			if (rs.next()) {
				book.setTitle(rs.getString("Title"));
				book.setPublishDate(rs.getString("PublishDate"));
				book.setPublisher(rs.getString("Publisher"));
				book.setPrice(rs.getString("Price"));
				book.setAuthor(new Author());
				book.getAuthor().setAuthorid(rs.getInt("AuthorID"));
				ResultSet rs2 = st.executeQuery("select * from Author where AuthorID = " +
						book.getAuthor().getAuthorid());
				if (rs2.next()) {
					book.getAuthor().setName(rs2.getString("Name"));
					book.getAuthor().setAge(rs2.getInt("Age"));
					book.getAuthor().setCountry(rs2.getString("Country"));
				}
				if (rs2 != null) rs2.close();
			}
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public boolean deleteBook(String isbn) {
		int i = 0;
		try {
			i = st.executeUpdate("delete from Book where isbn = '" + isbn + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i > 0) return true;
		else return false;
	}
	
	public void updateBook(String isbn, String authorName, int age,
			String country, String publisher, String publishDate, String price) {
		try {
			ResultSet rs = st.executeQuery("select * from Book where ISBN = '" 
					+ isbn + "';");
			rs.next();
			int id = rs.getInt("AuthorID");
			ResultSet rs2 = st.executeQuery("select * from Author where AuthorID = " + id);
			rs2.next();
			String oldname = rs2.getString("Name");
			
			if (!oldname.equals(authorName)) {
				ResultSet rs3 = st.executeQuery("select * from Author where Name = '" + authorName + "'");
				if (rs3.next()) {
					id = rs3.getInt("AuthorID");
				} else {
					st.executeUpdate("insert into Author (Name, Age, Country) VALUES ('" +
							authorName + "', " + age + ", '" + country + "');");
					rs = st.executeQuery("select * from Author where Name = '" 
							+ authorName + "';");
					rs.next();
					id = rs.getInt("AuthorID");
				}
				st.executeUpdate("update Book set AuthorID=" + id + " where ISBN = '" + isbn + "'");
				if (rs3 != null) rs3.close();
			} else {
				st.executeUpdate("update Author set Name='" + authorName + "', Age=" + age +
						", Country='" + country + "' where AuthorID = " + id);
			}
			st.executeUpdate("update Book set Publisher='" + publisher + "', PublishDate='" +
					publishDate + "', Price='" + price + "' where ISBN = '" + isbn + "';");
			if (rs2 != null) rs2.close();
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if (st != null) st.close();
			if (con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
