package com.meriem.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.mayssa.demo.entities.Produit;
import com.mayssa.demo.repos.ProduitRepository;
import com.mayssa.demo.services.ProduitService;

@SpringBootTest
class ProduitApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private ProduitService produitService;
	@Test
	public void testCreateProduit() {
	Produit prod = new Produit("PC DELL",2500.500,new Date());
	produitRepository.save(prod);
	}
	@Test
	public void testFindProduit()
	{
	Produit p = produitRepository.findById(2L).get(); 
	System.out.println(p);
	}
	@Test
	public void testUpdateProduit()
	{
	Produit p = produitRepository.findById(2L).get();
	p.setPrixProduit(1000.0);
	produitRepository.save(p);
	}
	@Test
	public void testDeleteProduit()
	{
	produitRepository.deleteById(2L);;
	}
	 
	@Test
	public void testListerTousProduits()
	{
	List<Produit> prods = produitRepository.findAll();
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testFindByNomProduitContains()
	{
	Page<Produit> prods = produitService.getAllProduitsParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements());
	System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	/*ou bien
	for (Produit p : prods.getContent())
	{
	System.out.println(p);
	} */
	}

}
