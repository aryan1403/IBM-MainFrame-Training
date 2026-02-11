const express = require('express');
const { getBooksData } = require('./utils/utils');
require('dotenv').config();
const app = express();
const port = process.env.PORT;

app.get('/api/books', async (req, res) => {
    console.log(req.params.totalBooks);
    const totalBooks = parseInt(req.params.totalBooks) || 10;
    const booksData = await getBooksData(totalBooks);
    res.json({ data: booksData });
})
app.listen(port, () => console.log(`App listening on port ${port}!`));