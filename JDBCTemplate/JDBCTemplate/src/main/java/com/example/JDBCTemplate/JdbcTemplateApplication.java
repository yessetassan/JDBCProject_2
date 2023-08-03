package com.example.JDBCTemplate;

import com.example.JDBCTemplate.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class JdbcTemplateApplication {
	private static UserDao userDao;

	@Autowired
	public JdbcTemplateApplication(UserDao userDao) {
		this.userDao = userDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(JdbcTemplateApplication.class, args);

		userDao.getCourses(1);

	}

}
