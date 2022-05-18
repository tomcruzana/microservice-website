// BASE GATEWAY PROXY URI
const GATEWAY_PROXY_URI = "http://localhost:8765";

async function request(url, httpmethod) {
  const response = await fetch(url, {
    method: httpmethod,
  });
  const json = await response.json();

  return json;
}

// COMPANY SERVICE
// map & populate fetched data
request(`${GATEWAY_PROXY_URI}/companyapi/company_info`, "GET")
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
request(`${GATEWAY_PROXY_URI}/productitemapi/productItems?page=0&size=3`, "GET")
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
