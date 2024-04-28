package com.selenium;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {
    int counter = 0;
    int maxRetry = 3;
    @Override
    public boolean retry(ITestResult iTestResult) {
        while (counter<maxRetry){
            counter++;
            return true;
        }
        return false;
    }
}
