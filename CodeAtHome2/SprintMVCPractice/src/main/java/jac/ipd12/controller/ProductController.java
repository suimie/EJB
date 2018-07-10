package jac.ipd12.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	@RequestMapping("/products")
	public ModelAndView getAllProduct(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView("productList");
		return mv;
	}
}
