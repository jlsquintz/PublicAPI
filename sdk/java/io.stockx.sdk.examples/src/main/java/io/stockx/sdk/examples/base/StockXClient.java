package io.stockx.sdk.examples.base;

import io.stockx.client.ApiClient;

public class StockXClient {

	public static ApiClient create(String apiKey, Environment env, boolean debugging) {
		ApiClient client = new ApiClient();
			client.setApiKey(apiKey);
			client.setBasePath(env.getUrl());
			client.setDebugging(debugging);
		return client;
	}
	
	public static ApiClient create(String apiKey, Environment env) {
		return create(apiKey, env, false);
	}

	public static ApiClient create(String apiKey) {
		return create(apiKey, Environment.PUBLIC, false);
	}
}
