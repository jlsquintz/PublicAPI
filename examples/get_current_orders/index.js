const superagent = require('superagent');
const URL = 'https://gateway.stockx.com/sandbox';

//Personal Data. You fill this in. 
const API_KEY = 'API_KEY';
const USERNAME = 'USERNAME';
const PASSWORD = 'PASSWOPRD';



class CurrentOrders {
    login() {
        return new Promise((resolve, reject) => {
            superagent
                .post(`${URL}/v1/login`)
                .send({ email: USERNAME, password: PASSWORD })
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

    getOpenOrders(customerId) {
        return new Promise((resolve, reject) => {
            //Set the limit to a high number to get all pending orders. Otherwise you can page through by setting page= query.  
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

    run() {
        //Login and set the jwt for authorizaiton
        this.login().then(loginData => {
            this.jwt = loginData.header['jwt-authorization'];
            this.customerData = loginData.body;

            const customerId = this.customerData.Customer.id;

            return this.getOpenOrders(customerId);

        }).then(data => {
            //Log out order data.
            console.log(data);
        }).catch(err => {
            console.error(err);
        })
    }
}







const sneak = new CurrentOrders();

sneak.run();




