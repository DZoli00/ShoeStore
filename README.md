# PTOJECT_PS: Shoe Store

 - The project represents a shoe store.


 - The user can register to the site, and see all the available and unavailable shoes in the store.
 He can select one or more types of shoes. He can create an orderList by adding the selected shoes to the cart and then putting the orderList. The user can even modify his profile and all data on his profile, except the username.
 The admin has more options than a regular user. He can add, delete, modify and see all the shoes in the store. The admin can even modify the users' data.

 - At the start of the project the database is populated with some datas, which are defined in the configuration class or readed froma  CSV file.
 - The project contains four entitites: User, Product, Category and Order.
 - Between the entitites there are some relationships, like OneToMany for example between Category and Product, or User and Orders.
 - The project implements the CRUD operations, which means that you can execute on all four entities create, read, update and delete methods
 - The User can create theri own orders, by selecting all the products they want to buy


 # - Tasks to do:
   - Back-end: (done)
     - database (done)
     - tables: 
       - User (done)
       - Product (done)
       - Category (done)
       - Order (done)
     - relations between the tables (done)
     - CRUD operations (done)
     - Repository: (done)
       - JPA Repository (done)
       - Mockt Repository, read data from CSV (done)
     - Register
     - Modify user, admin data
     - Display the shoes by a condition
     - Create orders
   - Front-end: (it will be implemented without rules :) )
