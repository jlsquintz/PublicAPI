using System;
using System.Diagnostics;
using IO.StockX.Api;
using IO.StockX.Client;
using IO.StockX.Model;

namespace Example
{
    /**
    * <p>Demonstrates getting a customer's current open orders.</p>
    */
    public class GetOpenOrders
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

                // Get the customer's open orders
                var openOrders = stockx.GetOpenOrders(result.Data.Customer.Id);
                
                Console.WriteLine("Open orders: " + openOrders);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
                Console.WriteLine("Exception when calling StockXApi.GetProductById: " + e.Message );
            }
        }
    }
}