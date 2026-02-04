const { test, expect } = require('@playwright/test');

test.describe('Login Workflow Tests', () => {

  test.beforeEach(async ({ page }) => {
    await page.goto('explore.html');
  });

  test('Login page loads correctly', async ({ page }) => {
    await expect(page.locator('#exampleFormControlInput1')).toBeVisible();
    await expect(page.locator('#exampleFormControlTextarea1')).toBeVisible();
    await expect(page.locator('button')).toHaveText('Submit');
  });

  test('Shows alert when email and message are empty', async ({ page }) => {
    page.once('dialog', dialog => {
      expect(dialog.message()).toContain('Please enter an email address');
      dialog.accept();
    });

    await page.click('button');
  });

  test('Shows alert when email and message are too short', async ({ page }) => {
    await page.fill('#exampleFormControlInput1', 'a@b');
    await page.fill('#exampleFormControlTextarea1', 'short');

    page.once('dialog', dialog => {
      expect(dialog.message()).toContain('Email address is too short');
      dialog.accept();
    });

    await page.click('button');
  });

  test('Successful login displays message on page', async ({ page }) => {
    const email = 'testuser@example.com';
    const message = 'This is a valid test message';

    await page.fill('#exampleFormControlInput1', email);
    await page.fill('#exampleFormControlTextarea1', message);

    await page.click('button');

    const paragraph = page.locator('p');
    await expect(paragraph).toBeVisible();
    await expect(paragraph).toHaveText(message);
  });

  test('Login API is called with correct payload', async ({ page }) => {
    let requestBody;

    page.on('request', request => {
      if (request.url().includes('/login')) {
        requestBody = request.postDataJSON();
      }
    });

    await page.fill('#exampleFormControlInput1', 'user@test.com');
    await page.fill('#exampleFormControlTextarea1', 'valid message content');
    await page.click('button');

    expect(requestBody.email).toBe('user@test.com');
    expect(requestBody.message).toBe('valid message content');
  });

  test('Previous message is removed before adding new one', async ({ page }) => {
    await page.fill('#exampleFormControlInput1', 'a@test.com');
    await page.fill('#exampleFormControlTextarea1', 'first message');
    await page.click('button');

    await page.fill('#exampleFormControlTextarea1', 'second message');
    await page.click('button');

    const paragraphs = page.locator('p');
    await expect(paragraphs).toHaveCount(1);
    await expect(paragraphs).toHaveText('second message');
  });

});
