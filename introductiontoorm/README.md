## Introduction to ORM(Object relational mapping)

-   Object-relational mapping (ORM) is a key concept in the field of Database Management Systems (DBMS), addressing the bridge between the object-oriented programming approach and relational databases. ORM is critical in data interaction simplification, code optimization, and smooth blending of applications and databases.

## What are the benefits of using object-relational mapping?

-   Faster application development
-   Simpler application maintenance
-   Improved security

A SQL injection attack is a malicious attempt to access private data by sending SQL queries through user forms on the application. ORMs use parameterized queries, which first send your database a query with placeholder values, not real data. (e.g., ? or :param). The real data is sent separately. This ensures that user input is treated as data, not executable SQL code. Using an ORM tool thus prevents unauthorized data access via SQL injection.

-   Improved performance

## What are the challenges of using object-relational mappings?

-   Impedance mismatches
    Complex data structures can be difficult to map between object-oriented programs and databases. Hierarchies that are possible to code in OOP can be very challenging to represent in a database, regardless of how sophisticated your ORM is.

-   Performance issues at higher complexity
    Directly querying a database is more computationally efficient than using an ORM. For highly complex queries, it may be more efficient to use SQL code rather than an Object-Relational Mapping (ORM) tool.

## JPA(Java Persistence API)

-   JPA is a way to achieve ORM,includes interfaces
    and annotations that you use in your java classes,requires a persistence provider (ORM tools) for implementation.

-   To use JPA,you need a presistence provider.A persistence provider is a specification.Example of JPA persistence provides include Hibernate,EclipseLink,and openJPA.These provides implement the JPA interfaces and provide the underlying functionality to interact with databases.

## key features of jpa

-   It is a lightweight persistence API.
-   Supports object-relational mapping with simple annotations.
-   Provides support for polymorphism and inheritance.
-   Allows dynamic and named queries.
-   Enables seamless switching between different ORM implementations.

## Commonly used JPA annotations

`
`@Entity`: Marks a Java class as a JPA entity, which can be persisted to a database.

`@Table`: Specifies the name of the database table to map the entity to.

`@Id`: Specifies the primary key field of the entity.

`@GeneratedValue`: Specifies how the primary key value should be generated.

`@Column`: Specifies the mapping of the entity field to a database column.

`@JoinColumn`: Specifies the mapping of a foreign key column between two entities.

`@OneToOne`: Defines a one-to-one relationship between two entities.

`@OneToMany`: Defines a one-to-many relationship between two entities.

`@ManyToOne`: Defines a many-to-one relationship between two entities.

`@ManyToMany`: Defines a many-to-many relationship between two entities.

`@NamedQuery`: Defines a named query for an entity.

`@NamedQueries`: Defines a set of named queries for an entity.

`@Transient`: Specifies that an entity field should not be persisted to the database.

`@Version`: Specifies the version field of the entity, used for optimistic locking.

`@Temporal`: Specifies the temporal type of a date or timestamp entity field.

## Hibernate

-   Hibernate is an open-source, lightweight ORM framework that simplifies database interactions for Java applications. It is an implementation of the JPA specification and provides additional features beyond JPA.

## Key feature of Hibernate

-   Implements JPA specifications.
-   Supports mapping Java classes to database tables.
-   Provides caching mechanisms to optimize performance.
-   Supports different databases without changing code.
-   Offers Hibernate Query Language (HQL) for querying.

## Here are a few Hibernate annotations that are not part of the JPA specification:

`@Proxy(lazy = false)`: Specifies that an entity should not be lazily loaded.

`@Type`: Specifies the type of a Hibernate-specific custom type for an entity field.

`@Fetch`: Specifies the fetch mode for a related entity or collection.

`@BatchSize`: Specifies the batch size for fetching related entities or collections.

`@SQLInsert`, `@SQLUpdate`, `@SQLDelete`: Specifies the SQL statements for inserting, updating, or deleting an entity.

`@Formula`: Specifies a derived property of an entity using an SQL expression.

`@DynamicUpdate`, `@DynamicInsert`: Specifies that only the modified properties should be included in the SQL update or insert statement.

## Difference btw JPA and Hibernate

-   JPA stands for Java Persistence API (Application Programming Interface). It was initially released on 11 May 2006. It is a Java specification that provides functionality and standards for ORM tools. It is used to examine, control, and persist data between Java objects and relational databases. It is regarded as a standard technique for Object Relational Mapping.

-   The main difference between JPA and Hibernate is that,

-   JPA is a specification that defines how ORM tools should function.
    Hibernate is an actual implementation of JPA that provides ORM capabilities

## Spring Data JPA

-   Spring Data JPA is build on top of the JPA specification,but it is not a JPA implementation itself.Instead, it simplifies working with JPA by providing higher-level abstractions and utilities.However,to use Spring Data JPA effectively,you still need a JPA implementation,such as Hibernate,to handle the actual database interactions.

## Here are some Spring Data JPA-specific annotations:

`@Repository`: Marks the interface as a Spring Data JPA repository.

`@Query`: Defines a custom JPQL or native SQL query for an entity.

`@NamedQuery`: Defines a named query for an entity.

`@Param`: Binds a method parameter to a named parameter in a custom query.

`@Lock`: Specifies the lock mode to use when fetching an entity.

`@EntityGraph`: Specifies the entity graph to use when fetching an entity.

`@Procedure`: Specifies the name of a stored procedure to call.

`@ProcedureParameter`: Specifies a parameter for a stored procedure.

`@EnableJpaRepositories`: Enables Spring Data JPA repositories in a Spring Boot application.

`@Transactional`: Specifies that a method should be executed within a transaction.

## Example:

-   Here’s an example of how you could perform a CRUD operation with and without Hibernate in a Java application.

-   `1.without hibernate`

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDExample {

  // Set up the database connection
  private static final String DB_URL = "jdbc:mysql://localhost/mydatabase";
  private static final String DB_USER = "myuser";
  private static final String DB_PASSWORD = "mypassword";

  public static void main(String[] args) {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
      // Create a new record
      String insertQuery = "INSERT INTO users (name, email) VALUES (?, ?)";
      PreparedStatement pstmt = conn.prepareStatement(insertQuery);
      pstmt.setString(1, "John Doe");
      pstmt.setString(2, "johndoe@example.com");
      int rowsAffected = pstmt.executeUpdate();
      System.out.println("Inserted " + rowsAffected + " rows.");

      // Retrieve a record
      String selectQuery = "SELECT * FROM users WHERE id = ?";
      pstmt = conn.prepareStatement(selectQuery);
      pstmt.setInt(1, 1);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        System.out.println(id + ": " + name + " (" + email + ")");
      }

      // Update a record
      String updateQuery = "UPDATE users SET email = ? WHERE id = ?";
      pstmt = conn.prepareStatement(updateQuery);
      pstmt.setString(1, "newemail@example.com");
      pstmt.setInt(2, 1);
      rowsAffected = pstmt.executeUpdate();
      System.out.println("Updated " + rowsAffected + " rows.");

      // Delete a record
      String deleteQuery = "DELETE FROM users WHERE id = ?";
      pstmt = conn.prepareStatement(deleteQuery);
      pstmt.setInt(1, 1);
      rowsAffected = pstmt.executeUpdate();
      System.out.println("Deleted " + rowsAffected + " rows.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
```

