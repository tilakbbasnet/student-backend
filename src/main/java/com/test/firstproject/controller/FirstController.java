package com.test.firstproject.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class FirstController {

    //Request/Query Parameter
    // URL: http://localhost:8080/test/welcome?name=Anup
    @GetMapping("/welcome")
    public String studentDetails(@RequestParam("name") String sName, @RequestParam("address") String address){
        return sName+ " lives in "+address;
    }

    // URL: http://localhost:8080/test/welcome?name=Anup
    /*@GetMapping("/welcome")
    public String welcomeStd(@RequestParam("name") String sName){
        return "Hello "+sName;
    }*/

    // URL: http://localhost:8080/test/welcome/Anup/Age
    /*@GetMapping("/welcome/{name}/{age}")
    public String studentDetails(@PathVariable("name") String sName, @PathVariable("age") Integer sAge) {
        return sName+" is "+sAge+" years old.";
    }*/

    // Path Variable
    // URL: http://localhost:8080/test/welcome/Anup
    /*@GetMapping("/welcome/{name}")
    public String welcomeStudent(@PathVariable("name") String studentName) {
        return "Hello "+studentName;
    }*/

    // URL: http://localhost:8080/test/welcome
    /*@GetMapping("/welcome")
    public String sadfasd() {
        return "Hello World";
    }*/

}
