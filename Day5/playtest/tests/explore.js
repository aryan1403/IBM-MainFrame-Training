class LoginPage {
  constructor(page) {
    this.page = page;

    this.emailInput = page.locator('#exampleFormControlInput1');
    this.messageTextArea = page.locator('#exampleFormControlTextarea1');
    this.submitButton = page.locator('button:has-text("Submit")');
    this.successParagraph = page.locator('p');
  }

  async goto() {
      await this.page.goto('explore.html'); 
  }

  async login(email, message) {
    await this.emailInput.fill(email);
    await this.messageTextArea.fill(message);
    await this.submitButton.click();
  }
}

module.exports = { LoginPage };