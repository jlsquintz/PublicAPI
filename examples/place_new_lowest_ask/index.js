const superagent = require('superagent');

// Customize these string values for your account and environment.
const API_KEY =   'API_Key_Given_By_StockX_Engineering';
const EMAIL =     'Email_Address';
const PASSWORD =  'Password';
const ENV =       'stage'; // Options: 'sandbox', 'stage', 'public'

const URL = `https://gateway.stockx.com/${ENV}`;

class ProductAsk {
  run() {
    this._login().then(loginData => {
      // Login and set the jwt for authorization.
      this.jwt = loginData.header['jwt-authorization'];

      // Find the Jordan Retro Black Cat sneaker.
      return this._findProduct('Jordan%206%20Retro%20Black%20Cat');

    }).then(productSearchResults => {
      // Pull the first item from the search results.
      const myProduct = productSearchResults[0];

      // Get the product information from the style_id of the product.
      return this._getProduct(mySneaker.style_id, 11)

    }).then(product => {
      // Get the up to date pricing information for the product.
      return this._getProductPriceData(product.attributes.product_uuid, product.id)

    }).then(data => {
      // Grab the lowest ask and subtract a dollar from it.
      const lowestAsk = data.Market.lowestAsk - 1;

      // Place the new lowest ask. Date must be in the future.
      return this._placeAsk(data.Market.skuUuid, '2018-12-12T12:39:07+00:00', lowestAsk);

    }).then(data => {
      // Log for success.
      console.log('Successfully placed the ask');

    }).catch(err => {
      // Log for error.
      console.error(err);
    })
  }

  // Login with API Key, email address, and password to retrieve a JWT.
  _login() {
    return new Promise((resolve, reject) => {
      superagent
        .post(`${URL}/v1/login`)
        .send({ email: EMAIL, password: PASSWORD })
        .set('x-api-key', API_KEY)
        .end((err, res) => {
          if(err) {
            reject(err);
          }else{
            resolve(res);
          }
        });
    })
  }

  // Retrieve an array of items based on the product query string, searching all products across StockX.com
  _findProduct(productQuery) {
    return new Promise((resolve, reject) => {
      superagent
        .get(`${URL}/v2/search?query=${productQuery}`)
        .set('x-api-key', API_KEY)
        .end((err, res) => {
          if(err) {
            reject(err);
          }else{
            resolve(res.body.hits);
          }
        });
    })
  }

  //This lookups up a product based on style id and size.
  _getProduct(styleId, size) {
    return new Promise((resolve, reject) => {
      superagent
        .get(`${URL}/product/lookup?identifier=${styleId}&size=${size}`)
        .set('x-api-key', API_KEY)
        .end((err, res) => {
          if(err) {
            reject(err);
          }else{
            resolve(res.body.data[0]);
          }
        })
    });
  }

  // This returns market data. You will need the product's uuid and sku to retreive it.
  _getProductPriceData(id, sku) {
    return new Promise((resolve, reject) => {
      superagent
        .get(`${URL}/v1/products/${id}/market?children=${sku}`)
        .set('jwt-authorization', this.jwt)
        .set('x-api-key', API_KEY)
        .end((err, res) => {
          if(err) {
            reject(err);
          }else{
            resolve(res.body);
          }
        })
    });
  }

  // The product's sku is required to place an ask. This is the unique id of the sneaker + size. You can get this via product data call.
  _placeAsk(sku, expiresAt, amount) {
    return new Promise((resolve, reject) => {
      superagent
        .post(`${URL}/v1/portfolio/ask`)
        .set('x-api-key', API_KEY)
        .set('jwt-authorization', this.jwt)
        .send({
          "PortfolioItem": {
            "amount":     amount.toString(),
            "expiresAt":  expiresAt,
            "skuUuid":    sku
          }
        })
        .end((err, res) => {
          if(err) {
            reject(err);
          }else{
            resolve(res);
          }
        });
    });
  }
}

const productAsk = new ProductAsk();

productAsk.run();

