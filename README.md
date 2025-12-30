# VOID SHELL

**VOID SHELL** is a text-based cyberpunk RPG written in Kotlin. You play as a NetRunner navigating a corrupt digital system, hacking servers, fighting security drones, and managing your system integrity.

## 🎮 How to Play

The game runs entirely in your terminal console. You interact with the world by typing commands to move, inspect items, and fight enemies.

### The Objective
Explore the directory structure, find the **Keycard**, and gain access to the locked **Server Farm**.

### ⌨️ Command List
Type these commands into the console when prompted:

**Exploration**
* `look` - specific details about the current room and visible items.
* `go [direction]` - Move to a new area (e.g., `go north`, `go east`).
* `take [item]` - Pick up an item from the floor (e.g., `take potion`).
* `use [item]` - Heal yourself or unlock doors (e.g., `use keycard`).
* `inv` - Check your current inventory.

**Combat**
* `fight` - Search the room for enemies and initiate combat.
* `attack` - Deal damage to the enemy.
* `run` - Attempt to escape combat (50% chance of failure).
* `status` - Check your current Health/Integrity.

**System**
* `save` - Save your current progress (position, health, inventory) to `savegame.json`.
* `load` - Restore your last saved game state.
* `exit` - Quit the game.

---

## 🛠️ Installation & Setup (For Beginners)

### Prerequisites
You need **IntelliJ IDEA** (Community Edition is free) and the **Java Development Kit (JDK)** installed on your computer.

### Step 1: Create the Project
1. Open IntelliJ IDEA.
2. Click **New Project**.
3. Select **Kotlin** (via Maven or Gradle).
4. Name the project `VoidShell`.

### Step 2: Add Dependencies
This game uses `kotlinx.serialization` to save your game files. You must add this to your build file (`build.gradle.kts`):

```kotlin
plugins {
    kotlin("jvm") version "1.9.0" // Or your current version
    kotlin("plugin.serialization") version "1.9.0"
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation(kotlin("stdlib"))
}
