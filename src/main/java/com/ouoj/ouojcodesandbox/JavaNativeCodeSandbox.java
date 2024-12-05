package com.ouoj.ouojcodesandbox;

import com.ouoj.ouojcodesandbox.model.ExecuteCodeRequest;
import com.ouoj.ouojcodesandbox.model.ExecuteCodeResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Java原生代码沙箱实现（直接复用模版方法）
 */
@Slf4j
@Component
public class JavaNativeCodeSandbox extends JavaCodeSandboxTemplate {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        return super.executeCode(executeCodeRequest);
    }
}
