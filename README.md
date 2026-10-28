<div align="center">

<img src="https://dev.talken.in/assets/img/icons/flappy.png" width="96" alt="Flappy Bird logo">

# Flappy Bird

**Tap, flap, don’t touch the pipes.**

[Project page](https://dev.talken.in/projects/flappy-bird.html) · [Download](https://github.com/Shashwat-Gupta57/Flappy-Bird/releases/latest) · [All my projects](https://dev.talken.in/#work)

</div>

---

<img src="https://dev.talken.in/assets/img/shots/flappy-1.webp" alt="Mid-flight between the pipes, high score in the corner" width="100%">
<p align="center"><sub>Mid-flight between the pipes, high score in the corner</sub></p>

<img src="https://dev.talken.in/assets/img/shots/flappy-2.webp" alt="Press space to jump" width="100%">
<p align="center"><sub>Press space to jump</sub></p>

## About

My take on the one-button classic, built from scratch in Swing — my own gravity and flap physics, a pipe generator, a scrolling city skyline and a high score that survives restarts.

## What it does

- **One button** — Space to flap.
- **Real physics** — Gravity and flap impulse, written by hand.
- **High score** — Your best run, remembered.

## Download & run

1. These apps need **Java 21 or newer**. If you don't have it, install it once with the [JRE Installer](https://github.com/Shashwat-Gupta57/JRE-Installer/releases/latest) — one click, no admin rights. Every app looks for Java in the place it installs to first, then in `JAVA_HOME`.
2. Download **`Flappy-Bird-1.0.0-windows.zip`** from the [latest release](https://github.com/Shashwat-Gupta57/Flappy-Bird/releases/latest).
3. Unzip it anywhere you can write to (Desktop, Documents…) and run **`Flappy Bird.exe`**.

The folders next to the exe (images, fonts, saves) are part of the app — keep them together.

## Run from source

Open the folder in **BlueJ** (it's a BlueJ project — `package.bluej`) and run `main.main()`, or with any JDK 21+:

```bash
javac *.java
java main
```

## Under the hood

| | |
|---|---|
| Engine | Swing game loop |
| Objects | Bird, pipes and inverted pipes as classes |

## License

[GPL-3.0](LICENSE) © Shashwat Gupta · Flex Studios

Made by [Shashwat Gupta](https://dev.talken.in/) — see more at **[dev.talken.in](https://dev.talken.in/)**.
