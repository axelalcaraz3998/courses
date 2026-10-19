"use strict";

// HTML elements
const newGameButtonElement = document.querySelector(".btn--new");
const rollDiceButtonElement = document.querySelector(".btn--roll");
const holdButtonElement = document.querySelector(".btn--hold");

const diceImgElement = document.querySelector(".dice");

const player1SectionElement = document.querySelector(".player--0");
const player1ScoreElement = document.getElementById("score--0");
const player1CurrentScoreElement = document.getElementById("current--0");

const player2SectionElement = document.querySelector(".player--1");
const player2ScoreElement = document.getElementById("score--1");
const player2CurrentScoreElement = document.getElementById("current--1");

// Helper variables
let playing = true;
let activePlayer = 1;
let currentScorePlayer1 = 0;
let currentScorePlayer2 = 0;

// Helper functions
function generateRandomDiceNumber() {
  return Math.floor(Math.random() * 6) + 1;
}

function displayNewCurrentScore(newCurrentScore) {
  if (activePlayer == 1) {
    player1CurrentScoreElement.textContent = String(newCurrentScore);
  } else {
    player2CurrentScoreElement.textContent = String(newCurrentScore);
  }
}

function switchPlayer() {
  if (activePlayer === 1) {
    player1SectionElement.classList.remove("player--active");
    player2SectionElement.classList.add("player--active");

    // Reset current score
    currentScorePlayer1 = 0;
  } else {
    player2SectionElement.classList.remove("player--active");
    player1SectionElement.classList.add("player--active");

    // Reset current score
    currentScorePlayer2 = 0;
  }

  // Update current score
  displayNewCurrentScore(0);

  // Update active player helper variable
  activePlayer === 1 ? (activePlayer = 2) : (activePlayer = 1);
}

// Listener functions
function handleNewGameClick() {
  // Reset helper variables
  playing = true;
  activePlayer = 1;
  currentScorePlayer1 = 0;
  currentScorePlayer2 = 0;

  // Reset UI
  player1SectionElement.classList.add("player--active");
  player1SectionElement.classList.remove("player--winner");
  player1ScoreElement.textContent = "0";
  player1CurrentScoreElement.textContent = "0";

  player2SectionElement.classList.remove("player--active");
  player2SectionElement.classList.remove("player--winner");
  player2ScoreElement.textContent = "0";
  player2CurrentScoreElement.textContent = "0";
}

function handleRollDiceClick() {
  if (!playing) {
    return;
  }

  // Generate random dice number
  const randomDiceNumber = generateRandomDiceNumber();

  // Display new dice image
  const newImgUrl = `./img/dice-${randomDiceNumber}.png`;
  diceImgElement.src = newImgUrl;

  if (randomDiceNumber === 1) {
    // Switch player if current player rolls a 1
    switchPlayer();
  } else {
    // Add dice roll to current score
    activePlayer === 1
      ? (currentScorePlayer1 += randomDiceNumber)
      : (currentScorePlayer2 += randomDiceNumber);

    // Display new current score
    activePlayer === 1
      ? displayNewCurrentScore(currentScorePlayer1)
      : displayNewCurrentScore(currentScorePlayer2);
  }
}

function handleHoldClick() {
  if (!playing) {
    return;
  }

  let playerScore = null;

  if (activePlayer === 1) {
    // Get player score and add new current score
    playerScore = Number(player1ScoreElement.textContent);
    playerScore += currentScorePlayer1;

    // Display new player score
    player1ScoreElement.textContent = String(playerScore);

    // Check if player has won
    if (playerScore >= 100) {
      player1SectionElement.classList.add("player--winner");
      playing = false;
    } else {
      // Switch player
      switchPlayer();
    }
  } else {
    // Get player score and add new current score
    playerScore = Number(player2ScoreElement.textContent);
    playerScore += currentScorePlayer2;

    // Display new player score
    player2ScoreElement.textContent = String(playerScore);

    // Check if player has won
    if (playerScore >= 100) {
      player2SectionElement.classList.add("player--winner");
      playing = false;
    } else {
      // Switch player
      switchPlayer();
    }
  }
}

// Event listeners
newGameButtonElement.addEventListener("click", handleNewGameClick);
rollDiceButtonElement.addEventListener("click", handleRollDiceClick);
holdButtonElement.addEventListener("click", handleHoldClick);
