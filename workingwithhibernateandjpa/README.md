## Spring Data JPA Entity Mappings(Relationship)

_OneToOne_

-   A `@OneToOne` relationship maps one entity to another entity. This is used when an entity has a single related entity.

```java
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne
    private Address address;
}
```

-   Here, each Author has a single Address, and each Address is linked to one Author.

_OneToMany_

-   A `@OneToMany` relationship indicates that one entity can be associated with multiple related entities. For example, one Author can write many Books.

```java
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
```

-   In this case, an Author can have multiple Book objects. The mappedBy attribute tells JPA that the author field in the Book entity manages the relationship.

_ManyToOne_

A `@ManyToOne` relationship is the inverse of @OneToMany. In this case, many Books can belong to a single Author.

```java
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Author author;
}
```

-   This defines that many Book entities can refer to a single Author.

_ManyToMany_

A `@ManyToMany` relationship represents a relationship where multiple entities can be associated with multiple other entities. For example, multiple Books can have multiple Categories.

```java
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
      name = "book_category",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;
}
```

-   This creates a many-to-many relationship between Book and Category, with a join table named book_category.

## Cascade Types Explained:

-   Here are the different types of cascade options in JPA:

-   `PERSIST`: When the parent is persisted (saved), the related entities are also persisted.

-   `MERGE`: When the parent is updated, the related entities are updated.

-   `REMOVE`: When the parent is deleted, the related entities are deleted.

-   `REFRESH`: If the parent is refreshed from the database, the related entities are refreshed.

-   `DETACH`: When the parent is detached from the persistence context, the related entities are also detached.

-   `ALL`: All of the above cascade operations are applied.

## What are Fetching Strategies?

-   Fetching strategies in JPA determine how and when related entities (associations) are loaded from the database when querying an entity. These strategies are essential for managing performance, particularly when dealing with large datasets and complex relationships.

-   JPA provides two main fetching strategies:

    -   Eager Fetching: Loads related entities immediately along with the parent entity.
    -   Lazy Fetching: Loads related entities on-demand, when they are accessed for the first time.

    OneToMany: LAZY

    ManyToOne: EAGER

    ManyToMany: LAZY

    OneToOne: EAGER
