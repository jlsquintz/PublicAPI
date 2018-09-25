# StockX Public API - Java 8+ Library

## Summary

This project provides a StockX Java assembly for accessing StockX's public API.

## Usage

* Add the StockX Jar from io.stock.sdk.examples/lib to your classpath (e.g. java -cp 'lib/io.stockx.sdk-x.x.x.jar')
* The library is distributed as a fat jar, meaning all dependencies are within the library
* Update the ExampleConstants source file to include your API Key (supplied by StockX) and your account credentials
* Execute the examples with (e.g. java -cp lib/io.stockx.sdk-x.x.x-x.jar io.stockx.sdk.examples.endpoint.GetProductInfoExample)

### Examples

This project provides the following examples of using the StockX Java Library:

* Logging into the StockX API
* Querying for open orders
* Querying for market data about a product
* Looking up product information
* Searching the product catalog via general queries
* Placing bids as a buyer
* Placing asks as a seller

### Directories

/lib - contains the cross platform StockX Java library
/src - contains examples of interacting with the StockX API with Java
