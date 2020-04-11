package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@Autowired
	HomeService homeService;
	
	@RequestMapping("getGame")
	@ResponseBody
	public List<String> getGame(){
		List<String> response = new ArrayList<>();
		response = homeService.getGame();
		return response;
	}

}
