
namespace Example
{
    static public class ExampleConstants
    {
        /** The AWS API key provided by StockX to access StockX APIs. */
        public const string AWS_API_KEY = "<Your AWS API Key>";

        /** The StockX base url to call */
        public const string STOCKX_ENDPOINT = "https://gateway.stockx.com/stage";

         /** The StockX account password to authenticate with. */
        public const string STOCKX_USERNAME = "<StockX account username>";

        /** The StockX account password to authenticate with. */
        public const string STOCKX_PASSWORD = "<StockX account password>";

        /** The product ID to lookup */
        public const string DEMO_PRODUCT_ID = "air-jordan-1-retro-high-off-white-chicago";

        /** The custoner ID to lookup orders for. */
        public const string DEMO_CUSTOMER_ID = "1471698";

        /** JWT bearer token header name. */
        public const string JWT_HEADER = "Jwt-Authorization";

    }

}