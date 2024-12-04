package com.ouoj.ouojcodesandbox.security;

import java.security.Permission;

/**
 * 禁用所有的安全管理器
 */
public class MySecurityManager extends SecurityManager{

    //检查所有的权限
    @Override
    public void checkPermission(Permission perm) {
        System.out.println("默认不做任何限制");
        System.out.println(perm);
        super.checkPermission(perm);
    }

    //检测程序是否运行读文件
    @Override
    public void checkRead(String file) {
        System.out.println(file);
        if(file.contains("D:\\Java_study\\code\\OJ_OnlineTestJudgment\\ouoj-code-sandbox")){
            return;
        }
        super.checkRead(file);
    }

    //检测程序是否可执行
    @Override
    public void checkExec(String cmd) {
        super.checkExec(cmd);
    }

    //检测文件是否可以写文件
    @Override
    public void checkWrite(String file) {
        super.checkWrite(file);
    }

    @Override
    public void checkDelete(String file) {
        super.checkDelete(file);
    }
}
