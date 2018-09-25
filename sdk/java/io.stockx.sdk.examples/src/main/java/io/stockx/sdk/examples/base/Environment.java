package io.stockx.sdk.examples.base;

/**
 * <p>
 * Environment defines the various gateway instances that StockX exposes to end
 * users.
 * </p>
 */
public enum Environment {
    /** Pre-staging environment. */
    SANDBOX("https://gateway.stockx.com/sandbox"),

    /** The staging pre-production environment. */
    STAGING("https://gateway.stockx.com/stage"),

    /** The production API gateway. */
    PUBLIC("https://gateway.stockx.com/public");

    /** The URL associated with the given target environment. */
    private final String url;

    private Environment(String url) {
        this.url = url;
    }

    /**
     * <p>
     * Returns a String representing the URL used to access the environment.
     * </p>
     * 
     * @return a String representing the URL of the supplied environment
     */
    public String getUrl() {
        return this.url;
    }

}
