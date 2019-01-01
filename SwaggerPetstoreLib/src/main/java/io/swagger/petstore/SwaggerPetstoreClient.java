/*
 * SwaggerPetstoreLib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */
package io.swagger.petstore;

import io.swagger.petstore.controllers.*;
import io.swagger.petstore.http.client.HttpClient;

public class SwaggerPetstoreClient {
    /**
     * Singleton access to Pet controller
     * @return	Returns the PetController instance 
     */
    public PetController getPet() {
        return PetController.getInstance();
    }

    /**
     * Singleton access to Store controller
     * @return	Returns the StoreController instance 
     */
    public StoreController getStore() {
        return StoreController.getInstance();
    }

    /**
     * Singleton access to User controller
     * @return	Returns the UserController instance 
     */
    public UserController getUser() {
        return UserController.getInstance();
    }

    /**
     * Get the shared http client currently being used for API calls
     * @return The http client instance currently being used
     */
    public HttpClient getSharedHttpClient() {
        return BaseController.getClientInstance();
    }
    
    /**
     * Set a shared http client to be used for API calls
     * @param httpClient The http client to use
     */
    public void setSharedHttpClient(HttpClient httpClient) {
        BaseController.setClientInstance(httpClient);
    }

    /**
     * Get authentication manager
     */
    public OAuthManager auth() {
        return OAuthManager.getInstance();
    }

    /**
     * Default constructor 
     */     
    public SwaggerPetstoreClient() {
    }

    /**
     * Client initialization constructor 
     */     
    public SwaggerPetstoreClient(String oAuthClientId, String oAuthRedirectUri) {
        this();
        Configuration.oAuthClientId = oAuthClientId;
        Configuration.oAuthRedirectUri = oAuthRedirectUri;
    }
}