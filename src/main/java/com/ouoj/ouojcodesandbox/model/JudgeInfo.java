package com.ouoj.ouojcodesandbox.model;


import lombok.Data;

/**
 * 题目配置
 */
@Data
public class JudgeInfo {

    /**
     * 程序执行信息（ms）
     */
    private String message;

    /**
     * 消耗内存
     */
    private Long memory;

    /**
     * 消耗时间(KB)
     */
    private Long time;


}
