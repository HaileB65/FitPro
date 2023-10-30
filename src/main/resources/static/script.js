window.addEventListener("load", () => {
  document.body.style.background = "cyan";
});

const header = document.getElementById("header").innerHTML = "FitPro";
const headerDiv = document.getElementById("headerDiv");
headerDiv.classList.add("text-center");

const paragraph = document.getElementById("paragraph").innerHTML = "Enter the muscle group you would like exercises for.";

function getExercises(){
  const person = {
    name: "John",
    age: 30,
    city: "New York"
};

document.getElementById("demo").innerHTML = person.name;


const centerText = () => {    
  var centerText = document.createElement('p');
  centerText.innerText = 'Center Text';
  centerText.style.color = 'black';
  centerText.style.textAlign = 'center';
  document.body.appendChild(centerText);
} 	 
centerText();
}