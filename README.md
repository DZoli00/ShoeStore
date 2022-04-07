# PTOJECT_PS: Shoe Store

 - The project represents a shoe store.

 - The user can register to the site, and see all the available and unavailable shoes in the store.
 He can select one or more types of shoes. He can create an order by adding the selected shoes to the cart and then putting the order. The user can even modify his profile and all data on his profile, except the username.
 The admin has more options than a regular user. He can add, delete, modify and see all the shoes in the store. The admin can even modify the users' data.
 The user and the admin both have "Forgot password" and "Forgot username" options, which means that if they somehow forgot their password or username they can receive an email with their username or an email to modify the password.

 # - Tasks to do:
   - Back-end:
     - database
     - tables:
       - User
       - Product
       - Category
       - Order
     - relations between the tables
     - CRUD operations
     - Repository:
       - JPA Repository
       - Mockt Repository, read data from CSV
     - Register
     - Modify user, admin data
     - Forgot- password, -username options
     - Display the shoes by a condition
     - Create orders
   - Front-end:


# Project documentation:
Proiectul deocamdata contine trei entitati:
User,Category si Product.
Am creat o baza de date si cate un table pentru fiecare entitate. Tabelele se genereaza automat. Am creat si primary key pentru fiecare tabel si un foreign key intre category_id din tabelul Product si i din tabelul Category. Am implementat si metodele POST,GET pentru fiecare tabel si PUT si DELETE dupa id pentru tabelul User. adica operatiile de CRUD, create, read, update, si delete.

