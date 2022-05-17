class Index extends HTMLElement {
  connectedCallback() {
    this.innerHTML = `
      <div class="container">
        <!-- carousel start-->
        <div
        id="carouselExampleIndicators"
        class="carousel slide"
        data-ride="carousel"
        >
        <ol class="carousel-indicators">
            <li
            data-target="#carouselExampleIndicators"
            data-slide-to="0"
            class="active"
            ></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
            <img
                class="d-block w-100"
                src="https://dummyimage.com/800x400/6495ED/fff.png"
                alt="First slide"
            />
            </div>
            <div class="carousel-item">
            <img
                class="d-block w-100"
                src="https://dummyimage.com/800x400/6495ED/fff.png"
                alt="Second slide"
            />
            </div>
            <div class="carousel-item">
            <img
                class="d-block w-100"
                src="https://dummyimage.com/800x400/6495ED/fff.png"
                alt="Third slide"
            />
            </div>
        </div>
        <a
            class="carousel-control-prev"
            href="#carouselExampleIndicators"
            role="button"
            data-slide="prev"
        >
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a
            class="carousel-control-next"
            href="#carouselExampleIndicators"
            role="button"
            data-slide="next"
        >
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
        </div>

        <!-- slogan start-->
        <div
        class="slogan-jumbotron jumbotron p-1 text-center bg-transparent mt-2 mb-0"
        >
        <div class="container">
            <h1 class="display-5">Welcome to <span class="company-name ">XYZ company</span></h1>
            <p class="lead">
            "<span class="company-slogan ">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
                eiusmod tempor incididunt ut labore et dolore magna aliqua.
            </span>"
            </p>
        </div>
        </div>

        <!-- promoted products & search start-->
        <div class="product-preview mt-2">
        <!-- product search-->
        <form class="form-inline my-lg-0 justify-content-center">
            <input
            class="form-control mr-sm-2 w-25"
            type="search"
            placeholder="Search catalog"
            aria-label="Search"
            />
            <button class="btn btn-warning my-sm-0" type="submit">
            <i class="fa-solid fa-magnifying-glass"></i> Search
            </button>
        </form>

        <!-- promoted products-->
        <h3 class="mb-3 border-bottom">
            <i class="fa-solid fa-fire"></i> Trending Now!
        </h3>
        <div class="card-deck mt-4">
            <div class="card">
            <img
                class="card-img-top"
                src="https://dummyimage.com/512x512/6495ED/fff.png"
                alt="Card image cap"
            />
            <div class="card-body text-center">
                <p class="card-text text-truncate ">
                Some text inside the xyz card. Ut enim ad minim veniam, quis
                nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                commodo consequat...
                </p>
                <a href="#" class="card-link">View item</a>
            </div>
            </div>
            <div class="card">
            <img
                class="card-img-top"
                src="https://dummyimage.com/512x512/6495ED/fff.png"
                alt="Card image cap"
            />
            <div class="card-body text-center">
                <p class="card-text text-truncate ">
                Some text inside the xyz card. Ut enim ad minim veniam, quis
                nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                commodo consequat...
                </p>
                <a href="#" class="card-link">View item</a>
            </div>
            </div>
            <div class="card">
            <img
                class="card-img-top"
                src="https://dummyimage.com/512x512/6495ED/fff.png"
                alt="Card image cap"
            />
            <div class="card-body text-center">
                <p class="card-text text-truncate ">
                Some text inside the xyz card. Ut enim ad minim veniam, quis
                nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                commodo consequat...
                </p>
                <a href="#" class="card-link">View item</a>
            </div>
            </div>
        </div>

        <div class="d-flex justify-content-end mt-4">
            <a href="products_search.html" class="more-products-link"
            >View more products</a
            >
        </div>
        </div>

        <!-- news & updates start-->
        <div class="news-and-updates mt-4">
        <h3 class="mb-3 border-bottom">
            <i class="fa-solid fa-newspaper"></i> News & Updates
        </h3>
        <ul class="list-unstyled">
            <li class="media">
            <img
                class="mr-3"
                src="https://dummyimage.com/128x128/6495ED/fff.png"
                alt="Generic placeholder image"
            />
            <div class="media-body">
                <h5 class="mt-0 mb-1 ">List-based media object</h5>
                <p class="">
                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
                scelerisque ante sollicitudin. Cras purus odio, vestibulum in
                vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
                nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                </p>
            </div>
            </li>
            <li class="media my-4">
            <img
                class="mr-3"
                src="https://dummyimage.com/128x128/6495ED/fff.png"
                alt="Generic placeholder image"
            />
            <div class="media-body">
                <h5 class="mt-0 mb-1 ">List-based media object</h5>
                <p class="">
                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
                scelerisque ante sollicitudin. Cras purus odio, vestibulum in
                vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
                nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                </p>
            </div>
            </li>
            <li class="media">
            <img
                class="mr-3"
                src="https://dummyimage.com/128x128/6495ED/fff.png"
                alt="Generic placeholder image"
            />
            <div class="media-body">
                <h5 class="mt-0 mb-1 ">List-based media object</h5>
                <p class="">
                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
                scelerisque ante sollicitudin. Cras purus odio, vestibulum in
                vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
                nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                </p>
            </div>
            </li>
        </ul>

        <div class="d-flex justify-content-end">
            <a href="/news_and_updates.html" class="more-products-link"
            >Read more news & updates</a
            >
        </div>
        </div>
        </div>
      `;
  }
}

// process page
customElements.define("main-content", Index);

async function request(url, httpmethod) {
  const response = await fetch(url, {
    method: httpmethod,
  });
  const json = await response.json();

  return json;
}

// map & populate fetched data
request(`http://localhost:8765/companyapi/company_info`, "GET")
  .then((resource) => {
    // map data
    const companyName = document.querySelector(".company-name");
    const companySlogan = document.querySelector(".company-slogan");

    // populate data
    companyName.textContent = resource.name;
    companySlogan.textContent = resource.slogan;
  })
  .catch((err) => console.log(err));
