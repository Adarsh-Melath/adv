package com.jdbc.bootjdbcexample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public int createTable() {
    String query = "Create table if not exists users(" +
        "id int primary key auto_increment," +
        "name varchar(255) not null," +
        "age int," +
        "city varchar(55)" +
        ");";

    return this.jdbcTemplate.update(query);
  }

  public int insertUser(String name, int age, String city) {
    String insertQuery = "insert into users(name,age,city)values(?,?,?)";
    System.out.println("inserted");
    return this.jdbcTemplate.update(insertQuery, name, age, city);
  }

  public int updateUser(String name, int age, String city, int id) {
    String updateQuery = "update users set name = ?, age = ?, city = ? where id = ?";
    return this.jdbcTemplate.update(updateQuery, name, age, city, id);
  }

  public int deleteUser(int id) {
    String deleteQuery = "delete from users where id = ?";
    return this.jdbcTemplate.update(deleteQuery, id);
  }
}
