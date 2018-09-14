const superagent = require('superagent');

// Customize these string values for your account and environment.
const API_KEY =   'API_Key_Given_By_StockX_Engineering';
const EMAIL =     'Email_Address';
const PASSWORD =  'Password';
const ENV =       'stage'; // Options: 'sandbox', 'stage', 'public'

const URL = `https://gateway.stockx.com/${ENV}`;

class CurrentOrders {
  run() {
    this._login().then(loginData => {
      // Login and set the JWT for authorization.
      this.jwt = loginData.header['jwt-authorization'];
      this.customerData = loginData.body;

      const customerId = this.customerData.Customer.id;

      return this._getOpenOrders(customerId);

    }).then(data => {
      // Log out order data.
      console.log(data);

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

  // Retrieve open orders.
  _getOpenOrders(customerId) {
    return new Promise((resolve, reject) => {
      // Set the limit to a high number to get all pending orders. Otherwise you can page through by setting page= query.
      superagent
        .get(`${URL}/v1/customers/${customerId}/selling/current?limit=500`)
          .set('jwt-authorization', this.jwt)
          .set('x-api-key', API_KEY)
          .end((err, res) => {
            if(err) {
              reject(err);
            }else{
              resolve(res.body);
            }
          });
    })
  }
}

const currentOrders = new CurrentOrders();

currentOrders.run();

