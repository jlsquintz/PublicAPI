const superagent = require('superagent');
const URL = 'https://gateway.stockx.com/sandbox';

//Personal Data. You fill this in. 
const API_KEY = 'API_KEY_GIVEN_BY_STOCKX';
const USERNAME = 'Email Address';
const PASSWORD = 'Password';



class SneakerAsk {
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

    findSneaker(sneaker) {
        //This will return an array of items based on the query string. This will search all products across stockx
        return new Promise((resolve, reject) => {
            superagent
                .get(`${URL}/v1/search?query=${sneaker}`)
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

    getSneakerProduct(styleId, size) {
        //This lookups up a product based on style id and size. 
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

    getSneakerPriceData(id, sku) {
        // This returns market data. You will need the product uuid and the sku to retreive it.
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

    placeAsk(sku, expiresAt, amount) {
        //sku is required to place an ask. This is the unique id of the sneaker + size. You can get this via product data call.
        return new Promise((resolve, reject) => {
            superagent.post(`${URL}/v1/portfolio/ask`)
            .set('x-api-key', API_KEY)
            .set('jwt-authorization', this.jwt)
            .send({
                "PortfolioItem": {
                    "amount": amount.toString(),
                    "expiresAt": expiresAt,
                    "skuUuid": sku
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

    run() {
        //Login and set the jwt for authorizaiton
        this.login().then(loginData => {
            this.jwt = loginData.header['jwt-authorization'];

            //Find the Jordan Retro Black Cat sneaker
            return this.findSneaker('Jordan%206%20Retro%20Black%20Cat');
        }).then(sneakers => {
            //Pull the first item from the search results
            const mySneaker = sneakers[0];
        
            //Get the product information from the style_id of the sneaker
            return this.getSneakerProduct(mySneaker.style_id, 11)
        }).then(product => {
            
            //Get the up to date pricing information for the sneaker
            return this.getSneakerPriceData(product.attributes.product_uuid, product.id) 
        }).then(data => {
            //Grab the lowest ask and subtract a dollar from it
            const lowestAsk = data.Market.lowestAsk - 1;

            //Place the new lowest ask
            return this.placeAsk(data.Market.skuUuid, '2018-07-29T19:39:07+00:00', lowestAsk);

        }).then(data => {
            console.log('Successfully placed the ask');
        }).catch(err => {
            console.error(err);
        })
    }
}







const sneak = new SneakerAsk();

sneak.run();




