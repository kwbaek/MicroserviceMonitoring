var apm = require('elastic-apm-node').start({
     appName: 'nodeapm',
     serverUrl: 'http://35.202.184.134:8200'
             })
var express = require('express');
var app = express();

app.get('/', function (req, res) {
	  res.send('Hello World V2!');
});

var server = app.listen(3000, function () {
	  var host = server.address().address;
	  var port = server.address().port;

	  console.log('Example app listening at http://%s:%s', host, port);
});
