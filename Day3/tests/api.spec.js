const { test, expect } = require('@playwright/test');

test('Backend login API returns success', async ({ request }) => {
  const response = await request.post('http://localhost:8080/login', {
    data: {
      email: 'api@test.com',
      password: 'secret123'
    }
  });

  expect(response.status()).toBe(200);

  const body = await response.json();
  expect(body.message).toBe('Login successful');
});