-   This code sets up a database connection using JDBC and performs CRUD operations on a MySQL database.

-   `2.With Hibernate`

```java
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CRUDExample {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
      tx.begin();

      // Create a new record
      User user = new User("John Doe", "johndoe@example.com");
      em.persist(user);

      // Retrieve a record
      user = em.find(User.class, 1L);
      System.out.println(user);

      // Update a record
      user.setEmail("newemail@example.com");
      tx.commit();
      System.out.println(user);

      // Delete a record
      em.remove(user);
      tx.commit();
    } catch (Exception e) {
      if (tx.isActive()) {
        tx.rollback();
      }
      e.printStackTrace();
    } finally {
      em.close();
      emf.close();
    }
  }
}
```

-   `same thing using jpa`

```java
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  public User() {}

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }

  // getters and setters

  @Override
  public String toString() {
    return id + ": " + name + " (" + email + ")";
  }
}
```

-   This class is annotated with JPA annotations that tell Hibernate how to map its fields to database columns. For example, the @Entity annotation marks this class as a JPA entity, and the @Table annotation specifies the name of the database table to map to. The @Id annotation marks the id field as the primary key, and the @GeneratedValue annotation tells Hibernate to automatically generate a value for this field.

-   `3.using spring data jpa`

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
```

-   This is the repository interface that extends JpaRepository. It provides a number of methods out of the box for performing CRUD operations on the User entity.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CRUDExample implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  public static void main(String[] args) {
    SpringApplication.run(CRUDExample.class, args);
  }

  @Override
  public void run(String... args) {
    // Create a new record
    User user = new User("John Doe", "johndoe@example.com");
    userRepository.save(user);

    // Retrieve a record
    user = userRepository.findById(1L).orElse(null);
    System.out.println(user);

    // Update a record
    user.setEmail("newemail@example.com");
    userRepository.save(user);
    System.out.println(user);

    // Delete a record
    userRepository.delete(user);
  }
}
```
