package com.factory.factoryauthorizationserver.config;

import com.factory.factoryauthorizationserver.model.CustomerUserModel;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author: Amit
 * Date: 02-01-2020
 */
public class CustomTokenEnhancer extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        CustomerUserModel customUser = (CustomerUserModel) authentication.getPrincipal();
        Map<String,Object> info = new LinkedHashMap<>(accessToken.getAdditionalInformation());
        if(customUser.getId() != 0){
            info.put("id", customUser.getId());
        }
        if(customUser.getName() != null){
            info.put("name", customUser.getName());
        }

        DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
        customAccessToken.setAdditionalInformation(info);
        return super.enhance(customAccessToken, authentication);
    }
}
