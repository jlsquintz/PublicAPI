package io.stockx.sdk.examples.endpoints;

import static io.stockx.sdk.examples.base.LoginUtil.login;

import io.stockx.client.ApiClient;
import io.stockx.client.ApiException;
import io.stockx.client.api.StockXApi;
import io.stockx.sdk.examples.base.Environment;
import io.stockx.sdk.examples.base.ExampleConstants;
import io.stockx.sdk.examples.base.StockXClient;

/**
 * <p>Demonstrates retrieving information about a StockX product.</p>
 */
public class GetProductMarketDataExample {

	public static void main(String[] args) {

		ApiClient apiClient = StockXClient
				.create(ExampleConstants.AWS_API_KEY, Environment.STAGING, true);

		StockXApi api = new StockXApi(apiClient);
		
		try {
			// Login to the StockX framework - see LoginExample for how this works
			login(api, ExampleConstants.STOCKX_USERNAME, ExampleConstants.STOCKX_PASSWORD);
			
			// Lookup the supplied product by its product ID
			api.getProductMarketData("7f9c67ff-2cd4-4e27-8b64-518900a1bc0b", "air-jordan-1-retro-high-off-white-chicago");	
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}

}
