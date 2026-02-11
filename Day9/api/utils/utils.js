const axios = require("axios");

const BooksAPIURL =
  "https://openlibrary.org/people/mekBot/books/want-to-read.json";

async function getBooksData(totalBooks) {
    console.log(totalBooks)
  const data = (await axios.get(BooksAPIURL)).data;

  const result = [];
  let count = 0;
  data.reading_log_entries.forEach((entry) => {
    if (count >= totalBooks) return result;
    result.push({
      bookTitle: entry.work.title,
      authors: entry.work.author_names,
      firstPublishYear: entry.work.first_publish_year,
    });
    count++;
  });

  return result;
}

module.exports = {
  getBooksData,
};
