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
    api_response = stockx.login(login)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling StockXApi->login: %s\n" % e)
