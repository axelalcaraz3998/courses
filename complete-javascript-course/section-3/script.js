"use strict";

function logger(message) {
  const timestap = Date.now();
  console.log(`${timestap} - ${message}`);
}

logger("Testing");

function strConcatenator(str1, str2) {
  return str1 + " " + str2;
}

const concatenatedStr = strConcatenator("John", "Doe");
logger(concatenatedStr);

// Function expression
const calcAge = function (birthYear) {
  return new Date().getFullYear() - birthYear;
};
logger(calcAge(2002));

// Arrow functions
const calcAge2 = (birthYear) => new Date().getFullYear() - birthYear;
logger(calcAge2(2000));

const friends = ["Michael", "Steve", "Peter"];
console.log(friends);
console.log(friends[0]);
console.log(friends[2]);

friends[1] = "Alex";
console.log(friends);

friends.push("Jay");
friends.unshift("John");
console.log(friends);

friends.pop();
friends.shift();
console.log(friends);

console.log(friends.includes("Alex"));
console.log(friends.includes("Steve"));

const johnObj = {
  firstName: "John",
  lastName: "Doe",
  age: 26,
  friends: friends,

  calcAge: function (birthYear) {
    this.age = new Date().getFullYear() - birthYear;
    return this.age;
  },
};

console.log(johnObj);
console.log(johnObj.firstName);
console.log(johnObj["lastName"]);

logger(johnObj.calcAge(1998));
console.log(johnObj.age);

for (let i = 1; i <= 6; i++) {
  console.log(`Rep number ${i}`);
}

for (let i = 0; i < johnObj.friends.length; i++) {
  console.log(`${johnObj.friends[i]} is friends with ${johnObj.firstName}`);
}

let rep = 1;
while (rep <= 6) {
  console.log(`Rep number ${rep}`);
  rep++;
}
