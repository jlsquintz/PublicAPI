package io.stockx.sdk.examples.endpoints;

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

public class PortfolioAskExample {

    public static void main(String[] args) {

        ApiClient apiClient = StockXClient.create(ExampleConstants.AWS_API_KEY, Environment.STAGING, true);

        StockXApi stockx = new StockXApi(apiClient);

        try {
            // Login to the StockX framework - see LoginExample for how this works
            login(stockx, ExampleConstants.STOCKX_USERNAME, ExampleConstants.STOCKX_PASSWORD);

            PortfolioRequestPortfolioItem item = new PortfolioRequestPortfolioItem()
                            .amount("25")
                            .skuUuid("bae25b67-a721-4f57-ad5a-79973c7d0a5c")
                            .matchedWithDate("2018-12-12T05:00:00+0000")
                            .expiresAt("2018-12-12T12:39:07+00:00");

            CustomerObject customer = new CustomerObject();
                customer.setDefaultSize("7");

            PortfolioRequest request = new PortfolioRequest()
                            .portfolioItem(item)
                            .customer(customer)
                            .timezone("America/Detroit");

            PortfolioResponse askResp = stockx.newPortfolioAsk(request);

            System.out.println("Ask Created: " + askResp);
        } catch (ApiException e) {
            System.out.println(e.getMessage());
            // e.printStackTrace();
        }
    }

}
