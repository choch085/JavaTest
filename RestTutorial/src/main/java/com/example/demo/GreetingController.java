package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s !";
    private static final String parameters = "Hello, %s ,%s !";
    private static final String matrix = "Hello, %s ,%s , %s !";
	private static final RequestMethod[] GET = null;
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="Chocho ko staaaaa!") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/greeting2")
    public Greeting greeting2(@RequestParam(value="name", defaultValue="Vladko ko staaaaa!") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(value = "/greeting2", method = RequestMethod.POST)
    public Greeting[] greeting3(@RequestParam(value="name", defaultValue="Vladko ko staaaaa!") String name) {
    	Greeting[] g = {new Greeting(counter.incrementAndGet(),String.format(template, "Chocho")),
    				    new Greeting(counter.incrementAndGet(),String.format(template, "Vladko"))};
        return g;
    }
    
    @RequestMapping("/greeting4")
    public Greeting greetingName1(@RequestParam(value="ime", defaultValue="nqma user") String name,@RequestParam(value="age", defaultValue="nqma vyzrast") String ag) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(parameters, name , ag));
    }
    
    @GetMapping("/greeting5")
    public Greeting greeting5(@RequestParam(value="name", defaultValue="Vladko ko tova e GetMapping!") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
//    @RequestMapping("/multipleParams?ime&age")
//    public Greeting greetingName2(@RequestParam(value="ime", defaultValue="nqma user") String name,@RequestParam(value="age", defaultValue="nqma vyzrast") String ag) {
//        return new Greeting(counter.incrementAndGet(),
//                            String.format(parameters, name , ag));
//    }
    
    @RequestMapping(
    		  value = "/multipleParams", 
    		  params = { "ime", "age" }, 
    		  method = {RequestMethod.GET,RequestMethod.POST})
    public Greeting greetingName3(@RequestParam(value="ime", defaultValue="nqma user") String name,@RequestParam(value="age", defaultValue="nqma vyzrast") String ag) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(parameters, name , ag));
    }
    
    @RequestMapping(value = "/ex/foos/{id},{id2}", method = RequestMethod.GET)
    @ResponseBody
    public String getFoosBySimplePathWithPathVariable(
      @PathVariable("id") long id, @PathVariable("id2") long id2) {
        return "Get a specific Foo with id=" + id + id2;
    } 

}
