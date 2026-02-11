const express = require('express');
const { getBooksData } = require('./utils/utils');
require('dotenv').config();
const app = express();
const port = process.env.PORT || 3000;

app.get('/', (req, res) => {
    res.send('Hello World!');
}); 

app.get('/books', async (req, res) => {
    console.log(req.query.totalBooks);
    const totalBooks = parseInt(req.query.totalBooks) || 10;
    const booksData = await getBooksData(totalBooks);
    res.json({ data: booksData });
})
app.listen(port, () => console.log(`App listening on port ${port}!`));