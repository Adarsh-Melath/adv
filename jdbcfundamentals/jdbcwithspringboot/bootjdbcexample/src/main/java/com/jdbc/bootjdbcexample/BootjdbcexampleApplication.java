package com.jdbc.bootjdbcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jdbc.bootjdbcexample.dao.UserDao;

@SpringBootApplication
public class BootjdbcexampleApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(BootjdbcexampleApplication.class, args);
	}

	public void run(String... args) throws Exception {
		// System.out.println(this.userDao.createTable());

		// userDao.insertUser("Adarsh", 18, "Kasaragod");
		// userDao.insertUser("Sreerag", 19, "Kannur");
		// userDao.updateUser("Adarsh", 18, "Berlin", 1);

		userDao.deleteUser(2);

	}

}
