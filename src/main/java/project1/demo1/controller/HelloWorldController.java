package project1.demo1.controller;


import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project1.demo1.HelloWorldBean;


	//controller 
	@RestController
	public class HelloWorldController {

		@Autowired
		private MessageSource messageSource;

		// GET
		// URI - /hello-world
		// method - "Hello World"
		@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
		public String helloWorld() {
			return "Hello World";
		}

		@GetMapping(path = "/hello-world-imp")
		public String helloWorld_improvise() {
			return "Hello World Improvise";
		}

		// hello-world-bean
		@GetMapping(path = "/hello-world-bean")
		public HelloWorldBean helloWorldBean() {
			return new HelloWorldBean(null);
		}

		/// hello-world/path-variable/uniq
		@GetMapping(path = "/hello-world/path-variable/{name}")
		public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
			return new HelloWorldBean(name);
			// return new HelloWorldBean("Hello World" + name);
		}

		@GetMapping(path = "/hello-world-internationalized")
		public String helloWorldInternationalized(
				@RequestHeader(name = "Accept-language", required = false) Locale locale) {
			return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
			// return messageSource.getMessage("good.morning.message", null,
			// LocaleContextHolder.getLocale());
		}

}


