<?php

require_once(__DIR__ . '/../lib/vendor/autoload.php');
require_once('LoginUtil.php');
require_once('ExampleConstants.php');
require_once('JWTHeaderSelector.php');

$client = new GuzzleHttp\Client();
$config = StockX\Client\Configuration::getDefaultConfiguration()
->setApiKey('x-api-key', ExampleConstants::$AWS_API_KEY)
->setHost(Environment::$ENDPOINT_STAGING);

$headerSelector = new JWTHeaderSelector();

$api = new StockX\Client\Api\StockXApi(
    $client,
    $config,
    $headerSelector
);

try {
    LoginUtil::login($api, $headerSelector,
        ExampleConstants::$STOCKX_USERNAME,
        ExampleConstants::$STOCKX_PASSWORD);
    
    $portfolioItemReq = new StockX\Client\Model\PortfolioRequestPortfolioItem();
        $portfolioItemReq->setAmount("25");
        $portfolioItemReq->setSkuUuid("bae25b67-a721-4f57-ad5a-79973c7d0a5c");
        $portfolioItemReq->setMatchedWithDate("2018-12-12T05:00:00+0000");
        $portfolioItemReq->setCondition("2000");
        $portfolioItemReq->setAction(1000);
    
    $customer = new StockX\Client\Model\CustomerObject();
        $customer->setDefaultSize("7");
    
    $portfolioReq = new StockX\Client\Model\PortfolioRequest();
        $portfolioReq->setPortfolioItem($portfolioItemReq);
        $portfolioReq->setCustomer($customer);
        $portfolioReq->setTimezone("America/Detroit");
    
    $bidResp = $api->newPortfolioBid($portfolioReq);
    
    print_r($bidResp);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->newPortfolioBid: ', $e->getMessage(), PHP_EOL;
}