/*
 * SwaggerPetstoreLib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */
package io.swagger.petstore;

import android.util.Base64;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.swagger.petstore.models.OAuthScopeEnum;

/**
 * Utility class for OAuth 2 authorization and token management
 */
public class OAuthManager {
    /**
     * The reference to singleton instance of this class
     */
    private static OAuthManager instance;

    private static final Object syncRoot = new Object();

    /**
     * Constructor
     */
    private OAuthManager() {
    }

    /**
     * Returns the *Singleton* instance of this class.
     * @return Singleton instance
     */
    public static OAuthManager getInstance() {
        if (instance == null) {
            synchronized (syncRoot) {
                if (instance == null) {
                    instance = new OAuthManager();
                }
            }
        }
        return instance;
    }

    /**
     * Build an authorization URL for taking the user's consent to access data
     * @param scope List of scopes needed
     * @param state An opaque state string
     * @param additionalParameters Additional parameters to add the the authorization URL
     * @return Authorization URL
     */
    public String buildAuthorizationUrl(final List<OAuthScopeEnum> scope, final String state,
            final Map<String, String> additionalParameters) {

        // the uri for api requests
        StringBuilder queryBuilder = new StringBuilder(Configuration.getBaseUri(Servers.AUTH_SERVER));
        queryBuilder.append("/authorize");

        // build query params
        Map<String, Object> queryParameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;
            {
                put("response_type", "token");
                put("client_id", Configuration.oAuthClientId);
                put("redirect_uri", Configuration.oAuthRedirectUri);
                put("scope", stringJoin(scope, " "));
                put("state", state);
            }
        };

        // process optional query parameters
        if (additionalParameters != null)
            queryParameters.putAll(additionalParameters);

        APIHelper.appendUrlWithQueryParameters(queryBuilder, queryParameters);

        // validate and preprocess url
        return APIHelper.cleanUrl(queryBuilder);
    }
    
    /**
     * Build an authorization URL for taking the user's consent to access data
     * @return Authorization URL
     */
    public String buildAuthorizationUrl() {
        return buildAuthorizationUrl(null, null, null);
    }
    /**
     * Build an authorization URL for taking the user's consent to access data
     * @param scopes List of scopes needed
     * @return Authorization URL
     */
    public String buildAuthorizationUrl(final List<OAuthScopeEnum> scopes) {
        return buildAuthorizationUrl(scopes, null, null);
    }

    /**
     * Build an authorization URL for taking the user's consent to access data
     * @param scopes List of scopes needed
     * @param state An opaque state string
     * @return Authorization URL
     */
    public String buildAuthorizationUrl(final List<OAuthScopeEnum> scopes, final String state) {
        return buildAuthorizationUrl(scopes, state, null);
    }

    /**
     * Join string collection elements using delimiter
     * @param col String collection to join
     * @param delim Delimiter
     * @return String joined by delimiter
     */
    private static String stringJoin(Collection<?> col, String delim) {
        if (col == null)
            return null;
        StringBuilder sb = new StringBuilder();
        Iterator<?> iter = col.iterator();
        if (iter.hasNext())
            sb.append(iter.next().toString());
        while (iter.hasNext()) {
            sb.append(delim);
            sb.append(iter.next().toString());
        }
        return sb.toString();
    }
}
