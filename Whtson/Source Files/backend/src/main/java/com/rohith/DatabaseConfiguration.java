package com.rohith;


import com.bazaarvoice.dropwizard.assets.AssetsBundleConfiguration;
import com.bazaarvoice.dropwizard.assets.AssetsConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;


import javax.security.auth.login.AppConfigurationEntry;
import javax.validation.Valid;


public class DatabaseConfiguration extends Configuration implements AssetsBundleConfiguration {
    @Valid
    @NotNull
    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();

    @Valid
    @NotNull
    @JsonProperty
    private final AssetsConfiguration assets = new AssetsConfiguration();

    public DataSourceFactory getDataSourceFactory() {
        return this.database;
    }


    public AssetsConfiguration getAssetsConfiguration() {
        return this.assets;
    }
}

