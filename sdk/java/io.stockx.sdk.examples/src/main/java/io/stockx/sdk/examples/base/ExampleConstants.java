package io.stockx.sdk.examples.base;

/**
 * <p>Contains common values used across examples.</p>
 */
public class ExampleConstants {

	/** The AWS API key provided by StockX to access StockX APIs. */
	public static final String AWS_API_KEY = "<API KEY>";

	/** The StockX account username to authenticate with. */
	public static final String STOCKX_USERNAME = "<StockX Username>";
	
	/** The StockX account password to authenticate with. */
	public static final String STOCKX_PASSWORD = "<StockX Password>";

	/** The product ID to lookup */
	public static final String DEMO_PRODUCT_ID = "air-jordan-1-retro-high-off-white-chicago";
	
	/** The custoner ID to lookup orders for. */
	public static final String DEMO_CUSTOMER_ID = "<customer id>";
	
	/** Whether to output debug information to console. */
	public static final boolean ENABLE_DEBUG = true;

	/** JWT bearer token header name. */
	public static final String JWT_HEADER = "Jwt-Authorization";

}
