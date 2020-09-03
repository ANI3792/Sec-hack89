package com.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.demo.model.Player;
import com.demo.service.PlayerService;

public class PlayerServiceImpl implements PlayerService {
	private static int count;
	@Override
	public Player addPlayer(Player player) {
		player.setId(++count);
		playerMap.put(player.getId(), player);
		return player;
	}

	@Override
	public Player updatePlayer(Player player) {
		playerMap.put(player.getId(), player);
		return player;
	}

	@Override
	public Player getPlayerById(int id) {
		
		return playerMap.get(id);
	}

	@Override
	public void removePlayer(int id) {
		playerMap.remove(id);
		
	}

	@Override
	public List<Player> getAllPlayers() {
		
		return new ArrayList<>(playerMap.values());
	}

}
