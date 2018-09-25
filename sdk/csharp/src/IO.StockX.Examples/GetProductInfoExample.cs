using System;
using System.Diagnostics;
using IO.StockX.Api;
using IO.StockX.Client;
using IO.StockX.Model;

namespace Example
{
    /**
    * <p>Demonstrates retrieving information about a StockX product.</p>
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
                // Login
                stockx.Login(login);
                
                // Lookup the supplied product by its product ID
                var productById = stockx.GetProductById("air-jordan-1-retro-high-off-white-chicago");
            
                Console.WriteLine(productById);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
                Console.WriteLine("Exception when calling StockXApi.GetProductById: " + e.Message );
            }
        }
    }
}
