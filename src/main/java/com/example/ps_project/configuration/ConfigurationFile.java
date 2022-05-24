package com.example.ps_project.configuration;

import com.example.ps_project.entity.*;
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

    /**
     * This method populates the DB at the start of the program
     * @param userRepository
     * @param productRepository
     * @param categoryRepository
     * @param orderListRepository
     * @return
     */
    @Bean
    CommandLineRunner commandLineRunner(Repository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository, OrderListRepository orderListRepository) {
        return args -> {

            FactoryUser factoryUser = new FactoryUser();

            User zoltan = factoryUser.create(UserType.ADMIN, "Zoltan", "Darlaczi", "darlaczi.zoltan@gmail.com", "1234");
            User alex = factoryUser.create(UserType.NORMALUSER, "Alex", "Alex", "alex.alex@gmail.com", "12345");

            Category shoes = new Category("Shoes", "Best shoes in town");

            Category shorts = new Category("Shorts", "Best shorts for sport");

            Category sportShoes = new Category("Sport shoes", "Best shoesfor sport");


            Product nikeCourtV = new Product("Under Army", (float) 120.4, (float) 2.4, "asdddfasd", "WHITE", "NIKE");
            Product adidasNano = new Product("Nano", (float) 243.4, (float) 3.4, "arwefewrfew", "BLACK", "adidas");

            shoes.getProductList().add(nikeCourtV);
            shoes.getProductList().add(adidasNano);
            nikeCourtV.setCategory(shoes);
            adidasNano.setCategory(shoes);

            userRepository.addItems(List.of(zoltan, alex));
            categoryRepository.addItems(List.of(shoes, shorts, sportShoes));
            productRepository.addItems(List.of(nikeCourtV,adidasNano));

            BufferedReader reader = new BufferedReader(new FileReader("user.csv"));
            String currentline;
            String[] currentDetails;
            while ((currentline = reader.readLine()) != null) {
                currentDetails = currentline.split(";");
                if(currentDetails[4].compareTo("Admin") == 0) {
                    userRepository.addItem(factoryUser.create(UserType.ADMIN,currentDetails[0],currentDetails[1],currentDetails[2], currentDetails[3]));
                } else{
                    if(currentDetails[4].compareTo("NormalUser") == 0){
                        userRepository.addItem(factoryUser.create(UserType.NORMALUSER,currentDetails[0],currentDetails[1],currentDetails[2], currentDetails[3]));
                    }
                }
            }

           for(Object user:userRepository.findAllItemsCSV()){
               User user1 = (User) user;
               System.out.println(user1.getEmail());
           }
           reader.close();


        };
    }
}
