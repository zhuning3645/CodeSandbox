package com.ouoj.ouojcodesandbox.utils;

import com.ouoj.ouojcodesandbox.model.ExecuteMessage;

import java.io.*;

/**
 * 进程工具类
 */
public class ProcessUtils {

    /**
     * 执行进程并获取信息
     * @param runProcess
     * @param opName
     * @return
     */
    public static ExecuteMessage runProcessAndGetMessage(Process runProcess,String opName) {

        ExecuteMessage executeMessage = new ExecuteMessage();

        try {

            //等待程序执行，获取错误码
            int exitValue = runProcess.waitFor();
            executeMessage.setExitValue(exitValue);

            //正常退出
            if (exitValue == 0) {
                System.out.println(opName + "成功");
                System.out.println("编译成功");
                //分批获取进程的正确输出
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
                StringBuilder compileOutputStringBuilder = new StringBuilder();
                //逐行读取
                String compileOutputLine;
                while ((compileOutputLine = bufferedReader.readLine()) != null) {
                    compileOutputStringBuilder.append(compileOutputLine);
                }
                executeMessage.setMessage(compileOutputStringBuilder.toString());
                System.out.println(compileOutputStringBuilder);

            } else {
                //异常退出
                System.out.println(opName + "失败,错误码：" + exitValue);
                //分批获取进程的输出
                BufferedReader errorBufferedReader = new BufferedReader(new InputStreamReader(runProcess.getErrorStream()));
                StringBuilder errorCompileOutputStringBuilder = new StringBuilder();
                //逐行读取
                String errorCompileOutputLine;
                while ((errorCompileOutputLine = errorBufferedReader.readLine()) != null) {
                    errorCompileOutputStringBuilder.append(errorCompileOutputLine);
                }
                executeMessage.setErrorMessage(errorCompileOutputStringBuilder.toString());
                System.out.println(errorCompileOutputStringBuilder);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return executeMessage;
    }

    /**
     * 交互式进程处理方法
     * @param runProcess
     * @param args
     * @return
     */
    public static ExecuteMessage runInteractProcessAndGetMessage(Process runProcess,String args) {

        ExecuteMessage executeMessage = new ExecuteMessage();

        try {
            //向控制台输入程序
            InputStream inputStream = runProcess.getInputStream();
            OutputStream outputStream = runProcess.getOutputStream();

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            String[] s = args.split(" ");
            String join = String.join("\n", s) + "\n";
            outputStreamWriter.write(join);
            //向控制台按了回车，执行输入的发送
            outputStreamWriter.flush();

            //分批获取进程的正确输出
            BufferedReader runBufferedReader = new BufferedReader(new InputStreamReader(inputStream ));
            StringBuilder runOutputStringBuilder = new StringBuilder();
            //逐行读取
            String runOutputLine;
            while ((runOutputLine = runBufferedReader.readLine()) != null) {
                runOutputStringBuilder.append(runOutputLine);
            }
            executeMessage.setMessage(runOutputStringBuilder.toString());
            System.out.println(runOutputStringBuilder);
            //关闭流、销毁进程
            outputStreamWriter.close();
            outputStream.close();
            inputStream.close();
            runProcess.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return executeMessage;
    }
}

