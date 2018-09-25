using System;
using System.Diagnostics;
using IO.StockX.Api;
using IO.StockX.Client;
using IO.StockX.Model;

namespace Example
{
    /**
    * <p>Demonstrates creating a new lower asking price for a product as a seller.</p>
    */
    public class PlaceNewLowestAskExample
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
                
                // Find a product with search
                var search = stockx.Search("Jordan Retro Black Cat");

                // Lookup the product's data by its search id
                var firstResultStyle = search.Hits[0].StyleId;

                var productInfo = stockx.LookupProduct(firstResultStyle, "11");

                // Get the market data (highest bids, lowest asks, etc) about the product
                var id = productInfo.Data[0].Id;
                var productUuid = productInfo.Data[0].Attributes.ProductUuid;

                var marketData = stockx.GetProductMarketData(id, productUuid);

                // Get the lowest ask and increment it
                var lowestAsk = marketData.Market.LowestAsk;
                lowestAsk++;

                // Create a portfolio item request with a higher bid
                var item = new PortfolioRequestPortfolioItem();
                    item.Amount = lowestAsk.ToString();
                    item.SkuUuid = "bae25b67-a721-4f57-ad5a-79973c7d0a5c";
                    item.MatchedWithDate = "2018-12-12T05:00:00+0000";
                    item.ExpiresAt = "2018-12-12T12:39:07+00:00";

                var request = new PortfolioRequest();
                    request.PortfolioItem = item;
                    request.Customer = result.Data.Customer;
                    request.Timezone = "America/Detroit";

                // Submit the ask
                var askResp = stockx.NewPortfolioAsk(request);

                Console.WriteLine(askResp);
            }
            catch (Exception e)
            {
            	Console.WriteLine(e.ToString());
                Console.WriteLine("Exception when creating new lowest ask: " + e.Message );
            }
        }
    }
}
