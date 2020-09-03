package com.demo.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.demo.model.Player;
import com.demo.service.PlayerService;
import com.demo.service.impl.PlayerServiceImpl;

@Path("/player")
public class PlayerController {

	private PlayerService service=new PlayerServiceImpl();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Player addPlayer(Player player) {
		
		return service.addPlayer(player);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Player updatePlayer(Player player) {
		
		return service.updatePlayer(player);
	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Player getPlayerById(@PathParam("id")int id) {
		
		return service.getPlayerById(id);
	}

	@Path("/{id}")
	@DELETE
	public void removePlayer(@PathParam("id")int id) {
		service.removePlayer(id);
		
	}

	
	

}
