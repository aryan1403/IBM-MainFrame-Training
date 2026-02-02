const fs = require('fs');

fs.readFile('names.txt', 'utf8', (err, data) => {
    if (err) {
        console.error('Error reading file:', err);
        return;
    }
    console.log('File content:\n', data);
});
fs.writeFile('names.txt', 'Aryan\nRahul\nSneha', (err) => {
    if (err) {
        console.error('Error writing file:', err);
        return;
    }
    console.log('File written successfully');
});