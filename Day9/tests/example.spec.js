import { test, expect } from '@playwright/test';

test('API Testing - Get Books', async ({ request }) => {
  const totalBooks = 5;
  const response = await request.get(`/books?totalBooks=${totalBooks}`);
  
  expect(response.status()).toBe(200);
  
  const responseData = await response.json();
  expect(responseData).toHaveProperty('data');
  expect(Array.isArray(responseData.data)).toBe(true);
  expect(responseData.data.length).toBeLessThanOrEqual(totalBooks);
  
  responseData.data.forEach(book => {
    expect(book).toHaveProperty('bookTitle');
    expect(book).toHaveProperty('authors');
    expect(book).toHaveProperty('firstPublishYear');
  });
});