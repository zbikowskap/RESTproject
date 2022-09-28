package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ApiController {
    /*
     * 1. Poprzez parametr
     * 2. Poprzez ścieżkę
     * 3.Poprzez headery
     * 4.Poprzez body
     *
     * */
//  1. Poprzez parametr
    // podajesz parametry i podajesz dane w postman
   /* @RequestMapping(method = RequestMethod.GET, path = "/api")
    public ResponseEntity<String> getWelcome
    (@RequestParam(required = false, defaultValue = "Jon", name = "param1") String name,
     @RequestParam(required = false, defaultValue = "Doe", name = "param2") String surname) {

        String foo = "Hello" +" " + name + " "+ surname;
        return new ResponseEntity<>(foo, HttpStatus.OK);
    }*/

    //2.Poprzez sieżkę
    //http://localhost:8080/api/Adam

   /* @RequestMapping(method = RequestMethod.GET,path = "/api/{name}")
    public ResponseEntity<String> getWelcome(@PathVariable(name = "name")String otherName){
        String foo = "Hello" + " "+ otherName;
        return new ResponseEntity<>(foo, HttpStatus.OK);
    }*/

    //3. Poprzez headery
  /*  //http://localhost:8080/api
    @RequestMapping(method = RequestMethod.GET,path = "/api")
    public ResponseEntity<String> getWelcome(@RequestHeader()String name){
        String foo = "Hello "+ name;
        return new ResponseEntity<>(foo, HttpStatus.OK);
    }*/

    //4.Porzez body ze sktóconym zapisem.. GetMaping i bez opisu path
    @GetMapping("/api")
    public ResponseEntity<String> getWelcome(@RequestBody() String name){
        String foo = "Hello " + name;
        return new ResponseEntity<>(foo, HttpStatus.OK);
    }






   /* @RequestMapping(method = RequestMethod.GET,path = "/api")
    public ResponseEntity<String> getWelcome(){
        String foo = "Hello";
        return new ResponseEntity<>(foo, HttpStatus.OK);
        }*/


}
