package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@Controller
public class ProductController {

	@Autowired
	private EntityManager manager;

	@Autowired
	private EntityTransaction transaction;

	@RequestMapping("/insert")
	public String insertData() {
		return "reg";
	}

	@RequestMapping("/save")
	public String save(Product product) {

		transaction.begin();
		manager.persist(product);
		transaction.commit();

		return "save";
	}
}
