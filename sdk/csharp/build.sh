#!/bin/bash

echo "Building GetProductInfoExample"
mcs src/IO.StockX.Examples/ExampleConstants.cs src/IO.StockX.Examples/GetProductInfoExample.cs \
    -out:bin/GetProductInfoExample.exe \
    -r:lib/IO.StockX.dll \
    -r:lib/JsonSubTypes.dll \
    -r:lib/Newtonsoft.Json.dll \
    -r:lib/RestSharp.dll \
    -r:System.ComponentModel.DataAnnotations.dll \
    -r:System.Runtime.Serialization.dll

echo "Building LoginExample"
mcs src/IO.StockX.Examples/ExampleConstants.cs src/IO.StockX.Examples/LoginExample.cs \
    -out:bin/LoginExample.exe \
    -r:lib/IO.StockX.dll \
    -r:lib/JsonSubTypes.dll \
    -r:lib/Newtonsoft.Json.dll \
    -r:lib/RestSharp.dll \
    -r:System.ComponentModel.DataAnnotations.dll \
    -r:System.Runtime.Serialization.dll

echo "Building PortfolioAskExample"
mcs src/IO.StockX.Examples/ExampleConstants.cs src/IO.StockX.Examples/PortfolioAskExample.cs \
    -out:bin/PortfolioAskExample.exe \
    -r:lib/IO.StockX.dll \
    -r:lib/JsonSubTypes.dll \
    -r:lib/Newtonsoft.Json.dll \
    -r:lib/RestSharp.dll \
    -r:System.ComponentModel.DataAnnotations.dll \
    -r:System.Runtime.Serialization.dll

echo "Building PortfolioBidExample"
mcs src/IO.StockX.Examples/ExampleConstants.cs src/IO.StockX.Examples/PortfolioBidExample.cs \
    -out:bin/PortfolioBidExample.exe \
    -r:lib/IO.StockX.dll \
    -r:lib/JsonSubTypes.dll \
    -r:lib/Newtonsoft.Json.dll \
    -r:lib/RestSharp.dll \
    -r:System.ComponentModel.DataAnnotations.dll \
    -r:System.Runtime.Serialization.dll

echo "Building GetOpenOrdersExample"
mcs src/IO.StockX.Examples/ExampleConstants.cs src/IO.StockX.Examples/GetOpenOrdersExample.cs \
    -out:bin/GetOpenOrdersExample.exe \
    -r:lib/IO.StockX.dll \
    -r:lib/JsonSubTypes.dll \
    -r:lib/Newtonsoft.Json.dll \
    -r:lib/RestSharp.dll \
    -r:System.ComponentModel.DataAnnotations.dll \
    -r:System.Runtime.Serialization.dll

echo "Building GetProductMarketDataExample"
mcs src/IO.StockX.Examples/ExampleConstants.cs src/IO.StockX.Examples/GetProductMarketDataExample.cs \
    -out:bin/GetProductMarketDataExample.exe \
    -r:lib/IO.StockX.dll \
    -r:lib/JsonSubTypes.dll \
    -r:lib/Newtonsoft.Json.dll \
    -r:lib/RestSharp.dll \
    -r:System.ComponentModel.DataAnnotations.dll \
    -r:System.Runtime.Serialization.dll

echo "Building SearchExample"
mcs src/IO.StockX.Examples/ExampleConstants.cs src/IO.StockX.Examples/SearchExample.cs \
    -out:bin/SearchExample.exe \
    -r:lib/IO.StockX.dll \
    -r:lib/JsonSubTypes.dll \
    -r:lib/Newtonsoft.Json.dll \
    -r:lib/RestSharp.dll \
    -r:System.ComponentModel.DataAnnotations.dll \
    -r:System.Runtime.Serialization.dll

echo "Building PlaceNewHighestBidExample"
mcs src/IO.StockX.Examples/ExampleConstants.cs src/IO.StockX.Examples/PlaceNewHighestBidExample.cs \
    -out:bin/PlaceNewHighestBidExample.exe \
    -r:lib/IO.StockX.dll \
    -r:lib/JsonSubTypes.dll \
    -r:lib/Newtonsoft.Json.dll \
    -r:lib/RestSharp.dll \
    -r:System.ComponentModel.DataAnnotations.dll \
    -r:System.Runtime.Serialization.dll

echo "Building PlaceNewLowestAskExample"
mcs src/IO.StockX.Examples/ExampleConstants.cs src/IO.StockX.Examples/PlaceNewLowestAskExample.cs \
    -out:bin/PlaceNewLowestAskExample.exe \
    -r:lib/IO.StockX.dll \
    -r:lib/JsonSubTypes.dll \
    -r:lib/Newtonsoft.Json.dll \
    -r:lib/RestSharp.dll \
    -r:System.ComponentModel.DataAnnotations.dll \
    -r:System.Runtime.Serialization.dll
