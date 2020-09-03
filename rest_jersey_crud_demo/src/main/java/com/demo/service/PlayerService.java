package com.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.model.Player;

public interface PlayerService {

	public static Map< Integer, Player> playerMap=new HashMap<>();

	public Player addPlayer(Player player);
	public Player updatePlayer(Player player);
	public Player getPlayerById(int id);
	public void removePlayer(int id);
	public List<Player> getAllPlayers();
}
