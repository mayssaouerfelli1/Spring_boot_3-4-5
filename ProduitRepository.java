package com.mayssa.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayssa.demo.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
