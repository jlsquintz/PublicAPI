# Authentication

An API Key is required in the header for all API requests. StockX Engineering is currently issuing a limited number of API keys. [Contact us](https://developers.stockx.com/) for more information.

A [JWT](https://jwt.io/introduction/) is required in the header of API requests (`jwt-authentication`) except for `GET Login`. A JWT is issued via the response to a `GET Login` request. JWT expiration is ABCXYZ.

# Buying

## Get Pending Buying Orders

1. POST Login
2. GET Pending Open Orders

Code examples for this workflow are available in the `examples` directory of [StockX's Public API code repository](https://github.com/stockx/PublicAPI/).

## Place New Highest Bid

1. POST Login
2. GET Product Search
3. GET Product Lookup
4. GET Product Market Data
5. POST Bid

Code examples for this workflow are available in the `examples` directory of [StockX's Public API code repository](https://github.com/stockx/PublicAPI/).

# Selling

## Get Current Selling Orders

1. POST Login
2. GET Current Open Orders

Code examples for this workflow are available in the `examples` directory of [StockX's Public API code repository](https://github.com/stockx/PublicAPI/).

## Place New Lowest Ask

1. POST Login
2. GET Product Search
3. GET Product Lookup
4. GET Product Market Data
5. POST Ask

Code examples for this workflow are available in the `examples` directory of [StockX's Public API code repository](https://github.com/stockx/PublicAPI/).
