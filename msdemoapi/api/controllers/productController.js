
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
const zipkinRest = rest.wrap(restInterceptor, {tracer, serviceName: 'msdemoapi'});

//Service Orchestration Using NODEJS Async module.
//Product Review - Spring Boot App
//Product Detail - Spring Boot App
//Product Inventory - Spring Boot App


exports.read_prod_info = function(req, res) {
  var productId = req.params.productId;
var productInfo = {};

async.parallel([
    function(callback) {
	console.log('prodreview spring app to be called');
      zipkinRest('http://localhost:8080' + '/prodreview/count/'+productId)
    .then(response => productInfo.productReview=response.entity)
    .catch(err => console.error('Error', err.stack));
      callback();
    },
    function(callback) {
console.log('proddetail spring app to be called');
      zipkinRest('http://localhost:8081' + '/proddetail/'+productId)
    .then(response => productInfo.productDetail=response.entity)
    .catch(err => console.error('Error', err.stack));
      callback();
    },
    function(callback) {
console.log('prodinventory spring app to be called');
      zipkinRest('http://localhost:8082' + '/prodinventory/'+productId)
    .then(response => productInfo.productInventory=response.entity)
    .catch(err => console.error('Error', err.stack));
      callback();
    }
  ],function(err,data) {
	console.log(err)
	console.log(productInfo)
	if(typeof err != 'undefined' && err)
  		res.send(401,productInfo)
	else
		res.send(200,productInfo)
});


  


};
