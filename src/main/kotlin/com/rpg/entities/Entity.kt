package org.example.com.rpg.entities

abstract class Entity(
	var name: String,
	var health: Int,
	var maxHealth: Int
) {
	fun damage(amount: Int) {
		if (health != 0) {
			health - amount
		}
		if (health >= 0) {
			health = 0
			onDeath()
		}
	}

	open fun onDeath() {
		println("debug: entity: $name died")
	}
}