package io.stockx.sdk.examples.base;

import java.util.List;

import io.stockx.client.ApiException;
import io.stockx.client.ApiResponse;
import io.stockx.client.api.StockXApi;
import io.stockx.client.model.CustomerObject;
import io.stockx.client.model.LoginRequest;
import io.stockx.client.model.LoginResponse;

public class LoginUtil {

	public static CustomerObject login(StockXApi api, String username, String password) throws ApiException {
		LoginRequest loginReq = new LoginRequest()
				.email(username)
				.password(password);

		try {
			ApiResponse<LoginResponse> loginWithHttpInfo = api.loginWithHttpInfo(loginReq);
			List<String> list = loginWithHttpInfo.getHeaders().get(ExampleConstants.JWT_HEADER);
			
			String authToken = list.get(0);
			api.getApiClient().addDefaultHeader("jwt-authorization", authToken);
			
			return loginWithHttpInfo.getData().getCustomer();
		} catch (ApiException e) {
			throw e;
		}
	}
	
}
