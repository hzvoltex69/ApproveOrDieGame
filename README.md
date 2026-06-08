# Approve or Die 🎓

A LibGDX game where you play as a university student trying to pass 
4 courses to graduate. Catch A+ grades to score points and avoid F 
grades or you'll lose lives!

## Gameplay
- Catch A+ grades to score +10 points
- Avoid F grades or lose a life
- Collect hearts to recover lives
- Pass 4 courses to graduate and win

## Courses
| Course | Required Score |
|--------|---------------|
| Introduccion a la Ingenieria | 100 pts |
| Fundamentos de Algoritmos | 200 pts |
| Fundamentos de Programacion | 300 pts |
| Programacion Avanzada | 400 pts |

## Controls
- ← Left arrow — move left
- → Right arrow — move right

## Built With
- Java
- LibGDX framework
- Eclipse IDE


## Project Structure
```
com.mygdx.game
├── ApproveOrDieGame.java
├── GameScreen.java
├── screens/
│   ├── MenuBase.java
│   ├── MainMenuScreen.java
│   ├── GameOverScreen.java
│   ├── PauseScreen.java
│   └── WinScreen.java
├── entities/
│   ├── Drawable.java
│   ├── Student.java
│   └── GradeRain.java
├── drops/
│   ├── Drop.java
│   ├── GoodDrop.java
│   ├── BadDrop.java
│   └── PowerUpDrop.java
├── courses/
│   ├── DropStrategy.java
│   ├── Course1.java
│   ├── Course2.java
│   ├── Course3.java
│   └── Course4.java
├── builder/
│   ├── Course.java
│   └── CourseBuilder.java
└── audio/
    └── AudioManager.java
```
## Requirements
- Java 8 or higher ! ! (not working on Java 7, I tried idk why)
- LibGDX 1.9.x
- Gradle 7.3.3
- Eclipse IDE (recommended)

## How to Use

### Clone the repository
```bash
git clone https://github.com/hzvoltex69/ApproveOrDieGame
```

### Run in Eclipse
1. Open Eclipse IDE
2. File → Import → Gradle → Existing Gradle Project
3. Select the cloned folder
4. Wait for Gradle to build
5. Right click `DesktopLauncher.java` in `desktop/src/com/mygdx/game/`
6. Run As → Java Application

## Authors
- Patricio Quispe Aquino
- Fernando Guerrero
- Lucas Burria

> PUCV — Programacion Avanzada 1S 2026
