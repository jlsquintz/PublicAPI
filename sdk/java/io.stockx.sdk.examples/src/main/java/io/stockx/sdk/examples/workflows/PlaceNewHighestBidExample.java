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
 * <p>
 * Demonstrates creating a new high bid for a product as a buyer.
 * </p>
 */
public class PlaceNewHighestBidExample {

    public static void main(String[] args) {
        ApiClient apiClient = StockXClient.create(ExampleConstants.AWS_API_KEY, Environment.STAGING, true);

        StockXApi stockx = new StockXApi(apiClient);

        try {
            // Login to the StockX framework - see LoginExample for how this works
            CustomerObject customer = login(stockx, ExampleConstants.STOCKX_USERNAME, ExampleConstants.STOCKX_PASSWORD);

            // Search for a given product and lookup its styleid
            String styleId = stockx.search("Jordan Retro Black Cat")
                            .getHits()
                            .stream()
                            .findFirst()
                            .map(hit -> hit.getStyleId())
                            .orElseThrow();

            // Look up the product info by style id and size
            ProductInfo productInfo = stockx.lookupProduct(styleId, "11");

            ProductInfoData data = productInfo
                            .getData()
                            .stream()
                            .findAny()
                            .get();

            String id = data.getId();
            String productUuid = data.getAttributes()
                                     .getProductUuid();

            // Lookup the current market data for the product
            MarketData marketData = stockx.getProductMarketData(id, productUuid);

            // Get the current highest bid and increment it
            int highestBid = marketData.getMarket()
                                       .getHighestBid();
            highestBid++;

            // Create a portfolio item request with a higher bid
            PortfolioRequestPortfolioItem item = new PortfolioRequestPortfolioItem()
                    .amount(Integer.toString(highestBid))
                    .skuUuid("bae25b67-a721-4f57-ad5a-79973c7d0a5c")
                    .matchedWithDate("2018-12-12T05:00:00+0000")
                    .expiresAt("2018-12-12T12:39:07+00:00");

            PortfolioRequest request = new PortfolioRequest()
                    .portfolioItem(item)
                    .customer(customer)
                    .timezone("America/Detroit");

            // Submit the bid
            PortfolioResponse bidResp = stockx.newPortfolioBid(request);

            System.out.println("Bid Created: " + bidResp);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

}
