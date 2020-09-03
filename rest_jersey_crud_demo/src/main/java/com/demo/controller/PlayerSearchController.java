package com.demo.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.demo.model.Player;
import com.demo.service.PlayerService;
import com.demo.service.impl.PlayerServiceImpl;

@Path("/players")
public class PlayerSearchController {
	private PlayerService service = new PlayerServiceImpl();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Player> getAllPlayers() {

		return service.getAllPlayers();
	}
}
