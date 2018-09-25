# io_stockx.StockXApi

All URIs are relative to *https://gateway.stockx.com/public*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_portfolio**](StockXApi.md#delete_portfolio) | **DELETE** /v1/portfolio/{id} | Deletes a portfolio item from the market with the specified id.
[**delete_webhook**](StockXApi.md#delete_webhook) | **DELETE** /webhook/v1/webhooks/{id} | 
[**get_open_orders**](StockXApi.md#get_open_orders) | **GET** /v1/customers/{id}/selling/current | 
[**get_portfolio**](StockXApi.md#get_portfolio) | **POST** /v1/portfolio | Returns a market portfolio identified by request parameters.
[**get_portfolio_item**](StockXApi.md#get_portfolio_item) | **GET** /v1/portfolioitems/{id} | 
[**get_product_by_id**](StockXApi.md#get_product_by_id) | **GET** /v1/products/{id} | 
[**get_product_market_data**](StockXApi.md#get_product_market_data) | **GET** /v1/products/{productId}/market | Provides historical market data for a given product.
[**get_subscriptions**](StockXApi.md#get_subscriptions) | **GET** /webhook/v1/subscriptions | 
[**get_webhook**](StockXApi.md#get_webhook) | **GET** /webhook/v1/webhooks/{id} | 
[**get_webhooks**](StockXApi.md#get_webhooks) | **GET** /webhook/v1/webhooks | 
[**login**](StockXApi.md#login) | **POST** /v1/login | Attempts to log the user in with a username and password.
[**lookup_product**](StockXApi.md#lookup_product) | **GET** /product/lookup | 
[**new_portfolio_ask**](StockXApi.md#new_portfolio_ask) | **POST** /v1/portfolio/ask | Creates a new seller ask on the market for a given product.
[**new_portfolio_bid**](StockXApi.md#new_portfolio_bid) | **POST** /v1/portfolio/bid | Creates a new buyer bid on the market for a given product.
[**post_webhooks**](StockXApi.md#post_webhooks) | **POST** /webhook/v1/webhooks | 
[**search**](StockXApi.md#search) | **GET** /v2/search | Searches for products by keyword.


# **delete_portfolio**
> PortfolioIdDelResponse delete_portfolio(id, portfolio)

Deletes a portfolio item from the market with the specified id.

### Example
```python
from __future__ import print_function
import time
import io_stockx
from io_stockx.rest import ApiException
from pprint import pprint

# Configure API key authorization: api_key
configuration = io_stockx.Configuration()
configuration.api_key['x-api-key'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['x-api-key'] = 'Bearer'

# create an instance of the API class
api_instance = io_stockx.StockXApi(io_stockx.ApiClient(configuration))
id = 'id_example' # str | The id of the portfolio item to delete.
portfolio = io_stockx.PortfolioIdDelRequest() # PortfolioIdDelRequest | The request information for the portfolio delete operation.

try:
    # Deletes a portfolio item from the market with the specified id.
    api_response = api_instance.delete_portfolio(id, portfolio)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling StockXApi->delete_portfolio: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The id of the portfolio item to delete. | 
 **portfolio** | [**PortfolioIdDelRequest**](PortfolioIdDelRequest.md)| The request information for the portfolio delete operation. | 

### Return type

[**PortfolioIdDelResponse**](PortfolioIdDelResponse.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_webhook**
> delete_webhook(id)



### Example
```python
from __future__ import print_function
import time
import io_stockx
from io_stockx.rest import ApiException
from pprint import pprint

# Configure API key authorization: api_key
configuration = io_stockx.Configuration()
configuration.api_key['x-api-key'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['x-api-key'] = 'Bearer'

# create an instance of the API class
api_instance = io_stockx.StockXApi(io_stockx.ApiClient(configuration))
id = 'id_example' # str | 

try:
    api_instance.delete_webhook(id)
except ApiException as e:
    print("Exception when calling StockXApi->delete_webhook: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**|  | 

### Return type

void (empty response body)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_open_orders**
> CustomersIdSellingCurrent get_open_orders(id)



### Example
```python
from __future__ import print_function
import time
import io_stockx
from io_stockx.rest import ApiException
from pprint import pprint

# Configure API key authorization: JWT
configuration = io_stockx.Configuration()
configuration.api_key['jwt-authorization'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['jwt-authorization'] = 'Bearer'
# Configure API key authorization: api_key
configuration = io_stockx.Configuration()
configuration.api_key['x-api-key'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['x-api-key'] = 'Bearer'

# create an instance of the API class
api_instance = io_stockx.StockXApi(io_stockx.ApiClient(configuration))
id = 'id_example' # str | The customer id to lookup open orders with.

try:
    api_response = api_instance.get_open_orders(id)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling StockXApi->get_open_orders: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The customer id to lookup open orders with. | 

### Return type

[**CustomersIdSellingCurrent**](CustomersIdSellingCurrent.md)

### Authorization

[JWT](../README.md#JWT), [api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_portfolio**
> PortfolioResponse get_portfolio(portfolio)

Returns a market portfolio identified by request parameters.

### Example
```python
from __future__ import print_function
import time
import io_stockx
from io_stockx.rest import ApiException
from pprint import pprint

# Configure API key authorization: api_key
configuration = io_stockx.Configuration()
configuration.api_key['x-api-key'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['x-api-key'] = 'Bearer'

# create an instance of the API class
api_instance = io_stockx.StockXApi(io_stockx.ApiClient(configuration))
portfolio = io_stockx.PortfolioRequest() # PortfolioRequest | Requests parameters for looking up a market portfolio.

try:
    # Returns a market portfolio identified by request parameters.
    api_response = api_instance.get_portfolio(portfolio)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling StockXApi->get_portfolio: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **portfolio** | [**PortfolioRequest**](PortfolioRequest.md)| Requests parameters for looking up a market portfolio. | 

### Return type

[**PortfolioResponse**](PortfolioResponse.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_portfolio_item**
> PortfolioitemsIdGetResponse get_portfolio_item(id)



### Example
```python
from __future__ import print_function
import time
import io_stockx
from io_stockx.rest import ApiException
from pprint import pprint

# Configure API key authorization: JWT
configuration = io_stockx.Configuration()
configuration.api_key['jwt-authorization'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['jwt-authorization'] = 'Bearer'
# Configure API key authorization: api_key
configuration = io_stockx.Configuration()
configuration.api_key['x-api-key'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['x-api-key'] = 'Bearer'

# create an instance of the API class
api_instance = io_stockx.StockXApi(io_stockx.ApiClient(configuration))
id = 'id_example' # str | The id of the portfolio item to lookup.

try:
    api_response = api_instance.get_portfolio_item(id)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling StockXApi->get_portfolio_item: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The id of the portfolio item to lookup. | 

### Return type

[**PortfolioitemsIdGetResponse**](PortfolioitemsIdGetResponse.md)

### Authorization

[JWT](../README.md#JWT), [api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_product_by_id**
> ProductResponse get_product_by_id(id, include=include)



### Example
```python
from __future__ import print_function
import time
import io_stockx
from io_stockx.rest import ApiException
from pprint import pprint

# Configure API key authorization: JWT
configuration = io_stockx.Configuration()
configuration.api_key['jwt-authorization'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['jwt-authorization'] = 'Bearer'
# Configure API key authorization: api_key
configuration = io_stockx.Configuration()
configuration.api_key['x-api-key'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['x-api-key'] = 'Bearer'

# create an instance of the API class
api_instance = io_stockx.StockXApi(io_stockx.ApiClient(configuration))
id = 'id_example' # str | The id of the product to return.
include = 'include_example' # str |  (optional)

try:
    api_response = api_instance.get_product_by_id(id, include=include)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling StockXApi->get_product_by_id: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**| The id of the product to return. | 
 **include** | **str**|  | [optional] 

### Return type

[**ProductResponse**](ProductResponse.md)

### Authorization

[JWT](../README.md#JWT), [api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_product_market_data**
> MarketData get_product_market_data(product_id, sku=sku)

Provides historical market data for a given product.

### Example
```python
from __future__ import print_function
import time
import io_stockx
from io_stockx.rest import ApiException
from pprint import pprint

# Configure API key authorization: JWT
configuration = io_stockx.Configuration()
configuration.api_key['jwt-authorization'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['jwt-authorization'] = 'Bearer'
# Configure API key authorization: api_key
configuration = io_stockx.Configuration()
configuration.api_key['x-api-key'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['x-api-key'] = 'Bearer'

# create an instance of the API class
api_instance = io_stockx.StockXApi(io_stockx.ApiClient(configuration))
product_id = 'product_id_example' # str | The product's product UUID
sku = 'sku_example' # str | The product's SKU (optional)

try:
    # Provides historical market data for a given product.
    api_response = api_instance.get_product_market_data(product_id, sku=sku)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling StockXApi->get_product_market_data: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **product_id** | **str**| The product&#39;s product UUID | 
 **sku** | **str**| The product&#39;s SKU | [optional] 

### Return type

[**MarketData**](MarketData.md)

### Authorization

[JWT](../README.md#JWT), [api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_subscriptions**
> SubscriptionsResponse get_subscriptions()



### Example
```python
from __future__ import print_function
import time
import io_stockx
from io_stockx.rest import ApiException
from pprint import pprint

# Configure API key authorization: api_key
configuration = io_stockx.Configuration()
configuration.api_key['x-api-key'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['x-api-key'] = 'Bearer'

# create an instance of the API class
api_instance = io_stockx.StockXApi(io_stockx.ApiClient(configuration))

try:
    api_response = api_instance.get_subscriptions()
    pprint(api_response)
except ApiException as e:
    print("Exception when calling StockXApi->get_subscriptions: %s\n" % e)
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**SubscriptionsResponse**](SubscriptionsResponse.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_webhook**
> WebhooksIdGetResponse get_webhook(id)



### Example
```python
from __future__ import print_function
import time
import io_stockx
from io_stockx.rest import ApiException
from pprint import pprint

# Configure API key authorization: api_key
configuration = io_stockx.Configuration()
configuration.api_key['x-api-key'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['x-api-key'] = 'Bearer'

# create an instance of the API class
api_instance = io_stockx.StockXApi(io_stockx.ApiClient(configuration))
id = 'id_example' # str | 

try:
    api_response = api_instance.get_webhook(id)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling StockXApi->get_webhook: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **str**|  | 

### Return type

[**WebhooksIdGetResponse**](WebhooksIdGetResponse.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_webhooks**
> WebhooksGetResponse get_webhooks()



### Example
```python
from __future__ import print_function
import time
import io_stockx
from io_stockx.rest import ApiException
from pprint import pprint

# Configure API key authorization: api_key
configuration = io_stockx.Configuration()
configuration.api_key['x-api-key'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['x-api-key'] = 'Bearer'

# create an instance of the API class
api_instance = io_stockx.StockXApi(io_stockx.ApiClient(configuration))

try:
    api_response = api_instance.get_webhooks()
    pprint(api_response)
except ApiException as e:
    print("Exception when calling StockXApi->get_webhooks: %s\n" % e)
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**WebhooksGetResponse**](WebhooksGetResponse.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **login**
> LoginResponse login(login)

Attempts to log the user in with a username and password.

### Example
```python
from __future__ import print_function
import time
import io_stockx
from io_stockx.rest import ApiException
from pprint import pprint

# Configure API key authorization: api_key
configuration = io_stockx.Configuration()
configuration.api_key['x-api-key'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['x-api-key'] = 'Bearer'

# create an instance of the API class
api_instance = io_stockx.StockXApi(io_stockx.ApiClient(configuration))
login = io_stockx.LoginRequest() # LoginRequest | Object that contains the user's authentication credentials.'

try:
    # Attempts to log the user in with a username and password.
    api_response = api_instance.login(login)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling StockXApi->login: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **login** | [**LoginRequest**](LoginRequest.md)| Object that contains the user&#39;s authentication credentials.&#39; | 

### Return type

[**LoginResponse**](LoginResponse.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **lookup_product**
> ProductInfo lookup_product(identifier=identifier, size=size)



### Example
```python
from __future__ import print_function
import time
import io_stockx
from io_stockx.rest import ApiException
from pprint import pprint

# Configure API key authorization: JWT
configuration = io_stockx.Configuration()
configuration.api_key['jwt-authorization'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['jwt-authorization'] = 'Bearer'
# Configure API key authorization: api_key
configuration = io_stockx.Configuration()
configuration.api_key['x-api-key'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['x-api-key'] = 'Bearer'

# create an instance of the API class
api_instance = io_stockx.StockXApi(io_stockx.ApiClient(configuration))
identifier = 'identifier_example' # str | The product identifier to lookup, e.g. (air-jordan-1-retro-high-off-white-chicago) (optional)
size = 'size_example' # str | The size of the product. (optional)

try:
    api_response = api_instance.lookup_product(identifier=identifier, size=size)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling StockXApi->lookup_product: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **str**| The product identifier to lookup, e.g. (air-jordan-1-retro-high-off-white-chicago) | [optional] 
 **size** | **str**| The size of the product. | [optional] 

### Return type

[**ProductInfo**](ProductInfo.md)

### Authorization

[JWT](../README.md#JWT), [api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **new_portfolio_ask**
> PortfolioResponse new_portfolio_ask(portfolio)

Creates a new seller ask on the market for a given product.

### Example
```python
from __future__ import print_function
import time
import io_stockx
from io_stockx.rest import ApiException
from pprint import pprint

# Configure API key authorization: api_key
configuration = io_stockx.Configuration()
configuration.api_key['x-api-key'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['x-api-key'] = 'Bearer'

# create an instance of the API class
api_instance = io_stockx.StockXApi(io_stockx.ApiClient(configuration))
portfolio = io_stockx.PortfolioRequest() # PortfolioRequest | The portfolio request representing the ask to place on the market.

try:
    # Creates a new seller ask on the market for a given product.
    api_response = api_instance.new_portfolio_ask(portfolio)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling StockXApi->new_portfolio_ask: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **portfolio** | [**PortfolioRequest**](PortfolioRequest.md)| The portfolio request representing the ask to place on the market. | 

### Return type

[**PortfolioResponse**](PortfolioResponse.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **new_portfolio_bid**
> PortfolioResponse new_portfolio_bid(portfolio)

Creates a new buyer bid on the market for a given product.

### Example
```python
from __future__ import print_function
import time
import io_stockx
from io_stockx.rest import ApiException
from pprint import pprint

# Configure API key authorization: api_key
configuration = io_stockx.Configuration()
configuration.api_key['x-api-key'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['x-api-key'] = 'Bearer'

# create an instance of the API class
api_instance = io_stockx.StockXApi(io_stockx.ApiClient(configuration))
portfolio = io_stockx.PortfolioRequest() # PortfolioRequest | The portfolio request representing the bid to place on the market.

try:
    # Creates a new buyer bid on the market for a given product.
    api_response = api_instance.new_portfolio_bid(portfolio)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling StockXApi->new_portfolio_bid: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **portfolio** | [**PortfolioRequest**](PortfolioRequest.md)| The portfolio request representing the bid to place on the market. | 

### Return type

[**PortfolioResponse**](PortfolioResponse.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **post_webhooks**
> WebhooksPostResponse post_webhooks(portfolio)



### Example
```python
from __future__ import print_function
import time
import io_stockx
from io_stockx.rest import ApiException
from pprint import pprint

# Configure API key authorization: api_key
configuration = io_stockx.Configuration()
configuration.api_key['x-api-key'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['x-api-key'] = 'Bearer'

# create an instance of the API class
api_instance = io_stockx.StockXApi(io_stockx.ApiClient(configuration))
portfolio = io_stockx.WebhooksPostRequest() # WebhooksPostRequest | 

try:
    api_response = api_instance.post_webhooks(portfolio)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling StockXApi->post_webhooks: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **portfolio** | [**WebhooksPostRequest**](WebhooksPostRequest.md)|  | 

### Return type

[**WebhooksPostResponse**](WebhooksPostResponse.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search**
> SearchResults search(query)

Searches for products by keyword.

### Example
```python
from __future__ import print_function
import time
import io_stockx
from io_stockx.rest import ApiException
from pprint import pprint

# Configure API key authorization: JWT
configuration = io_stockx.Configuration()
configuration.api_key['jwt-authorization'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['jwt-authorization'] = 'Bearer'
# Configure API key authorization: api_key
configuration = io_stockx.Configuration()
configuration.api_key['x-api-key'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['x-api-key'] = 'Bearer'

# create an instance of the API class
api_instance = io_stockx.StockXApi(io_stockx.ApiClient(configuration))
query = 'query_example' # str | The phrase or keyword to search with.

try:
    # Searches for products by keyword.
    api_response = api_instance.search(query)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling StockXApi->search: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **query** | **str**| The phrase or keyword to search with. | 

### Return type

[**SearchResults**](SearchResults.md)

### Authorization

[JWT](../README.md#JWT), [api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

