var StockX = require('stock_x_api');

var exampleConstants = new ExampleConstants();

var defaultClient = StockX.ApiClient.instance;
	defaultClient.basePath = 'https://gateway.stockx.com/stage';

var apiKey = defaultClient.authentications['api_key'];
	apiKey.apiKey = exampleConstants.AWS_API_KEY;

var stockx = new StockX.StockXApi();

var login = new StockX.LoginRequest();
	login.email = exampleConstants.STOCKX_USERNAME;
	login.password = exampleConstants.STOCKX_PASSWORD;

stockx.loginWithHttpInfo(login)
	.then(res => {
		defaultClient.defaultHeaders['jwt-authorization'] = res.response.headers['jwt-authorization'];
		return res.data.Customer;
	}).then(customer => {
		// Lookup the supplied product by its product ID
		return stockx.getProductMarketData('7f9c67ff-2cd4-4e27-8b64-518900a1bc0b', 'air-jordan-1-retro-high-off-white-chicago');	
	}).then(search => {
		console.log('Product market data lookup successful: ' + JSON.stringify(search));
	}).catch(err => {
		console.log('Error performing product market data lookup: ' + err);
	});