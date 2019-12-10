package com.lckgroup.canteensys.config;

import com.lckgroup.canteensys.shiro.CardRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);

        Map<String, String> filterMap =new LinkedHashMap<>();
        filterMap.put("/customer/*","authc");
        bean.setFilterChainDefinitionMap(filterMap);
        //设置登录跳转
        //bean.setLoginUrl("");
        return bean;
    }

    //DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("cardRealm") CardRealm cardRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(cardRealm);
        return securityManager;
    }

    //Realm
    @Bean
    public CardRealm cardRealm(){
        return new CardRealm();
    }
}
