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

var customer;

stockx.loginWithHttpInfo(login)
	.then(res => {
		defaultClient.defaultHeaders['jwt-authorization'] = res.response.headers['jwt-authorization'];
		customer = res.data.Customer;
		return customer;
	}).then(customer => {
		// Search for a type of product
		return stockx.search('Jordan Retro Black Cat');
	}).then(search => {
		// Lookup the first product returned from the search
		var firstHit = search.hits[0];
		
		var opts = {};
			opts['identifier'] = firstHit.style_id;
			opts['size'] = '11';
		
		return stockx.lookupProduct(opts);
	}).then(product => {
		// Get the current market data for the product (highest bid info, etc.)
		var data = product.data[0];
		var attributes = data.attributes;
		var id = data.id;
		var uuid = attributes.product_uuid;
		
		// Get the product market data
		return stockx.getProductMarketData(id, uuid);
	}).then(marketData => {
		// Get the highest bid for the product and increment it
		var highestBid = marketData.Market.highestBid;
		highestBid++;
		
		// Create a portfolio item request with a higher bid
		var item = new StockX.PortfolioRequestPortfolioItem()
			item.amount = highestBid;
			item.skuUuid = 'bae25b67-a721-4f57-ad5a-79973c7d0a5c';
			item.matchedWithDate = '2018-12-12T05:00:00+0000';
			item.expiresAt = '2018-12-12T12:39:07+00:00';
		
		var request = new StockX.PortfolioRequest()
			request.PortfolioItem = item;
			request.Customer = customer;
			request.timezone = 'America/Detroit';
		
		// Submit the bid
		return stockx.newPortfolioBid(request);
	}).then(bid =>  {
		console.log('Bid successfully placed: ' + JSON.stringify(bid));
	}).catch(err => {
		console.log('Error placing bid: ' + err);
	});