var cors = require('cors');
const express = require('express');
const bodyParser = require('body-parser');

const app = express();

app.use(cors());
app.use(express.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.get('/', (req, res) => {
    const name = req.query.name || 'Guest';
    res.send(`Hello, ${name}!`);
});

app.post('/login', (req, res) => {
    const email = req.body.email;
    const password = req.body.message;
    res.json({ message: 'Login successful', email, password });
});

app.listen(8080, () => console.log('Express server is running on http://localhost:8080'));