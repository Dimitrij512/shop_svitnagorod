package com.shop.svitnagorod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.shop.svitnagorod.DTO.BannerDTO;
import com.shop.svitnagorod.DTO.CategoryDTO;
import com.shop.svitnagorod.DTO.ProductDTO;
import com.shop.svitnagorod.DTO.SuperCategoryDTO;
import com.shop.svitnagorod.service.BannerService;
import com.shop.svitnagorod.service.CategoryService;
import com.shop.svitnagorod.service.OrdersService;
import com.shop.svitnagorod.service.ProductService;
import com.shop.svitnagorod.service.SuperCategoryService;
import com.shop.svitnagorod.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final String SUPERCATEGORIES = "superCategories";
	private static final String SUPERCATEGORY = "spuerCategory";
	private static final String CATEGORIES = "categories";
	private static final String CATEGORY = "category";
	private static final String PRODUCTS = "products";
	private static final String PRODUCT = "product";
	private static final String BANNERS = "banners";
	private static final String BANNER = "banner";
	public static final String USERS = "users";

	@Autowired
	SuperCategoryService superCategoryService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;
	@Autowired
	OrdersService orderService;
	@Autowired
	BannerService bannerService;

	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String loginPage(Model model) {

		return "admin";
	}

	@GetMapping("/settingWebsite")
	public String settingWebsite(Model model) {

		return "settingWebSite";
	}

	@GetMapping("/settingWebsite/users")
	public String managementUsers(Model model) {

		model.addAttribute(USERS, userService.findAllUser());

		return "managementUsers";
	}

	@GetMapping("/settingWebsite/createUpdateSuperCategory")
	public String createSuperCategory(Model model) {

		model.addAttribute(SUPERCATEGORY, new SuperCategoryDTO());

		return "createUpdateSuperCategory";
	}

	@GetMapping("/settingWebsite/createUpdateCategory")
	public String createCategory(Model model) {

		model.addAttribute(CATEGORY, new CategoryDTO());
		model.addAttribute(SUPERCATEGORIES, superCategoryService.findAllCategory());

		return "createUpdateCategory";
	}

	@GetMapping("/settingWebsite/createUpdateSuperCategory/{id}")
	public String updateSuperCategory(@PathVariable int id, Model model) {

		model.addAttribute(SUPERCATEGORY, superCategoryService.findById(id));

		return "createUpdateSuperCategory";
	}

	@PostMapping("/settingWebsite/createUpdateSuperCategory/{id}")
	public String saveSuperCategory(@ModelAttribute("orders") SuperCategoryDTO superCategoryDTO, Model model) {
		superCategoryService.update(superCategoryDTO);

		return "redirect:/admin/settingWebsite/superCategory";
	}

	@PostMapping("/settingWebsite/createUpdateSuperCategory")
	public String addSuperCategory(@ModelAttribute(SUPERCATEGORIES) SuperCategoryDTO superCategoryDTO) {

		superCategoryService.save(superCategoryDTO);

		return "redirect:/admin/settingWebsite/superCategory";
	}

	@PostMapping("/settingWebsite/createUpdateCategory")
	public String addCategory(@ModelAttribute(CATEGORY) CategoryDTO categoryDTO) {
		System.out.println("---------------- somthing post controller ----------------------");

		categoryService.save(categoryDTO);

		return "redirect:/admin/settingWebsite/categories";
	}

	@GetMapping("/settingWebsite/categories")
	public String managementCategory(Model model) {

		model.addAttribute(CATEGORIES, categoryService.findAllCategory());
		model.addAttribute(CATEGORY, new CategoryDTO());
		model.addAttribute(SUPERCATEGORIES, superCategoryService.findAllCategory());

		return "managementCategories";
	}

	@GetMapping("/settingWebsite/products")
	public String managementProduct(Model model) {

		model.addAttribute(PRODUCTS, productService.findAllProducts());
		model.addAttribute(PRODUCT, new ProductDTO());
		model.addAttribute(CATEGORIES, categoryService.findAllCategory());

		return "managementProducts";
	}

	@GetMapping("/settingWebsite/superCategory")
	public String managementSuperCategory(Model model) {
		model.addAttribute(SUPERCATEGORIES, superCategoryService.findAllCategory());

		return "managementSuperCategories";
	}

	@GetMapping("/settingWebsite/banners")
	public String managementBanner(Model model) {

		model.addAttribute(BANNERS, bannerService.findAll());
		model.addAttribute(BANNER, new BannerDTO());

		return "managementBanners";
	}

	@PostMapping("/settingWebsite/banners")
	public String createBanner(@ModelAttribute(BANNERS) BannerDTO bannerDTO) {

		bannerService.save(bannerDTO);

		return "redirect:/admin/settingWebsite/banners";
	}

	@PostMapping("/settingWebsite/products")
	public String addProduct(@ModelAttribute(PRODUCTS) ProductDTO productDTO) {

		productService.save(productDTO);

		return "redirect:/admin/settingWebsite/products";
	}

	@DeleteMapping("/settingWebsite/superCategory/delete")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleterSuperCategory(@RequestBody int id) {

		superCategoryService.delete(id);
	}

	@DeleteMapping("/settingWebsite/categories/delete")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCategory(@RequestBody int id) {

		categoryService.delete(id);
	}

	@DeleteMapping("/settingWebsite/user/delete")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@RequestBody int id) {

		userService.delete(id);
	}

	@DeleteMapping("/settingWebsite/products/delete")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@RequestBody int id) {

		productService.delete(id);
	}

	@DeleteMapping("/settingWebsite/banner/delete")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBanner(@RequestBody int id) {

		bannerService.delete(id);
	}

}
