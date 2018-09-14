<?php

require_once('/Users/tonymccrary/git/PublicAPI/swagger/src-gen/php/SwaggerClient-php/vendor/autoload.php');
require_once('LoginUtil.php');
require_once('ExampleConstants.php');
require_once('JWTHeaderSelector.php');

$client = new GuzzleHttp\Client();
$config = Swagger\Client\Configuration::getDefaultConfiguration()
->setApiKey('x-api-key', ExampleConstants::$AWS_API_KEY)
->setHost(Environment::$ENDPOINT_STAGING);

$headerSelector = new JWTHeaderSelector();

$api = new Swagger\Client\Api\StockXApi(
        $client,
        $config,
        $headerSelector
    );

try {
    LoginUtil::login($api, $headerSelector, 
                    ExampleConstants::$STOCKX_USERNAME, 
                    ExampleConstants::$STOCKX_PASSWORD);
    
    $searchResult = $api->search("yeezy", null);
    
    print_r($searchResult);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->getProductById: ', $e->getMessage(), PHP_EOL;
}