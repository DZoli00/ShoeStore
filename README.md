The project represents a shoe store.
--- BACKEND ---

The user can register to the site, and see all the available and unavailable shoes in the store. He can select one or more types of shoes. He can create an orderList by adding the selected shoes to the cart and then putting the orderList. The user can even modify his profile and all data on his profile, except the username. The admin has more options than a regular user. He can add, delete, modify and see all the shoes in the store. The admin can even modify the users' data.

At the start of the project the database is populated with some datas, which are defined in the configuration class or readed froma CSV file.

The project contains four entitites: User, Product, Category and Order.

Between the entitites there are some relationships, like OneToMany for example between Category and Product, or User and Orders.

The project implements the CRUD operations, which means that you can execute on all four entities create, read, update and delete methods

The User can create theri own orders, by selecting all the products they want to buy

--- FRONTEND ---

The application start with the Login Page. Here the user have to introduce his credetentials, email and password. If the user does not have an account, he cna clikc on the here button, which redirrect to the register page, where the user can create an account for himself, by introducing the email. a password and his last and first name. After the register the aplication reddirect the user back to the login page. Or he can go there by clicking the here button.

After sign in, it appears th categories and an add category button, which will be implemented after. But its role is that if the user is an admin then he can add a new category.But, if the user is a normal user, he just have to choose one of the categories, and then it will appear all the product which belong to that category.

And soon, will be implemented another great and interesting function, whiich will be a creating order. Its role is that it give the opotunity to the user, to select all the product he wants to buy and to create an order for himself.

- Tasks to do:
Back-end: (done)
database (done)
tables:
User (done)
Product (done)
Category (done)
Order (done)
relations between the tables (done)
CRUD operations (done)
Repository: (done)
JPA Repository (done)
Mockt Repository, read data from CSV (done)
Modify user, admin data (done)
Display the shoes by category (done)
Front-end: (it will be implemented without rules :) )
