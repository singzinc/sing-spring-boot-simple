package com.singplayground.controller;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.singplayground.config.QuoteService;
import com.singplayground.model.Result;

@RestController
public class SampleController {

	@Bean
	QuoteService quoteService() {
		return new QuoteService();
	}

	@RequestMapping("/test1")
	public String test1() {

		QuoteService quoteService = quoteService();
		Long id = new Long("1");
		System.out.println("this is id : " + id);
		quoteService.requestQuote(id);
		System.out.print("");

		return "test1";
	}

	@RequestMapping("/test2")
	public @ResponseBody HashMap test2() {
		HashMap result = new HashMap();
		result.put("status", "Y");
		return result;
	}

	@RequestMapping("/test3")
	public @ResponseBody Result test3() {
		Result result = new Result();
		result.setTitle("this is title");
		result.setStatus("Y");
		result.setTotal(10);
		return result;
	}
}
