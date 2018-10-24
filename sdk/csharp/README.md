# StockX Public API - .NET 4.5 C# Library

## Summary

This project provides a StockX .NET assembly for accessing StockX's public API.

## Usage

* Add the supplied assemblies from /lib to your project (visual studio solution, make file, etc)
* Update the ExampleConstants source file to include your API Key (supplied by StockX) and your account credentials
* Compile the examples in your project (or run the supplied bash script - requires Mono)
* In the bash script, the compiled .NET example binaries are placed in /bin
* Execute an example with (e.g. mono bin/ExampleName.exe)

### Examples

This project provides the following examples of using the StockX .NET Library:

* Logging into the StockX API
* Querying for open orders
* Querying for market data about a product
* Looking up product information
* Searching the product catalog via general queries
* Placing bids as a buyer
* Placing asks as a seller

### Directories

/lib - contains the cross platform StockX .NET 4.5 assembly and other required assemblies
/src - contains examples of interacting with the StockX API with C#
