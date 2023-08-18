function getBicepExercises(){
    const data = null;

    const xhr2 = new XMLHttpRequest();
    xhr2.withCredentials = true;

    xhr2.addEventListener('readystatechange', function () {
	    if (this.readyState === this.DONE) {
		    console.log(this.responseText);
	    }
    });

    xhr2.open('GET', 'https://exercises-by-api-ninjas.p.rapidapi.com/v1/exercises?muscle=biceps');
    xhr2.setRequestHeader('X-RapidAPI-Key', 'b61a5a7435msh866977d946919afp1c7620jsn64158120fd4f');
    xhr2.setRequestHeader('X-RapidAPI-Host', 'exercises-by-api-ninjas.p.rapidapi.com');

    xhr2.send(data);
}