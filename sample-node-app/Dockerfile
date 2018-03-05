FROM node:4.6
WORKDIR /app
ADD . /app
RUN npm install elastic-apm-node --save
RUN npm install
EXPOSE 3000
CMD npm start

