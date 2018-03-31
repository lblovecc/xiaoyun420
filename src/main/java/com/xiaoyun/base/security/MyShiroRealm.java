package com.xiaoyun.base.security;


import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xiaoyun.main.model.User;
import com.xiaoyun.main.service.app.AppUserService;

@Component
public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	private AppUserService userService;

	/***
	 * 获取授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		/*Set<String> roleNames = new HashSet<String>();  
        Set<String> permissions = new HashSet<String>();  
        roleNames.add("administrator");//添加角色
        permissions.add("newPage.jhtml");  //添加权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);  
        info.setStringPermissions(permissions);  
        return info; */
        
      /*//获取当前登陆的用户名
      String loginName = (String) principals.fromRealm(getName()).iterator().next();
      //根据用户名查找对象
      User user  = new User();
      user.setAccount(loginName);
      user = userService.selectUser(user);*/      
		return  null;
	}
    
	 /* 
     * 登录验证
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
//		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//		char[] passwordArr = token.getPassword();
//		User user = new User();
//		user.setMobile(token.getUsername());
//		user.setPassword(String.valueOf(passwordArr));
//		User user1 = userService.getSelectUser(user);
//		if(null != user1){
//				Subject currentUser = SecurityUtils.getSubject();
//				Session session = currentUser.getSession();
//				session.setAttribute("user", user1);
//				session.setAttribute("roleId",user1.getRoleId());
//				return new SimpleAuthenticationInfo(user1.getAccount(),user1.getPassword().toCharArray(),getName());
//		}else{
//			throw new AuthenticationException("账号或密码错误!"); 
//		}
		return null;
	}

}
