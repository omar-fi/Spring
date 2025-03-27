package org.example.springdata;

import org.example.springdata.entity.Product;
import org.example.springdata.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Autowired
    ProductRepo productRepo;

    @Override
    public void run(String... args) throws Exception {
        //ajouter nouveau produit
        productRepo.save(new Product(null,"omar",2000,4));
        productRepo.save(new Product(null,"mari",2000,5));

        //rechercher les produits existants
        List<Product> products = productRepo.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });

        //Chercher les produits qui contient o avec le prix superieure a 200
       List<Product> products2 = productRepo.findByNameAndPrice("o",200);
       products2.forEach(p->{
           System.out.println(p.toString());
       });


       //Supprimer un produit
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long id = scanner.nextLong();
        productRepo.deleteById(id);
        List<Product> products3 = productRepo.findAll();
        products3.forEach(p->{
            System.out.println(p.toString());
        });


        //Ajoute un nouveau produit
        System.out.println("Enter product name: ");
        String name = scanner.next();
        System.out.println("Enter product price: ");
        Long price = scanner.nextLong();
        System.out.println("Enter product quantite ");
        int quantite = scanner.nextInt();
        productRepo.save(new Product(null,name,price,quantite));
        List<Product>  add =productRepo.findAll();
        add.forEach(p->{
            System.out.println(p.toString());
        });
        System.out.println("adam");
        System.out.println("Enter product name: ");

    }
}



