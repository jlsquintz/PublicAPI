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

$login = new \Swagger\Client\Model\LoginRequest();
$login->setEmail(ExampleConstants::$STOCKX_USERNAME);
$login->setPassword(ExampleConstants::$STOCKX_PASSWORD);

try {
    $result = $api->loginWithHttpInfo($login);
    $jwtHeader = $result[2][ExampleConstants::$JWT_HEADER][0];
    $headerSelector->setToken($jwtHeader);
    
    $user = $result[0]["customer"];
    print_r("User logged in: " .  $user["full_name"]);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->login: ', $e->getMessage(), PHP_EOL;
}