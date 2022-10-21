package com.example.les6opdrachthelloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloWorldController {
    @GetMapping(value="/hello")
    public String helloResponse(@RequestParam(name ="stringName", required = false) String stringName, @RequestParam(name ="language",required = false) String language){
        String response = "" ;
        String choice = "" ;
        String name = "" ;

        try{
            if(!language.isEmpty() && !language.equals("en") && !language.equals("nl")){
                throw new Exception();
            }
            if(language.equals("nl")){
                choice ="Hallo ";
                if(stringName != null){
                    name = stringName +"!";
                }else{
                    name = " wereld!";
                }
            }else {
                choice ="Hello ";
                if(stringName != null){
                    name = stringName + "!";
                }else {
                    name = "world!";
                }
            }
        }catch(Exception e){
            response = "Language is not correct";
            return response;
        }

        response = choice + name;
        return response;
    }

}
