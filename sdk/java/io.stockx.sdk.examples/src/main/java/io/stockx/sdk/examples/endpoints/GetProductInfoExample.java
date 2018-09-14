package io.stockx.sdk.examples.endpoints;

import static io.stockx.sdk.examples.base.LoginUtil.login;

import io.stockx.client.ApiClient;
import io.stockx.client.ApiException;
import io.stockx.client.api.StockXApi;
import io.stockx.client.model.ProductResponse;
import io.stockx.sdk.examples.base.Environment;
import io.stockx.sdk.examples.base.ExampleConstants;
import io.stockx.sdk.examples.base.StockXClient;

/**
 * <p>Demonstrates retrieving information about a StockX product.</p>
 */
public class GetProductInfoExample {

	public static void main(String[] args) {

		ApiClient apiClient = StockXClient
				.create(ExampleConstants.AWS_API_KEY, Environment.STAGING);

		StockXApi api = new StockXApi(apiClient);
		
		try {
			// Login to the StockX framework - see LoginExample for how this works
			login(api, ExampleConstants.STOCKX_USERNAME, ExampleConstants.STOCKX_PASSWORD);
			
			// Lookup the supplied product by its product ID
			ProductResponse productById = api.getProductById(ExampleConstants.DEMO_PRODUCT_ID, null);
			
			System.out.println("Product Info: " + productById.getProduct());
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}

}
