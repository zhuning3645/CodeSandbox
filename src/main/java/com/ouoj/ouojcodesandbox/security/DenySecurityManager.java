package com.ouoj.ouojcodesandbox.security;

import java.security.Permission;

/**
 * 禁用所有的安全管理器
 */
public class DenySecurityManager extends SecurityManager{

    //检查所有的权限
    @Override
    public void checkPermission(Permission perm) {
        throw new SecurityException("You do not have permission to do this");

    }

}
