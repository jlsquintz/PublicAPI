<?php

require_once(__DIR__ . '/../lib/vendor/autoload.php');
require_once('LoginUtil.php');
require_once('ExampleConstants.php');
require_once('JWTHeaderSelector.php');

$client = new GuzzleHttp\Client();
$config = StockX\Client\Configuration::getDefaultConfiguration()
->setApiKey('x-api-key', ExampleConstants::$AWS_API_KEY)
->setHost(Environment::$ENDPOINT_SANDBOX);

$headerSelector = new JWTHeaderSelector();

$api = new StockX\Client\Api\StockXApi(
        $client,
        $config,
        $headerSelector
    );

$login = new \StockX\Client\Model\LoginRequest();
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