package io.stockx.sdk.examples.workflows;

import static io.stockx.sdk.examples.base.LoginUtil.login;

import io.stockx.client.ApiClient;
import io.stockx.client.ApiException;
import io.stockx.client.api.StockXApi;
import io.stockx.client.model.CustomerObject;
import io.stockx.client.model.MarketData;
import io.stockx.client.model.PortfolioRequest;
import io.stockx.client.model.PortfolioRequestPortfolioItem;
import io.stockx.client.model.PortfolioResponse;
import io.stockx.client.model.ProductInfo;
import io.stockx.client.model.ProductInfoData;
import io.stockx.sdk.examples.base.Environment;
import io.stockx.sdk.examples.base.ExampleConstants;
import io.stockx.sdk.examples.base.StockXClient;

/**
 * <p>Demonstrates creating a new lower asking price for a product as a seller.</p>
 */
public class PlaceNewLowestAskExample {

	public static void main(String[] args) {
		
		ApiClient apiClient = StockXClient
				.create(ExampleConstants.AWS_API_KEY, Environment.STAGING, true);

		StockXApi api = new StockXApi(apiClient);
		
		try {
			// Login to the StockX framework - see LoginExample for how this works
			CustomerObject customer = login(api, ExampleConstants.STOCKX_USERNAME, ExampleConstants.STOCKX_PASSWORD);
			
			// Search for a given product and lookup its styleid
			String styleId = api.search("Jordan Retro Black Cat")
										.getHits()
										.stream()
										.findFirst()
										.map(hit -> hit.getStyleId())
										.orElseThrow();

			// Look up the product info by style id and size
			ProductInfo productInfo = api.lookupProduct(styleId, "11");
			
			// Get the product id and uuid
			ProductInfoData data = productInfo
										.getData()
										.stream()
										.findAny()
										.get();
			
			String id = data.getId();
			String productUuid = data.getAttributes().getProductUuid();
			
			// Lookup the current market data for the product
			MarketData marketData = api.getProductMarketData(id, productUuid);
			
			// Get the current lowest ask and deincrement it
			int lowestAsk = marketData.getMarket().getLowestAsk();
			lowestAsk--;
			
			// Create a portfolio item request with a higher bid
			PortfolioRequestPortfolioItem item = new PortfolioRequestPortfolioItem()
															.amount(Integer.toString(lowestAsk))
															.skuUuid("bae25b67-a721-4f57-ad5a-79973c7d0a5c")
															.matchedWithDate("2018-12-12T05:00:00+0000")
															.expiresAt("2018-12-12T12:39:07+00:00");
			
			PortfolioRequest request = new PortfolioRequest()
											.portfolioItem(item)
											.customer(customer)
											.timezone("America/Detroit");
			
			// Submit the bid
			PortfolioResponse askResp = api.newPortfolioAsk(request);
			
			System.out.println("Ask Created: " + askResp);
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}

}
