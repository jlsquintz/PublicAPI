# StockX\Client\StockXApi

All URIs are relative to *https://gateway.stockx.com/public*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deletePortfolio**](StockXApi.md#deletePortfolio) | **DELETE** /v1/portfolio/{id} | Deletes a portfolio item from the market with the specified id.
[**deleteWebhook**](StockXApi.md#deleteWebhook) | **DELETE** /webhook/v1/webhooks/{id} | 
[**getOpenOrders**](StockXApi.md#getOpenOrders) | **GET** /v1/customers/{id}/selling/current | 
[**getPortfolio**](StockXApi.md#getPortfolio) | **POST** /v1/portfolio | Returns a market portfolio identified by request parameters.
[**getPortfolioItem**](StockXApi.md#getPortfolioItem) | **GET** /v1/portfolioitems/{id} | 
[**getProductById**](StockXApi.md#getProductById) | **GET** /v1/products/{id} | 
[**getProductMarketData**](StockXApi.md#getProductMarketData) | **GET** /v1/products/{productId}/market | Provides historical market data for a given product.
[**getSubscriptions**](StockXApi.md#getSubscriptions) | **GET** /webhook/v1/subscriptions | 
[**getWebhook**](StockXApi.md#getWebhook) | **GET** /webhook/v1/webhooks/{id} | 
[**getWebhooks**](StockXApi.md#getWebhooks) | **GET** /webhook/v1/webhooks | 
[**login**](StockXApi.md#login) | **POST** /v1/login | Attempts to log the user in with a username and password.
[**lookupProduct**](StockXApi.md#lookupProduct) | **GET** /product/lookup | 
[**newPortfolioAsk**](StockXApi.md#newPortfolioAsk) | **POST** /v1/portfolio/ask | Creates a new seller ask on the market for a given product.
[**newPortfolioBid**](StockXApi.md#newPortfolioBid) | **POST** /v1/portfolio/bid | Creates a new buyer bid on the market for a given product.
[**postWebhooks**](StockXApi.md#postWebhooks) | **POST** /webhook/v1/webhooks | 
[**search**](StockXApi.md#search) | **GET** /v2/search | Searches for products by keyword.


# **deletePortfolio**
> \StockX\Client\Model\PortfolioIdDelResponse deletePortfolio($id, $portfolio)

Deletes a portfolio item from the market with the specified id.

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

// Configure API key authorization: api_key
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('x-api-key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('x-api-key', 'Bearer');

$apiInstance = new StockX\Client\Api\StockXApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$id = "id_example"; // string | The id of the portfolio item to delete.
$portfolio = new \StockX\Client\Model\PortfolioIdDelRequest(); // \StockX\Client\Model\PortfolioIdDelRequest | The request information for the portfolio delete operation.

try {
    $result = $apiInstance->deletePortfolio($id, $portfolio);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->deletePortfolio: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string**| The id of the portfolio item to delete. |
 **portfolio** | [**\StockX\Client\Model\PortfolioIdDelRequest**](../Model/PortfolioIdDelRequest.md)| The request information for the portfolio delete operation. |

### Return type

[**\StockX\Client\Model\PortfolioIdDelResponse**](../Model/PortfolioIdDelResponse.md)

### Authorization

[api_key](../../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **deleteWebhook**
> deleteWebhook($id)



### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

// Configure API key authorization: api_key
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('x-api-key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('x-api-key', 'Bearer');

$apiInstance = new StockX\Client\Api\StockXApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$id = "id_example"; // string | 

try {
    $apiInstance->deleteWebhook($id);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->deleteWebhook: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string**|  |

### Return type

void (empty response body)

### Authorization

[api_key](../../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **getOpenOrders**
> \StockX\Client\Model\CustomersIdSellingCurrent getOpenOrders($id)



### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

// Configure API key authorization: JWT
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('jwt-authorization', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('jwt-authorization', 'Bearer');
// Configure API key authorization: api_key
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('x-api-key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('x-api-key', 'Bearer');

$apiInstance = new StockX\Client\Api\StockXApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$id = "id_example"; // string | The customer id to lookup open orders with.

try {
    $result = $apiInstance->getOpenOrders($id);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->getOpenOrders: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string**| The customer id to lookup open orders with. |

### Return type

[**\StockX\Client\Model\CustomersIdSellingCurrent**](../Model/CustomersIdSellingCurrent.md)

### Authorization

[JWT](../../README.md#JWT), [api_key](../../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **getPortfolio**
> \StockX\Client\Model\PortfolioResponse getPortfolio($portfolio)

Returns a market portfolio identified by request parameters.

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

// Configure API key authorization: api_key
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('x-api-key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('x-api-key', 'Bearer');

$apiInstance = new StockX\Client\Api\StockXApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$portfolio = new \StockX\Client\Model\PortfolioRequest(); // \StockX\Client\Model\PortfolioRequest | Requests parameters for looking up a market portfolio.

try {
    $result = $apiInstance->getPortfolio($portfolio);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->getPortfolio: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **portfolio** | [**\StockX\Client\Model\PortfolioRequest**](../Model/PortfolioRequest.md)| Requests parameters for looking up a market portfolio. |

### Return type

[**\StockX\Client\Model\PortfolioResponse**](../Model/PortfolioResponse.md)

### Authorization

[api_key](../../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **getPortfolioItem**
> \StockX\Client\Model\PortfolioitemsIdGetResponse getPortfolioItem($id)



### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

// Configure API key authorization: JWT
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('jwt-authorization', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('jwt-authorization', 'Bearer');
// Configure API key authorization: api_key
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('x-api-key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('x-api-key', 'Bearer');

$apiInstance = new StockX\Client\Api\StockXApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$id = "id_example"; // string | The id of the portfolio item to lookup.

try {
    $result = $apiInstance->getPortfolioItem($id);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->getPortfolioItem: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string**| The id of the portfolio item to lookup. |

### Return type

[**\StockX\Client\Model\PortfolioitemsIdGetResponse**](../Model/PortfolioitemsIdGetResponse.md)

### Authorization

[JWT](../../README.md#JWT), [api_key](../../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **getProductById**
> \StockX\Client\Model\ProductResponse getProductById($id, $include)



### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

// Configure API key authorization: JWT
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('jwt-authorization', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('jwt-authorization', 'Bearer');
// Configure API key authorization: api_key
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('x-api-key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('x-api-key', 'Bearer');

$apiInstance = new StockX\Client\Api\StockXApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$id = "id_example"; // string | The id of the product to return.
$include = "include_example"; // string | 

try {
    $result = $apiInstance->getProductById($id, $include);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->getProductById: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string**| The id of the product to return. |
 **include** | **string**|  | [optional]

### Return type

[**\StockX\Client\Model\ProductResponse**](../Model/ProductResponse.md)

### Authorization

[JWT](../../README.md#JWT), [api_key](../../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **getProductMarketData**
> \StockX\Client\Model\MarketData getProductMarketData($product_id, $sku)

Provides historical market data for a given product.

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

// Configure API key authorization: JWT
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('jwt-authorization', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('jwt-authorization', 'Bearer');
// Configure API key authorization: api_key
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('x-api-key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('x-api-key', 'Bearer');

$apiInstance = new StockX\Client\Api\StockXApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$product_id = "product_id_example"; // string | The product's product UUID
$sku = "sku_example"; // string | The product's SKU

try {
    $result = $apiInstance->getProductMarketData($product_id, $sku);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->getProductMarketData: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **product_id** | **string**| The product&#39;s product UUID |
 **sku** | **string**| The product&#39;s SKU | [optional]

### Return type

[**\StockX\Client\Model\MarketData**](../Model/MarketData.md)

### Authorization

[JWT](../../README.md#JWT), [api_key](../../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **getSubscriptions**
> \StockX\Client\Model\SubscriptionsResponse getSubscriptions()



### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

// Configure API key authorization: api_key
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('x-api-key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('x-api-key', 'Bearer');

$apiInstance = new StockX\Client\Api\StockXApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);

try {
    $result = $apiInstance->getSubscriptions();
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->getSubscriptions: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**\StockX\Client\Model\SubscriptionsResponse**](../Model/SubscriptionsResponse.md)

### Authorization

[api_key](../../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **getWebhook**
> \StockX\Client\Model\WebhooksIdGetResponse getWebhook($id)



### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

// Configure API key authorization: api_key
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('x-api-key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('x-api-key', 'Bearer');

$apiInstance = new StockX\Client\Api\StockXApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$id = "id_example"; // string | 

try {
    $result = $apiInstance->getWebhook($id);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->getWebhook: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **string**|  |

### Return type

[**\StockX\Client\Model\WebhooksIdGetResponse**](../Model/WebhooksIdGetResponse.md)

### Authorization

[api_key](../../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **getWebhooks**
> \StockX\Client\Model\WebhooksGetResponse getWebhooks()



### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

// Configure API key authorization: api_key
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('x-api-key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('x-api-key', 'Bearer');

$apiInstance = new StockX\Client\Api\StockXApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);

try {
    $result = $apiInstance->getWebhooks();
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->getWebhooks: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**\StockX\Client\Model\WebhooksGetResponse**](../Model/WebhooksGetResponse.md)

### Authorization

[api_key](../../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **login**
> \StockX\Client\Model\LoginResponse login($login)

Attempts to log the user in with a username and password.

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

// Configure API key authorization: api_key
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('x-api-key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('x-api-key', 'Bearer');

$apiInstance = new StockX\Client\Api\StockXApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$login = new \StockX\Client\Model\LoginRequest(); // \StockX\Client\Model\LoginRequest | Object that contains the user's authentication credentials.'

try {
    $result = $apiInstance->login($login);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->login: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **login** | [**\StockX\Client\Model\LoginRequest**](../Model/LoginRequest.md)| Object that contains the user&#39;s authentication credentials.&#39; |

### Return type

[**\StockX\Client\Model\LoginResponse**](../Model/LoginResponse.md)

### Authorization

[api_key](../../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **lookupProduct**
> \StockX\Client\Model\ProductInfo lookupProduct($identifier, $size)



### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

// Configure API key authorization: JWT
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('jwt-authorization', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('jwt-authorization', 'Bearer');
// Configure API key authorization: api_key
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('x-api-key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('x-api-key', 'Bearer');

$apiInstance = new StockX\Client\Api\StockXApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$identifier = "identifier_example"; // string | The product identifier to lookup, e.g. (air-jordan-1-retro-high-off-white-chicago)
$size = "size_example"; // string | The size of the product.

try {
    $result = $apiInstance->lookupProduct($identifier, $size);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->lookupProduct: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **string**| The product identifier to lookup, e.g. (air-jordan-1-retro-high-off-white-chicago) | [optional]
 **size** | **string**| The size of the product. | [optional]

### Return type

[**\StockX\Client\Model\ProductInfo**](../Model/ProductInfo.md)

### Authorization

[JWT](../../README.md#JWT), [api_key](../../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **newPortfolioAsk**
> \StockX\Client\Model\PortfolioResponse newPortfolioAsk($portfolio)

Creates a new seller ask on the market for a given product.

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

// Configure API key authorization: api_key
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('x-api-key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('x-api-key', 'Bearer');

$apiInstance = new StockX\Client\Api\StockXApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$portfolio = new \StockX\Client\Model\PortfolioRequest(); // \StockX\Client\Model\PortfolioRequest | The portfolio request representing the ask to place on the market.

try {
    $result = $apiInstance->newPortfolioAsk($portfolio);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->newPortfolioAsk: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **portfolio** | [**\StockX\Client\Model\PortfolioRequest**](../Model/PortfolioRequest.md)| The portfolio request representing the ask to place on the market. |

### Return type

[**\StockX\Client\Model\PortfolioResponse**](../Model/PortfolioResponse.md)

### Authorization

[api_key](../../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **newPortfolioBid**
> \StockX\Client\Model\PortfolioResponse newPortfolioBid($portfolio)

Creates a new buyer bid on the market for a given product.

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

// Configure API key authorization: api_key
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('x-api-key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('x-api-key', 'Bearer');

$apiInstance = new StockX\Client\Api\StockXApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$portfolio = new \StockX\Client\Model\PortfolioRequest(); // \StockX\Client\Model\PortfolioRequest | The portfolio request representing the bid to place on the market.

try {
    $result = $apiInstance->newPortfolioBid($portfolio);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->newPortfolioBid: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **portfolio** | [**\StockX\Client\Model\PortfolioRequest**](../Model/PortfolioRequest.md)| The portfolio request representing the bid to place on the market. |

### Return type

[**\StockX\Client\Model\PortfolioResponse**](../Model/PortfolioResponse.md)

### Authorization

[api_key](../../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **postWebhooks**
> \StockX\Client\Model\WebhooksPostResponse postWebhooks($portfolio)



### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

// Configure API key authorization: api_key
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('x-api-key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('x-api-key', 'Bearer');

$apiInstance = new StockX\Client\Api\StockXApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$portfolio = new \StockX\Client\Model\WebhooksPostRequest(); // \StockX\Client\Model\WebhooksPostRequest | 

try {
    $result = $apiInstance->postWebhooks($portfolio);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->postWebhooks: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **portfolio** | [**\StockX\Client\Model\WebhooksPostRequest**](../Model/WebhooksPostRequest.md)|  |

### Return type

[**\StockX\Client\Model\WebhooksPostResponse**](../Model/WebhooksPostResponse.md)

### Authorization

[api_key](../../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **search**
> \StockX\Client\Model\SearchResults search($query)

Searches for products by keyword.

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

// Configure API key authorization: JWT
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('jwt-authorization', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('jwt-authorization', 'Bearer');
// Configure API key authorization: api_key
$config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKey('x-api-key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = StockX\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('x-api-key', 'Bearer');

$apiInstance = new StockX\Client\Api\StockXApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$query = "query_example"; // string | The phrase or keyword to search with.

try {
    $result = $apiInstance->search($query);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->search: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **query** | **string**| The phrase or keyword to search with. |

### Return type

[**\StockX\Client\Model\SearchResults**](../Model/SearchResults.md)

### Authorization

[JWT](../../README.md#JWT), [api_key](../../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

