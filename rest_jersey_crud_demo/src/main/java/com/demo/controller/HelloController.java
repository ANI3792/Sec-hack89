package com.demo.controller;

import javax.ws.rs.GET;

import javax.ws.rs.Path;

@Path("/")
public class HelloController {

    @GET
    public String helloworld() {
    	String s="test below endpoints using POSTMAN\n";
    	s=s+"GET -> http://localhost:9000/rest_jersey_crud_demo/player/{id}   (for getting player by id) \n";
    	s=s+"POST -> http://localhost:9000/rest_jersey_crud_demo/player (send JSON data without id in Body of POSTMAN)\n";
    	s=s+"PUT -> http://localhost:9000/rest_jersey_crud_demo/player (send JSON data for some existig id and update some fields from body of POSTMAN)\n";
    	s=s+"DELETE -> http://localhost:9000/rest_jersey_crud_demo/player/{id} (for deleteing player by id)\n";
    	s=s+"GET -> http://localhost:9000/rest_jersey_crud_demo/players  (for getting all players)";
    	s=s+"\n\n***NOTE THAT THE TOMCAT IS RUNNING ON PORT 9000 FOR THIS EXAMPLE CHANGE THE PORT NUMBER ABOVE AS PER YOUR TOMCAT ";
        return "Helloworld !!!!\n"+s;
    }
}
