package com.qin.catcat.unite.service;

import java.util.Map;

/**
 * @Description 微信分享服务.
 *
 * @Author liuyun
 * @Version 1.0
 * @Since 2025-01-11 00:04
 */
public interface WxShareService {

    /**
     * @Description 获取微信配置
     * @param url 
     * @return 
     */
    public Map<String, String> getWxConfig(String url) throws Exception;

    // /**
    //  * @Description 获取微信access_token
    //  * @param appId 
    //  * @param appSecret 
    //  * @return 
    //  */
    // public String getAccessToken(String appId, String appSecret) throws Exception;

    // /**
    //  * @Description 获取微信jsapi_ticket
    //  * @param accessToken 
    //  * @return 
    //  */
    // public String getJsapiTicket(String accessToken) throws Exception;
}
