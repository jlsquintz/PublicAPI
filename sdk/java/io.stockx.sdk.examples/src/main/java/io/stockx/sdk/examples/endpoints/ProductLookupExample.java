package io.stockx.sdk.examples.endpoints;

import java.util.List;

import io.stockx.client.ApiClient;
import io.stockx.client.ApiException;
import io.stockx.client.ApiResponse;
import io.stockx.client.api.StockXApi;
import io.stockx.client.model.LoginRequest;
import io.stockx.client.model.LoginResponse;
import io.stockx.client.model.ProductInfo;
import io.stockx.sdk.examples.base.Environment;
import io.stockx.sdk.examples.base.ExampleConstants;
import io.stockx.sdk.examples.base.StockXClient;

/**
 * <p>
 * Demonstrates looking up a specific product on the market.
 * </p>
 */
public class ProductLookupExample {

    public static void main(String[] args) {

        ApiClient apiClient = StockXClient.create(ExampleConstants.AWS_API_KEY, Environment.STAGING);

        StockXApi stockx = new StockXApi(apiClient);

        LoginRequest loginReq = new LoginRequest()
                        .email(ExampleConstants.STOCKX_USERNAME)
                       .password(ExampleConstants.STOCKX_PASSWORD);

        try {
            ApiResponse<LoginResponse> loginWithHttpInfo = stockx.loginWithHttpInfo(loginReq);
            List<String> list = loginWithHttpInfo.getHeaders().get(ExampleConstants.JWT_HEADER);

            String authToken = list.get(0);
            apiClient.addDefaultHeader("jwt-authorization", authToken);

            ProductInfo productInfo = stockx.lookupProduct("nike", "7");
            System.out.println("Lookup result: " + productInfo);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

}
