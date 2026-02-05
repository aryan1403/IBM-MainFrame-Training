import { test, expect } from '@playwright/test';
import { LoginPage } from './explore';

test.describe('Login Form Tests', () => {
  
  test('should submit the form and display the message paragraph', async ({ page }) => {
    const loginPage = new LoginPage(page);
    await loginPage.goto();

    const testEmail = 'test@example.com';
    const testMessage = 'Hello, this is a test message!';
    
    page.on('dialog', dialog => dialog.dismiss());

    await loginPage.login(testEmail, testMessage);

    await expect(loginPage.successParagraph).toBeVisible();
    await expect(loginPage.successParagraph).toHaveText(testMessage);
  });

  test('should show validation logic (basic check)', async ({ page }) => {
    const loginPage = new LoginPage(page);

    await loginPage.goto();
    await loginPage.submitButton.click();

    page.once('dialog', async dialog => {
      expect(dialog.message()).not.toContain('Please enter an email address');
      // await dialog.dismiss();
    });
  });
});