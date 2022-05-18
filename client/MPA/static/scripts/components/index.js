/*** BASE GATEWAY PROXY URI ***/
const GATEWAY_PROXY_URI = "http://localhost:8765";

async function request(url, settings) {
  const response = await fetch(url, settings);
  const json = await response.json();

  return json;
}

/*** EVENTS ***/
// To-do: fix post request
const subscribeBtn = document.querySelector(".subscribe-btn");
staticEmail2;

subscribeBtn.addEventListener("click", (e) => {
  e.preventDefault();

  const guestEmailAddress = document.querySelector("#staticEmail2");

  var newGuestEmail = {
    dateCreated: new Date(),
    emailAddress: guestEmailAddress.value,
  };

  // POST
  request(`${GATEWAY_PROXY_URI}/guestemailapi/subscribe`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(newGuestEmail),
  })
    .then((resource) => {
      console.log(resource);
    })
    .catch((err) => console.log(err));
});

/*** HTTP REQUESTS ***/

// COMPANY SERVICE
// map & populate fetched data
request(`${GATEWAY_PROXY_URI}/companyapi/company_info`, {
  method: "GET",
})
  .then((resource) => {
    // map data
    const companyName = document.querySelector(".company-name");
    const companySlogan = document.querySelector(".company-slogan");

    // populate data
    companyName.textContent = resource.name;
    companySlogan.textContent = resource.slogan;
  })
  .catch((err) => console.log(err));

// PRODUCT SERVICE (Trending Now)
// map & populate fetched data
request(`${GATEWAY_PROXY_URI}/productitemapi/productItems?page=0&size=3`, {
  method: "GET",
})
  .then((resource) => {
    // map data
    const productItemTitles = document.querySelectorAll(".product-item-title");
    const productItemDescriptions = document.querySelectorAll(
      ".product-item-description"
    );
    const productItemLinks = document.querySelectorAll(".product-item-link");

    // populate data
    productItemTitles.forEach(
      // get product title
      (title, i) =>
        (title.textContent = resource._embedded.productItems[i].title)
    );

    productItemDescriptions.forEach(
      // get product descriptions
      (description, i) =>
        (description.textContent =
          resource._embedded.productItems[i].description)
    );

    productItemLinks.forEach((link, i) => {
      // generate product links
      const productId = resource._embedded.productItems[i]._links.self.href;
      link.setAttribute(
        "href",
        // get the id # at the end of the hateaos link
        `product_item.html?id=${productId.charAt(productId.length - 1)}`
      );
    });
  })
  .catch((err) => console.log(err));

// NEWS & UPDATES SERVICE
// map & populate fetched data
request(`${GATEWAY_PROXY_URI}/newsandupdatesapi/newsAndUpdates`, {
  method: "GET",
})
  .then((resource) => {
    // map data
    const newsAndUpdatesTitles = document.querySelectorAll(
      ".news-and-updates-title"
    );
    const newsAndUpdatesContents = document.querySelectorAll(
      ".news-and-updates-content"
    );

    // populate data
    newsAndUpdatesTitles.forEach(
      // get news title
      (title, i) => {
        title.textContent = resource._embedded.newsAndUpdateses[i].title;
      }
    );

    newsAndUpdatesContents.forEach(
      // get news content
      (content, i) =>
        (content.textContent = resource._embedded.newsAndUpdateses[i].content)
    );
  })
  .catch((err) => console.log(err));

// GUEST EMAIL SERVICE
// map & populate fetched data
request(`${GATEWAY_PROXY_URI}/guestemailapi/total`, {
  method: "GET",
})
  .then((resource) => {
    // map data
    const totalSubscribedCustomer = document.querySelector(
      ".total-subscribed-customers"
    );

    // populate data
    totalSubscribedCustomer.textContent = resource.Total;
  })
  .catch((err) => console.log(err));
