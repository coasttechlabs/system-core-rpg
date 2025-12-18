package org.example.com.rpg.todo

import org.example.com.rpg.utils.CardinalDirection

object WorldBuilder {
	fun buildWorld(): Room {
		val starterRoom = Room("Starter Room", "The room that you start in")
		val room2 = Room("Room2", "No")
		val room3 = Room("Room3", "No")

		starterRoom.addExit(CardinalDirection.NORTH, room2)
		starterRoom.addExit(CardinalDirection.WEST, room3)
		starterRoom.addExit(CardinalDirection.SOUTH, starterRoom)
		starterRoom.addExit(CardinalDirection.EAST, room2)

		return starterRoom
	}
}