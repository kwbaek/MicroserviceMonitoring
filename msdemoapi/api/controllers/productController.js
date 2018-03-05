
'use strict';
//var config = require('./config');
var async = require('async');
const rest = require('rest');
var http = require('http');
const {restInterceptor} = require('zipkin-instrumentation-cujojs-rest');
const {Tracer} = require('zipkin');
const {recorder} = require('../../recorder');
const CLSContext = require('zipkin-context-cls');
const ctxImpl = new CLSContext('zipkin');
const tracer = new Tracer({ctxImpl, recorder});
const zipkinRest = rest.wrap(restInterceptor, {tracer, serviceName: 'prod-info'});

//Service Orchestration Using NODEJS Async module.
//Product Review - Spring Boot App
//Product Detail - Spring Boot App
//Product Inventory - Spring Boot App

const {logger} = require('../../logger');

exports.read_prod_info = function(req, res) {
  var productId = req.params.productId;
var productInfo = {};

async.parallel([
    function(callback) {
	console.log('prodreview spring app to be called');
      zipkinRest('http://35.196.150.249:8081' + '/prodreview/count/'+productId)
    .then(response => productInfo.productReview=response.entity)
    .catch(err => console.error('Error', err.stack));
      callback();
    },
    function(callback) {
console.log('proddetail spring app to be called');
      zipkinRest('http://35.196.237.120:8082' + '/proddetail/'+productId)
    .then(response => productInfo.productDetail=response.entity)
    .catch(err => console.error('Error', err.stack));
      callback();
    },
    function(callback) {
console.log('prodinventory spring app to be called');
      zipkinRest('http://104.196.142.41:8083' + '/prodinventory/'+productId)
    .then(response => productInfo.productInventory=response.entity)
    .catch(err => console.error('Error', err.stack));
      callback();
    }
  ],function(err,data) {
	console.log(err)
	console.log(productInfo)
logger.log('info', 'Prod Info Service Called!', 
    { 'serviceName':'prod-info', 'TraceId': req.header('X-B3-TraceId'), 'SpanId': req.header('X-B3-SpanId') });
	if(typeof err != 'undefined' && err)
  		res.send(401,productInfo)
	else
		res.send(200,productInfo)
});


  


};
