from __future__ import print_function

import time
import io_stockx
from example_constants import ExampleConstants
from io_stockx.rest import ApiException
from pprint import pprint

# Configure API key authorization: api_key
configuration = io_stockx.Configuration()

configuration.host = "https://gateway.stockx.com/stage"
configuration.api_key['x-api-key'] = ExampleConstants.AWS_API_KEY

# create an instance of the API class
stockx = io_stockx.StockXApi(io_stockx.ApiClient(configuration))
login = io_stockx.LoginRequest(email=ExampleConstants.STOCKX_USERNAME, password=ExampleConstants.STOCKX_PASSWORD)

try:
    # Attempts to log the user in with a username and password.
    api_response = stockx.login_with_http_info(login)

    # Get the customer object after login
    customer = api_response[0]

    # Get the login's assigned jwt token
    jwt_token = api_response[2]['Jwt-Authorization']

    # Use the jwt token to authenticate future requests
    stockx.api_client.set_default_header('jwt-authorization', jwt_token)

    # Search for a type of product
    search_result = stockx.search('Jordan Retro Black Cat')

    first_hit = search_result.hits[0]
    style_id = first_hit.style_id

    # Lookup the first product returned from the search
    product = stockx.lookup_product(identifier=style_id, size='11')

    # Get the current market data for the product (highest bid info, etc.)
    attributes = product.data[0].attributes
    id = product.data[0].id
    uuid = attributes.product_uuid

    # Get the product market data
    market_data = stockx.get_product_market_data(id, sku=uuid)

    # Get the lowest ask for the product and decrement it
    lowest_ask = market_data.market.lowest_ask
    lowest_ask += 1

    # Create a portfolio item request with a higher bid
    item = io_stockx.PortfolioRequestPortfolioItem()

    item.amount = lowest_ask
    item.sku_uuid = "bae25b67-a721-4f57-ad5a-79973c7d0a5c"
    item.matched_with_date = "2018-12-12T05:00:00+0000"
    item.expires_at = "2018-12-12T12:39:07+00:00"

    request = io_stockx.PortfolioRequest()
    request.portfolio_item = item
    request.customer = customer
    request.timezone = "America/Detroit"

    # Submit the ask
    ask_resp = stockx.new_portfolio_ask(request)

    pprint(ask_resp)
except ApiException as e:
    print("Exception when calling StockXApi->new_portfolio_ask: %s\n" % e)
