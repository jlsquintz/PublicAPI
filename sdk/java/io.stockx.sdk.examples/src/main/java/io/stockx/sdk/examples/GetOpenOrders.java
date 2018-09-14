package io.stockx.sdk.examples;

import static io.stockx.sdk.examples.base.LoginUtil.login;

import io.stockx.client.ApiClient;
import io.stockx.client.ApiException;
import io.stockx.client.api.StockXApi;
import io.stockx.client.model.CustomersIdSellingCurrent;
import io.stockx.sdk.examples.base.Environment;
import io.stockx.sdk.examples.base.ExampleConstants;
import io.stockx.sdk.examples.base.StockXClient;

/**
 * <p>Demonstrates getting a customer's current open orders.</p>
 */
public class GetOpenOrders {

	public static void main(String[] args) {
		
		ApiClient apiClient = StockXClient
				.create(ExampleConstants.AWS_API_KEY, Environment.STAGING);

		StockXApi api = new StockXApi(apiClient);
		
		try {
			// Login to the StockX framework - see LoginExample for how this works
			login(api, ExampleConstants.STOCKX_USERNAME, ExampleConstants.STOCKX_PASSWORD);
			
			CustomersIdSellingCurrent openOrders = api.getOpenOrders(ExampleConstants.DEMO_CUSTOMER_ID);
			System.out.println("Open orders: " + openOrders);
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}

}
