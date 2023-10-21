const header = document.getElementById("header").innerHTML = "FitPro";

const headerDiv = document.getElementById("headerDiv");
headerDiv.classList.add("text-center");

function getExercises(){
  var x = document.getElementById("myExercise").value;
  document.getElementById("demo2").innerHTML = x;

  var exercises = fetch
}