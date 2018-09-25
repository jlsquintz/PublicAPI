using System;
using System.Diagnostics;
using IO.StockX.Api;
using IO.StockX.Client;
using IO.StockX.Model;

namespace Example
{
    public class PortfolioAskExample
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

                var item = new PortfolioRequestPortfolioItem();
                    item.Amount = "25";
                    item.SkuUuid = "bae25b67-a721-4f57-ad5a-79973c7d0a5c";
                    item.MatchedWithDate = "2018-12-12T05:00:00+0000";
                    item.ExpiresAt = "2018-12-12T12:39:07+00:00";

                var request = new PortfolioRequest();
                    request.PortfolioItem = item;
                    request.Customer = result.Data.Customer;
                    request.Timezone = "America/Detroit";
                
                // Create a new portfolio ask
                var askResp = stockx.NewPortfolioAsk(request);

                // Print the result of the ask call
                Console.WriteLine(askResp);
            } 
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
                Console.WriteLine("Exception when calling StockXApi.NewPortfolioAsk: " + e.Message );
            }
        }
    }
}