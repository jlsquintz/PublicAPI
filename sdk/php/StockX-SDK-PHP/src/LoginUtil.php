<?php

class LoginUtil {
    
    public static function login($api, $headerSelector, $username, $password) {
        $login = new \Swagger\Client\Model\LoginRequest();
        $login->setEmail($username);
        $login->setPassword($password);
        
        try {
            $result = $api->loginWithHttpInfo($login);
            $jwtHeader = $result[2]["Jwt-Authorization"][0];
            $headerSelector->setToken($jwtHeader);
            
            return $result;
        } catch (Exception $e) {
            echo 'Exception when calling StockXApi->login: ', $e->getMessage(), PHP_EOL;
        }
    }
}

