package io.stockx.sdk.examples;

import static io.stockx.sdk.examples.base.LoginUtil.login;

import io.stockx.client.ApiClient;
import io.stockx.client.ApiException;
import io.stockx.client.api.StockXApi;
import io.stockx.client.model.CustomerObject;
import io.stockx.client.model.PortfolioRequest;
import io.stockx.client.model.PortfolioRequestPortfolioItem;
import io.stockx.client.model.PortfolioResponse;
import io.stockx.sdk.examples.base.Environment;
import io.stockx.sdk.examples.base.ExampleConstants;
import io.stockx.sdk.examples.base.StockXClient;

public class PortfolioBidExample {

	public static void main(String[] args) {

		ApiClient apiClient = StockXClient
				.create(ExampleConstants.AWS_API_KEY, Environment.STAGING, true);

		StockXApi api = new StockXApi(apiClient);
		
		try {
			// Login to the StockX framework - see LoginExample for how this works
			login(api, ExampleConstants.STOCKX_USERNAME, ExampleConstants.STOCKX_PASSWORD);
			
			PortfolioRequestPortfolioItem item = new PortfolioRequestPortfolioItem()
															.amount("25")
															.skuUuid("bae25b67-a721-4f57-ad5a-79973c7d0a5c")
															.matchedWithDate("2018-12-12T05:00:00+0000")
															.condition("2000")
															.action(1000);
			
			CustomerObject cust = new CustomerObject();
				cust.setDefaultSize("7");
			
			PortfolioRequest request = new PortfolioRequest()
											.portfolioItem(item)
											.customer(cust)
											.timezone("America/Detroit");
			
			PortfolioResponse bidResp = api.newPortfolioBid(request);
			System.out.println("Bid Created: " + bidResp);
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}

}