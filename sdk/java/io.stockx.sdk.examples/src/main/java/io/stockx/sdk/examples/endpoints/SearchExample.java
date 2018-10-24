package io.stockx.sdk.examples.endpoints;

import static io.stockx.sdk.examples.base.LoginUtil.login;

import io.stockx.client.ApiClient;
import io.stockx.client.ApiException;
import io.stockx.client.api.StockXApi;
import io.stockx.client.model.SearchResults;
import io.stockx.sdk.examples.base.Environment;
import io.stockx.sdk.examples.base.ExampleConstants;
import io.stockx.sdk.examples.base.StockXClient;

/**
 * <p>
 * Demonstrates retrieving information StockX products from a general query.
 * </p>
 */
public class SearchExample {

    public static void main(String[] args) {

        ApiClient apiClient = StockXClient.create(ExampleConstants.AWS_API_KEY, Environment.STAGING, true);

        StockXApi stockx = new StockXApi(apiClient);

        try {
            // Login to the StockX framework - see LoginExample for how this works
            login(stockx, ExampleConstants.STOCKX_USERNAME, ExampleConstants.STOCKX_PASSWORD);

            // Lookup the supplied product by its product ID
            SearchResults res = stockx.search("yeezy");

            System.out.println("Search result: " + res);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

}
