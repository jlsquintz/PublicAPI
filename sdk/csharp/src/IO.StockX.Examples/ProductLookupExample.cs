using System;
using System.Diagnostics;
using IO.StockX.Api;
using IO.StockX.Client;
using IO.StockX.Model;

namespace Example
{
    /**
    * <p>Demonstrates looking up a specific product on the market.</p>
    */
    public class GetProductInfoExample
    {
        static public void Main()
        {
            // Configure API key authorization: api_key
            Configuration.Default.AddApiKey("x-api-key", ExampleConstants.AWS_API_KEY);

            var stockx = new StockXApi();
                stockx.Configuration.BasePath = ExampleConstants.STOCKX_ENDPOINT;
            
            var login = new LoginRequest(ExampleConstants.STOCKX_USERNAME, ExampleConstants.STOCKX_PASSWORD);
            
            try
            {
                // Login and fetch the jwt header for authentication use in the request
                ApiResponse<LoginResponse> result = stockx.LoginWithHttpInfo(login);
                var jwt = result.Headers[ExampleConstants.JWT_HEADER];

                stockx.Configuration.DefaultHeader["jwt-authorization"] = jwt;

                var productInfo = stockx.LookupProduct("nike", "7");

                Console.WriteLine(productInfo);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
                Console.WriteLine("Exception when calling StockXApi.LookupProduct: " + e.Message );
            }
        }
    }
}