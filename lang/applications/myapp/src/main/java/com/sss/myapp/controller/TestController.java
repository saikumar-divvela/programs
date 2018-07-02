package com.sss.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/movie")
public class TestController {
	
	@RequestMapping(value ="/{name}" , method = RequestMethod.GET)
	public String getMovie(@PathVariable String name,ModelMap map,HttpServletRequest req){
		map.addAttribute("movie", name);
		req.getSession().setAttribute("song", "how is this song");
		return "list";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getDefaultMovie(ModelMap map){
		return new ModelAndView("list","movie","This is default movie");
	}
	
	@RequestMapping(value ="/{name}/song" , method = RequestMethod.GET)
	public String getSong(@PathVariable String name,ModelMap map,HttpServletRequest req){
		map.addAttribute("movie", "the movie "+name+" has song"+req.getSession().getAttribute("song"));
		return "list";
	}
}
