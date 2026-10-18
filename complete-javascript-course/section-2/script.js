let firstName = "John";
let lastName = "Doe";
console.log(firstName + " " + lastName);

let jsIsFun = true;
console.log(true);

console.log(typeof false);
console.log(typeof "string");
console.log(typeof 24);

let age = 30;
age = 21;

// const birthYear = 1991;
// birthYear = 1990;

const now = 2026;
const ageJohn = now - 1991;
console.log(ageJohn);

let x = 25;
let y = 2;
console.log(25 * 2 + 3);

const templateLiteral = `${firstName} is ${ageJohn}.`;
console.log(templateLiteral);

const isOldEnough = age >= 18;
if (isOldEnough) {
  console.log(`${firstName} is old enough.`);
} else {
  console.log(`${firstName} can't go in.`);
}

const number = 18;
if (number == "18") {
  console.log("Type coercion");
}

if (number === "18") {
  console.log("Something is wrong here");
} else {
  console.log("No type coercion");
}

const hasDriversLicense = true;
const hasGoodVision = true;

if (hasDriversLicense && hasGoodVision) {
  console.log("Can drive");
} else if (!hasDriversLicense || !hasGoodVision) {
  console.log("Can't drive");
}

const day = "monday";

switch (day) {
  case "monday":
    console.log("It is monday");
    break;
  case "tuesday":
    console.log("It is tuesday");
    break;
  default:
    console.log("It is neither monday nor tuesday");
}

const drink = age >= 18 ? "wine" : "water";
console.log(`${firstName} is drinking ${drink}`);
