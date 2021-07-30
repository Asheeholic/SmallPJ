package co.micol.myHomePage.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {

	// 생성자를 처음에 실행할때 만들고 그 생성자를 통해 나온 클래스는 단 한개뿐임.
	private static DataSource dataSource = new DataSource();

	private Connection conn;

	private String driver;
	private String url;
	private String user;
	private String password;

	private DataSource() {
	}; // 외부에서 생성하지 못하게 만듬

	// 프로젝트에서 클래스를 하나만 만든다.
	// 메소드를 통해서 만든 단 하나의 클래스만 쓴다는것.
	public static DataSource getInstance() {
		return dataSource;
	}

	// 외부 properties 파일을 읽어 온다.
	private void configure() {

		Properties properties = new Properties();
		String resource = getClass().getResource("/db.properties").getPath();

		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 그 파일을 읽어서 실행하게 한다.
	public Connection getConnection() {
		configure();

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

}
