package com.ouoj.ouojcodesandbox;

import com.ouoj.ouojcodesandbox.model.ExecuteCodeRequest;
import com.ouoj.ouojcodesandbox.model.ExecuteCodeResponse;

public interface CodeSandbox {
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
