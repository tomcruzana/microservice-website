class Spacer extends HTMLElement {
  connectedCallback() {
    this.innerHTML = `
        <div style="height: 40vh;" class="spacer"><div>
        `;
  }
}

customElements.define("spacer-div", Spacer);
