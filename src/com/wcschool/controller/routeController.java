package com.wcschool.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class routeController {
	@RequestMapping("index")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("Home_Page");
	}

	@RequestMapping("comments")
	public ModelAndView comments(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("comments");
	}

	@RequestMapping("map")
	public ModelAndView map(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("map");
	}
}
