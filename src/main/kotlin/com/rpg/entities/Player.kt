package org.example.com.rpg.entities

import org.example.com.rpg.todo.Item
import java.util.UUID

class Player(
	name: String,
	health: Int,
	maxHealth: Int
): Entity(name, health, maxHealth) {
	val sessionId by lazy { UUID.randomUUID().toString() }
	val inventory = mutableMapOf<Int, Item>()

	companion object {
		fun createDefaultPlayer(): Player =
			Player("Better Name", 100, 100)
	}
}