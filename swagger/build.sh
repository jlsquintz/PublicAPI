#!/bin/bash

rm -rf src-gen
mkdir src-gen

java -jar bin/swagger-codegen-cli.jar generate -c config/config.go.json -i swagger.json -l go -o src-gen/go
java -jar bin/swagger-codegen-cli.jar generate -c config/config.csharp.json -i swagger.json -l csharp -o src-gen/csharp
java -jar bin/swagger-codegen-cli.jar generate -c config/config.java.json -i swagger.json -l java -o src-gen/java
java -jar bin/swagger-codegen-cli.jar generate -i swagger.json -l html -o src-gen/html
java -jar bin/swagger-codegen-cli.jar generate -c config/config.php.json -i swagger.json -l php -o src-gen/php
java -jar bin/swagger-codegen-cli.jar generate -c config/config.node.json -i swagger.json -l javascript -o src-gen/nodejs
java -jar bin/swagger-codegen-cli.jar generate -c config/config.python.json -i swagger.json -l python -o src-gen/python
java -jar bin/swagger-codegen-cli.jar generate -i swagger.json -l jmeter -o src-gen/jmeter
