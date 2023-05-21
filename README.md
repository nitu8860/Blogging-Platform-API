# Blogging-Platform-API
This is an API for a Blogging Platform that allows users to create posts, follow other users, comment on posts, and perform various other actions related to blogging. It is built using the following frameworks and languages:

## Frameworks and Language Used
- Spring Framework (including Spring Boot, Spring MVC, Spring Data JPA)
- Java
- Hibernate
- MySQL
- Swagger
- AWS

## Data Flow
The data flow in the Blogging Platform API is organized into the following components:
- Controller
- Services
- Repository
- Database Design

## Controller
The Controller layer handles the incoming HTTP requests and manages the routing of these requests to the appropriate service methods. It provides the necessary endpoints for interacting with the API. Some of the key functionalities implemented in the controllers include:
- User registration and authentication
- Post creation and retrieval
- Follow and unfollow users
- Comment creation and retrieval
## Endpoints
### User Endpoints:
- **POST /api/users -** Create a new user.
- **GET /api/users/{id} -** Get user details by ID.
- **GET /api/users?username={username} -** Get user details by username.
- **PUT /api/users/{id} -** Update user details by ID.
- **DELETE /api/users/{id} -** Delete user by ID.

### Post Endpoints:
- **POST /api/posts -** Create a new post.
- **GET /api/posts/{id} -** Get post details by ID.
- **PUT /api/posts/{id} -** Update post details by ID.
- **DELETE /api/posts/{id} -** Delete post by ID.
- **GET /api/posts?userId={userId} -** Get posts by user ID.

### Follow Endpoints:
- **POST /api/follows -** Add a follower.
- **GET /api/follows/followers/{userId} -** Get followers of a user.
- **GET /api/follows/followings/{userId} -** Get followings of a user.

### Comment Endpoints:
- **POST /api/comments -** Add a comment to a post.
- **GET /api/comments/{userId}/{postId} -** Get comments of a post by user ID and post ID.

## Services
The Services layer contains the business logic of the application. It acts as an intermediary between the controllers and the repositories, implementing the necessary operations and transformations on the data. The services handle operations such as:
- User management (creation, retrieval, update, deletion)
- Post management (creation, retrieval, update)
- Follow management (adding followers, retrieving followers, retrieving followed users)
- Comment management (adding comments, retrieving comments)

## Repository
The Repository layer is responsible for interacting with the underlying database. It provides an abstraction over the database operations, allowing the services to query and manipulate the data. Some of the key responsibilities of the repositories include:
- User repository: Provides methods for retrieving and storing user-related data.
- Post repository: Offers methods for retrieving and storing post-related data.
- Follow repository: Handles the storage and retrieval of follow relationship data.
- Comment repository: Manages the storage and retrieval of comment data.

## Database Design
The database design for the Blogging Platform API follows the object-relational mapping (ORM) approach provided by Spring Data JPA. The entities (such as User, Post, Follow, Comment) are mapped to database tables, and the relationships between them are defined using annotations. The data is persisted in a relational database, such as MySQL.

## Data Structures Used
- Lists: Used to store collections of objects, such as lists of posts, followers, and followings.
- Sets: Utilized for storing unique values, such as unique followers and followings.
- Optional: Used in methods returning optional values, such as finding a user or post by its identifier.

## Project Summary
The Blogger Web Application is a full-stack web application that allows users to create, read, update, and delete blog posts and comments. It also allows users to follow other users and view their blog posts. The application uses Spring Boot, Spring MVC, and Spring Data JPA to implement the backend, and MySQL for the database. Swagger is used for API documentation. The frontend is built using HTML, CSS, and JavaScript.

Deployment
The application has been deployed on an AWS EC2 instance, and can be accessed using the following URL: http://3.16.180.96:8080/swagger-ui/index.html#.
