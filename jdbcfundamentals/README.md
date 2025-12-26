## JDBC(Java Database Connectivity) Fundamentals

-   JDBC is an API in Java that allows you to connect to a database, execute SQL queries, and process the results.

## Different type of statments

-   1._Statment_

    -   use this for general-purpose acess to your database
    -   useful when you are not using parameters in sql statements at runtime.
    -   The statement interface cannot accept parameters
    -   The important methods of Statment interface:
        -   executeUpdate(String sql)
        -   executeQuery(String sql)

-   2._PreparedStatement_

    -   use this when you plan to use the sql statements many times.
    -   the preparedStatement interface accepts input parameters at runtime
    -   setString(int paramIndex,String value)
    -   setInt(int paramIndex,int value)

-   3._CallableStatment_
    -   it is an interface in JDBC api which is used to call _stored procedures_ from the java code .CallableStatment extends PreparedStatment which in turn extends Statement.

# Difference between Statement and PreparedStatement

| Statement                                                                      | PreparedStatement                                                               |
| ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------- |
| It is used to execute normal SQL queries.                                      | It is used to execute parameterized or dynamic SQL queries.                     |
| It is preferred when a particular SQL query is to be executed only once.       | It is preferred when a particular query is to be executed multiple times.       |
| You cannot pass the parameters to SQL query using this interface.              | You can pass the parameters to SQL query at run time using this interface.      |
| This interface is mainly used for DDL statements like CREATE, ALTER, DROP etc. | It is used for any kind of SQL queries which are to be executed multiple times. |
| The performance of this interface is very low.                                 | The performance of this interface is better than the Statement Interface.       |

## What is a Transaction?

-   A transaction is a sequence of operations performed as a single logical unit of work. A transaction ensures the ACID properties: Atomicity, Consistency, Isolation, and Durability.

-   Atomicity: Ensures that all operations within the transaction are completed successfully. If any operation fails, the entire transaction is rolled back.
-   Consistency: Ensures that the database is in a consistent state before and after the transaction.
-   Isolation: Ensures that transactions are isolated from each other until they are completed.
-   Durability: Ensures that the changes made by the transaction are permanent and stored in the database.
-   Why Use Transactions?
    Transactions are essential for maintaining data integrity and consistency, especially when performing multiple operations that depend on each other. Without transactions, partial updates can lead to data inconsistencies and corruption.

## Transaction Methods in JDBC

-   1. setAutoCommit(boolean autoCommit)

        - Used to enable or disable auto-commit mode.

        - true → each SQL statement is committed automatically (default).

        - false → you control when to commit or rollback.

-   2. commit()

        - Commits all the SQL statements executed since the last commit/rollback.

        - Use this after successful execution of all statements in a transaction.

-   3. rollback()

        - Undoes all SQL statements executed since the last commit.

        - Useful when an error occurs in the transaction to avoid partial updates.

## Spring Boot JDBC

-   _Why is Spring JDBC?_

-   Spring JDBC Framework takes care of all the low-level details starting from opening the connection, preparing and executing the SQL statement, processing exceptions, handling transactions, and finally closing the connection.

-   _JdbcTemplate_

    -   JdbcTemplate is a core class in Spring JDBC that simplifies database access. It helps to avoid boilerplate code like creating connections, preparing statements, handling exceptions, and closing resources.
