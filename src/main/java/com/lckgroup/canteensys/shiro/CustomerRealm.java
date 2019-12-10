package com.lckgroup.canteensys.shiro;

import com.lckgroup.canteensys.entity.Customer;
import com.lckgroup.canteensys.service.CustomerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerRealm extends AuthorizingRealm {

    @Autowired
    private CustomerService customerService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String cusId= (String) token.getPrincipal();
        Customer customer=customerService.findByCusId(cusId);
        if(customer == null){
            return null;
        }

        return new SimpleAuthenticationInfo(customer,customer.getCusPwd(),getName());
    }
}
