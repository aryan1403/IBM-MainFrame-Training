# Fetching the minified node image on alpine linux
FROM node:slim

# Declaring env
ENV PORT=8080

# Setting up the work directory
WORKDIR /express-docker

# Copying all the files in our project
COPY . .

# Installing dependencies
RUN npm install

# Starting our application
CMD [ "node", "expr.js" ]

# Exposing server port
EXPOSE $PORT