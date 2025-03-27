package org.example.springdata.repo;

import org.example.springdata.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
    @Query("select p from Product p where p.name like %:n% and p.price > :p")
    List<Product> findByNameAndPrice(@Param("n") String name, @Param("p") double price);


}
