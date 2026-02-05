import {test, expect} from "@playwright/test";

test("my web test", async ({ page }) => {
  await page.goto("http://127.0.0.1:3000/Day2/index.html");
  // expect(page).toHaveTitle(/My Web Page/);
  expect(await page.title()).toBe("My Website");

    console.log(await page.getByText("Test Website").textContent());

    expect(await page.getByText("Test Website")).toBeVisible();
    const exploreBtn = await page.getByText("Explore");
    await page.click("text=Explore");
    expect(page.url()).toBe("http://127.0.0.1:3000/Day2/explore.html");

    
});