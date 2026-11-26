package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping("/fetch")
	public String getData(Model model) {
		List<Product> resultList = manager.createQuery("FROM Product", Product.class).getResultList();
		model.addAttribute("data", resultList);
		return "data";
	}

	@RequestMapping("/update")
	public String update(@RequestParam(value = "id") int id, Model model) {
		Product product = manager.find(Product.class, id);
		model.addAttribute("edit", product);
		return "edit";
	}

	@RequestMapping("/editsavedata")
	public String editSavedata(Product product) {

		transaction.begin();
		manager.merge(product);
		transaction.commit();

		return "save";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "id") int id, Model model) {
		transaction.begin();
		Product product = manager.find(Product.class, id);
		manager.remove(product);
		transaction.commit();
	
		return "delete";
	}

}