package com.selenium;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestNGListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("--from on test start method--");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("--from on test success method--");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("--from on test failure method-- attach screenshot");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("--from on test skipped method--");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("--from on test starting--");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("--from on test finish method--");
    }
}
