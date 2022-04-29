package com.example.ps_project.configuration;

import com.example.ps_project.entity.Category;
import com.example.ps_project.entity.Product;
import com.example.ps_project.entity.User;
import com.example.ps_project.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

//fisierul de configuratie practic initializeaza tabelel din baza de date cu obiectele create

@Configuration
public class ConfigurationFile {

    @Bean
    CommandLineRunner commandLineRunner(Repository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository, OrderListRepository orderListRepository) {
        return args -> {

            User zoltan = new User("Zoltan", "Darlaczi", "darlaczi.zoltan@gmail.com");

            User alex = new User("Alex", "Alex", "alex.alex@gmail.com");

            Category shoes = new Category("Shoes", "Best shoes in town");

            Category shorts = new Category("Shorts", "Best shorts for sport");


            Product nikeCourtV = new Product("Under Army", (float) 120.4, (float) 2.4, "asdddfasd", "WHITE", "NIKE");
            Product adidasNano = new Product("Nano", (float) 243.4, (float) 3.4, "arwefewrfew", "BLACK", "adidas");

            shoes.getProductList().add(nikeCourtV);
            shoes.getProductList().add(adidasNano);
            nikeCourtV.setCategory(shoes);
            adidasNano.setCategory(shoes);

            userRepository.addItems(List.of(zoltan, alex));
            categoryRepository.addItems(List.of(shoes, shorts));
            productRepository.addItems(List.of(nikeCourtV,adidasNano));

            BufferedReader reader = new BufferedReader(new FileReader("user.csv"));
            String currentline;
            String[] currentDetails;
            while ((currentline = reader.readLine()) != null) {
                currentDetails = currentline.split(";");
                User newUser = new User(currentDetails[0],currentDetails[1],currentDetails[2]);
                 userRepository.addItem(newUser);
            }

           for(Object user:userRepository.findAllItemsCSV()){
               User user1 = (User) user;
               System.out.println(user1.getEmail());
           }
           reader.close();
        };
    }
}
