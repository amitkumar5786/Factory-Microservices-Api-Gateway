package com.factory.factoryapigatway.config;

import com.factory.factoryapigatway.model.AccessTokenMapper;
import com.factory.factoryapigatway.model.ApplicationModel;
import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Author: Amit
 * Date: 04-01-2020
 */

@Component
public class JwtConverter extends DefaultAccessTokenConverter implements JwtAccessTokenConverterConfigurer {
    
    @Override
    public void configure(JwtAccessTokenConverter jwtAccessTokenConverter) {
        jwtAccessTokenConverter.setAccessTokenConverter(this);
    }

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
        OAuth2Authentication auth = super.extractAuthentication(map);
        AccessTokenMapper accessTokenMapper = new AccessTokenMapper();
        if(map.get("id") != null){
            accessTokenMapper.setId((Integer)map.get("id"));
        }
        if(map.get("name") != null){
            accessTokenMapper.setName((String) map.get("name"));
        }
        
        auth.setDetails(accessTokenMapper);
        return auth;
    }
}
