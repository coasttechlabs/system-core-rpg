package org.example.com.rpg.core

import kotlinx.coroutines.delay
import org.example.com.rpg.entities.Player
import org.example.com.rpg.todo.Room
import org.example.com.rpg.todo.WorldBuilder
import org.example.com.rpg.utils.Terminal.printDelayed
import org.example.com.rpg.utils.Terminal.printDelayedln
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/*
 * Central class for the game
 * Controls game states and their flow
 */
class GameEngine {
	private var currentState = GameState.STARTUP
	private var isRunning = true
	private lateinit var player: Player
	private lateinit var room: Room

	/*
	 * Starts the game loop
	 */
	suspend fun start() {
		init()
		loop()
//		while (isRunning) {
//			when (currentState) {
//				GameState.STARTUP -> runStartupSequence()
//				GameState.MENU -> runMenuSequence()
//				GameState.PLAY -> runPlaySequence()
//				GameState.EXIT -> exitSequence()
//			}
//		}
	}

	private suspend fun init() {
		printDelayed("Initialising")
		printDelayedln("...", delayMs = 500)
		player = Player.createDefaultPlayer()
		room = WorldBuilder.buildWorld()
		printDelayedln("Here's your name: ${player.name}")
		printDelayedln("Session ID: ${player.sessionId}")
		printDelayedln("...", delayMs = 500)
	}

	private suspend fun loop() {
		while(isRunning) {
			printRoomInfo()
			processCommand(readln())
		}
	}

	suspend fun printRoomInfo() {
		printDelayedln("Current room: ${room.name}, description: ${room.description}")
		printDelayedln("Available exits:")
		room.exits.forEach {
			printDelayedln("		${it.key}: ${it.value}")
		}
	}

	suspend fun processCommand(command: String) {
		when(command.lowercase().trim()) {
			"move" -> move()
			"look" -> look()
			"exit" -> exit()
			else -> printDelayedln("Unknown command")
		}
	}

	fun move() {
		TODO("Fill me!")
	}
	fun look() {
		TODO("Print room info")
	}
	fun exit() {}

	private suspend fun runStartupSequence() {
		printDelayed("Loading")
		printDelayed("...", chunkSize = 1, delayMs = 500)
		println(" Done")

		currentState = GameState.MENU
	}

	private suspend fun runMenuSequence() {
		printDelayedln("""
			===== Welcome =====
			
			1. Start new game
			2. Exit
		""".trimIndent())

		when (readlnOrNull()?.toIntOrNull()) {
			1 -> currentState = GameState.PLAY
			2 -> currentState = GameState.EXIT
			else -> println("Invalid input")
		}
	}

	private suspend fun runPlaySequence() {
		printDelayedln("""
			Initiating play sequence
			
			To return to main menu, type exit
		""".trimIndent())
		val input = readlnOrNull()
		if (input == "exit") {
			currentState = GameState.MENU
		} else {
			println("Unrecognized option: \"$input\"")
		}
	}

	// TODO: make exit program
	private suspend fun exitSequence() {
		printDelayedln("Exiting...")
		isRunning = false
	}
}