package com.singplayground.config;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.singplayground.model.Result;

@RestController
public class SampleController {

	@RequestMapping("/test1")
	public String test1() {
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
