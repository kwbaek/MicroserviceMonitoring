FROM node:latest

RUN mkdir -p /usr/src/app  
WORKDIR /usr/src/app  
COPY . /usr/src/app

EXPOSE 300  
RUN npm install  
CMD ["npm", "start"]
