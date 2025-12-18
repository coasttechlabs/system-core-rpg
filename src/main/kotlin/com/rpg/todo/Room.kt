package org.example.com.rpg.todo

import org.example.com.rpg.utils.CardinalDirection

data class Room(
	val name: String,
	val description: String
) {
	val exits = mutableMapOf<CardinalDirection, Room>()

	fun addExit(direction: CardinalDirection, room: Room) =
		exits.put(direction, room)

	override fun toString(): String = name
}