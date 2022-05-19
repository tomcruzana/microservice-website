/** TEMPLATE HTTP REQUEST */

// base gateway
const GATEWAY_PROXY_URI = "https://jsonplaceholder.typicode.com";

async function request(url, settings) {
  const response = await fetch(url, settings);
  const json = await response.json();

  return json;
}

// perform ajax
request(`${GATEWAY_PROXY_URI}/todos/1`, {
  method: "GET",
})
  .then((resource) => console.log(resource))
  .catch((err) => console.log(err));
