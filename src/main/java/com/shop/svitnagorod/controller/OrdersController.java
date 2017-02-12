package com.shop.svitnagorod.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.shop.svitnagorod.model.OrderDetails;
import com.shop.svitnagorod.model.Product;
import com.shop.svitnagorod.service.ProductService;

@Controller
@Scope("session")
@RequestMapping("/")
public class OrdersController {
	@Autowired
	ApplicationContext appContext;
	@Autowired
	ProductService productService;

	private static final String PRODUCTS = "products";

	private List<OrderDetails> listOrderDetails = new ArrayList<OrderDetails>();

	@GetMapping("/basket")
	public String showAllProductsFromBasket(Model model) {
		List<Product> listProducts = new ArrayList<Product>();

		if (!listOrderDetails.isEmpty()) {
			for (int i = 0; i < listOrderDetails.size(); i++) {
				Product product = productService.findById(listOrderDetails.get(i).getProduct_id());
				listProducts.add(product);
			}
		}
		model.addAttribute(PRODUCTS, listProducts);
		return "basket";
	}

	@RequestMapping(value = "/addProductToBasket", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {
	    "text/html; charset=UTF-8" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public @ResponseBody String addProductToBusket(@RequestBody int id) {
		if (!listOrderDetails.isEmpty()) {
			for (int i = 0; i < listOrderDetails.size(); i++) {
				if (listOrderDetails.get(i).getProduct_id() == id) {
					return appContext.getMessage("Item.already.exist", null, null);
				}
			}
		}
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setProduct_id(id);
		listOrderDetails.add(orderDetails);
		return appContext.getMessage("Item.succes", null, null);
	}

	@DeleteMapping("/deletFromBasket")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@RequestBody int id) {
		if (!listOrderDetails.isEmpty()) {
			for (int i = 0; i < listOrderDetails.size(); i++) {
				if (listOrderDetails.get(i).getProduct_id() == id) {
					listOrderDetails.remove(i);
				}
			}
		}
	}

}
