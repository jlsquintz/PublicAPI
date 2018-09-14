<?php

require_once('/Users/tonymccrary/git/PublicAPI/swagger/src-gen/php/SwaggerClient-php/vendor/autoload.php');
require_once('LoginUtil.php');
require_once('ExampleConstants.php');
require_once('JWTHeaderSelector.php');

$client = new GuzzleHttp\Client();
$config = Swagger\Client\Configuration::getDefaultConfiguration()
->setApiKey('x-api-key', ExampleConstants::$AWS_API_KEY)
->setHost(Environment::$ENDPOINT_SANDBOX);

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
    
    $product = $api->getProductById("air-jordan-1-retro-high-off-white-chicago", null);
    
    print_r($product);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->getProductById: ', $e->getMessage(), PHP_EOL;
}