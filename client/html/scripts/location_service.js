// hide this via proxy server
const API_KEY = "8a167285c0a02d";
let cityAndZip = document.querySelector(".city-postal");

window.addEventListener("load", (e) => {
  fetch(`https://ipinfo.io/json?token=${API_KEY}`)
    .then((data) => data.json())
    .then((res) => {
      cityAndZip.innerHTML = `${res.city}, ${res.postal}`;
    })
    .catch((err) => {
      cityAndZip.innerHTML = `CITY, ZIP CODE`;
      console.log(
        "An error occurred while fetching the user's location details.\nPlease try again later."
      );
    });
});
