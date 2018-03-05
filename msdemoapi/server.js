var express    = require('express');        // call express  
 
var bodyParser = require('body-parser');

const CLSContext = require('zipkin-context-cls');
const {Tracer} = require('zipkin');
const {recorder} = require('./recorder');

const ctxImpl = new CLSContext('zipkin');
const tracer = new Tracer({ctxImpl, recorder});

var app        = express();                 // define our app using express 

// instrument the server
const zipkinMiddleware = require('zipkin-instrumentation-express').expressMiddleware;
app.use(zipkinMiddleware({
  tracer,
  serviceName: 'prod-info' // name of this application
}));

// configure app to use bodyParser()
// this will let us get the data from a POST
app.use(bodyParser.urlencoded({ extended: true }));  
app.use(bodyParser.json());
app.use((req, res, next) => {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Allow-Headers', [
    'Origin', 'Accept', 'X-Requested-With', 'X-B3-TraceId',
    'X-B3-ParentSpanId', 'X-B3-SpanId', 'X-B3-Sampled'
  ].join(', '));
  next();
});
// set our port, defaulting if nothing is specified in the env
var port = process.env.PORT || 400;        

// load app configurations from config.js
var config = require('./config');
// get an instance of the express Router, allowing us to add
// middleware and register our API routes as needed
var router = express.Router(); 
var routes = require('./api/routes/productRoute');
routes(app);
app.listen(8084, () => {
  console.log('Backend listening on port 8084!');
});
