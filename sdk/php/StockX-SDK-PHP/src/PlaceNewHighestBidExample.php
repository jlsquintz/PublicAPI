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
    // Login to the StockX framework - see LoginExample for how this works
    $customer = LoginUtil::login($api, $headerSelector,
        ExampleConstants::$STOCKX_USERNAME,
        ExampleConstants::$STOCKX_PASSWORD);

    // Search for a given product and lookup its styleid
    $firstResult = $api->search("Jordan Retro Black Cat2")->getHits()[0];
    $styleId = $firstResult->getStyleId();
    
    // Look up the product info by style id and size
    $productInfo = $api->lookupProduct($styleId, "11");
    
    $productId = $productInfo["data"][0]["id"];
    $productUuid = $productInfo["data"][0]["attributes"]["product_uuid"];
    
    // Lookup the current market data for the product
    $marketData = $api->getProductMarketData($productId, $productUuid);
    
    // Get the current highest bid and increment it
    $highestBid = $marketData["market"]["highest_bid"];
    $highestBid++;
    
    // Create a portfolio item request with a higher bid
    $portfolioItemReq = new Swagger\Client\Model\PortfolioRequestPortfolioItem();
    $portfolioItemReq->setAmount($highestBid);
    $portfolioItemReq->setSkuUuid("bae25b67-a721-4f57-ad5a-79973c7d0a5c");
    $portfolioItemReq->setMatchedWithDate("2018-12-12T05:00:00+0000");
    $portfolioItemReq->setExpiresAt("2018-12-12T12:39:07+00:00");
    
    $portfolioReq = new Swagger\Client\Model\PortfolioRequest();
    $portfolioReq->setPortfolioItem($portfolioItemReq);
    $portfolioReq->setCustomer($customer[0]["customer"]);
    $portfolioReq->setTimezone("America/Detroit");
    
    // Submit the bid
    $bidResp = $api->newPortfolioBid($portfolioReq);
    
    print_r($bidResp);
} catch (Exception $e) {
    echo 'Exception when calling StockXApi->newPortfolioBid: ', $e->getMessage(), PHP_EOL;
}