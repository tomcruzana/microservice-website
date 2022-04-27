let currentDateYear = document.querySelector(".current-date-year");

window.addEventListener("load", (e) => {
  const currentYear = new Date().getFullYear();
  currentDateYear.textContent = currentYear;
});
