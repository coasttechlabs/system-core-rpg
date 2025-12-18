package org.example.com.rpg.utils

import kotlinx.coroutines.delay

object Terminal {
	suspend fun printDelayed(input: String, chunkSize: Int = 1, delayMs: Long = 50) {
		input.chunked(chunkSize)
			.forEach {
				print(it)
				delay(delayMs)
			}
	}

	@Suppress("SpellCheckingInspection")
	suspend fun printDelayedln(input: String, chunkSize: Int = 1, delayMs: Long = 50) = printDelayed("$input\n", chunkSize, delayMs)
}