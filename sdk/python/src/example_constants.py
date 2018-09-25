from __future__ import print_function
import time
import io_stockx
from io_stockx.rest import ApiException
from pprint import pprint

class ExampleConstants:

    AWS_API_KEY = "<API Key>"

    STOCKX_USERNAME = "<StockX Username>"

    STOCKX_PASSWORD = "<StockX Password>"

    DEMO_PRODUCT_ID = "air-jordan-1-retro-high-off-white-chicago"

    DEMO_CUSTOMER_ID = "1471698"

    ENABLE_DEBUG = True

    JWT_HEADER = "Jwt-Authorization"