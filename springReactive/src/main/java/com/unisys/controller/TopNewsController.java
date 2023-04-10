package com.unisys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.spring6.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;

import com.unisys.service.TopNewsService;

import reactor.core.publisher.Mono;

@Controller
public class TopNewsController {

	@Autowired 
	TopNewsService topNewsService;
	
	@GetMapping("/tnews")
	String getTopNews(Model model){
		IReactiveDataDriverContextVariable irdv = new ReactiveDataDriverContextVariable(topNewsService.getTopNews());
		model.addAttribute("topNews",irdv );
		return "news";
	}
	
	@GetMapping("/hello")
	String sayHello(Model model) {
		Mono<String> hw = Mono.just("Hello World!");
		model.addAttribute("greeting",hw ); 
		return "hello";
	}
	
	
	@GetMapping("/react2")
	@ResponseBody
	String getNewsFromAnotherService(Model model) {
		
		return null;
		
	}
}
