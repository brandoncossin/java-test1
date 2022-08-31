package com.ecommerce.controllers;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.models.SignupForm;
import com.ecommerce.models.LoginForm;
import com.ecommerce.models.ProductForm;
import com.ecommerce.models.CartItem;
import com.ecommerce.models.CartPageForm;

import com.ecommerce.Database;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
	Database db = new Database();
    @RequestMapping("/")
    public ModelAndView getIndex(HttpSession session){
        ModelAndView getIndexPage = new ModelAndView("index");
        getIndexPage.addObject("PageTitle", "Home");
		if(session.getAttribute("user") != null){
			getIndexPage.addObject("LoggedIn", true);
			System.out.println("Activated");
		}
		else{
			getIndexPage.addObject("LoggedIn", false);
		}
        System.out.println("In index page");
        return getIndexPage;
    }
	@PostMapping("/")
    public ModelAndView addToCart(@ModelAttribute("ProductForm") ProductForm ProductForm, BindingResult result,
	@RequestParam("product_id") int product_id, HttpSession session) throws SQLException{
        ModelAndView getIndexPage = new ModelAndView("index");
        if(session.getAttribute("user") != null){
			getIndexPage.addObject("LoggedIn", true);
			String name=(String)session.getAttribute("user"); 
			db.addToCart(product_id, name, 1);
			System.out.println(product_id + " " + session.getAttribute("user"));
		}
		else{
			getIndexPage.addObject("LoggedIn", false);
			System.out.println("Added the" + product_id);
		}
        return getIndexPage;
    }
    @GetMapping("/login")
	public String loginFormPage(HttpSession session) {
		System.out.println("in login");
		if(session.getAttribute("user") != null){
			return "index";
		}
		else{
			return "login";
		}
	}
	@PostMapping("/login")
	public String loginPage(@ModelAttribute("LoginForm") LoginForm LoginForm, BindingResult result,
	@RequestParam("phone_number") String phone_number,
	@RequestParam("password") String password,
	HttpSession session) throws SQLException {
		System.out.println(phone_number + " " + password);
		session.setAttribute("user", phone_number);
		db.login(phone_number, password);
		return "index";
	}
	@GetMapping("/signup")
	public String signupFormPage(HttpSession session) {
		System.out.println("in sign up");
		if(session.getAttribute("user") != null){
			return "index";
		}
		else{
			return "signup";
		}
	}
	@PostMapping("/signup")
	public String signupPage(@ModelAttribute("SignupForm") SignupForm SignupForm, BindingResult result,
	@RequestParam("phone_number") String phone_number,
	@RequestParam("first_name") String first_name,
	@RequestParam("last_name") String last_name,
	@RequestParam("password") String password) throws SQLException {
		//model.put("message", this.message);
		System.out.println(phone_number);
		String hashed_password = BCrypt.hashpw(password,BCrypt.gensalt());
		db.Insert(phone_number, first_name, last_name, hashed_password);
		return "login";
	}
	@GetMapping("/cart")
	public ModelAndView cartPage(HttpSession session) throws SQLException {		
		if(session.getAttribute("user") == null){
			ModelAndView getIndexPage = new ModelAndView("index");
			return getIndexPage;
		}
		else{
			ModelAndView getCartPage = new ModelAndView("cart");
			getCartPage.addObject("LoggedIn", true);
			String userName=(String)session.getAttribute("user");
			//System.out.println(db.getCartAll(name));
			ResultSet resultSet = db.getCartAll(userName);
			List<CartItem> cartList = new ArrayList<>();
			while (resultSet.next()) {
				String name, phone_number;
				int item_id, price, quantity;
				item_id = resultSet.getInt("item_id");
				price = resultSet.getInt("price");
				quantity = resultSet.getInt("quantity");
				name = resultSet.getString("name");
				phone_number = resultSet.getString("phone_number");
				CartItem item= new CartItem();
				item.setItemId(item_id);
				item.setPrice(price);
				item.setName(name);
				item.setQuantity(quantity);
				item.setPhoneNumber(phone_number);				
				cartList.add(item);
				System.out.println(item);
				}
			
			getCartPage.addObject("cartSet", cartList);
			getCartPage.addObject("cartSum", db.getSum(userName));
			return getCartPage;
		}
	}
	@PostMapping("/cart")
	public ModelAndView cartPage(@ModelAttribute("CartPageForm") CartPageForm CartPageForm, BindingResult result,
	@RequestParam("product_id") int product_id, @RequestParam("phone_number") String phone_number, HttpSession session
	) throws SQLException {
		//model.put("message", this.message);
		ModelAndView getCartPage = new ModelAndView("cart"); 
		System.out.println(product_id + "and user" + phone_number);
		return getCartPage;
	}
	@GetMapping("/logout")
	public String logoutFunction(HttpSession session) {	
		session.removeAttribute("user");
		return "index";
	}
}
