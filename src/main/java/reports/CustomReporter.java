package reports;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CustomReporter implements ITestListener, IReporter {
    private List<ITestNGMethod> passedTests = new ArrayList<ITestNGMethod>();
    private List<ITestNGMethod> failedTests = new ArrayList<ITestNGMethod>();
    private List<ITestNGMethod> skippedTests = new ArrayList<ITestNGMethod>();

    public List<ITestNGMethod> getPassedTests() {
        return passedTests;
    }

    public List<ITestNGMethod> getFailedTests() {
        return failedTests;
    }

    public List<ITestNGMethod> getSkippedTests() {
        return skippedTests;
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        passedTests.add(result.getMethod());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failedTests.add(result.getMethod());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        skippedTests.add(result.getMethod());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Override
    public void generateReport(List<XmlSuite> list, List<ISuite> list1, String s) {

        for (ISuite suite : list1) {

            Map<String, ISuiteResult> suiteResults = suite.getResults();
            PrintWriter passedTestWriter = null;
            PrintWriter failedTestWriter = null;
            PrintWriter skippedTestWriter = null;

            String passedTestFilePath = "src/main/java/reports/ReportPages/passed-tests.html";
            String failedTestFilePath = "src/main/java/reports/ReportPages/failed-tests.html";
            String skippedTestFilePath = "src/main/java/reports/ReportPages/skipped-tests.html";

            try {
                passedTestWriter = new PrintWriter(new File(passedTestFilePath));
                passedTestWriter.write(HtmlUtil.startHtmlPassedTest);
                failedTestWriter = new PrintWriter(new File(failedTestFilePath));
                failedTestWriter.write(HtmlUtil.startHtmlFailedTest);
                skippedTestWriter = new PrintWriter(new File(skippedTestFilePath));
                skippedTestWriter.write(HtmlUtil.startHtmlSkippedTest);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            for (ISuiteResult sr : suiteResults.values()) {
                ITestContext tc = sr.getTestContext();
                for (ITestResult iTestResult : tc.getPassedTests().getAllResults()) {
                    Object[] object = iTestResult.getParameters();
                    long time = iTestResult.getEndMillis() - iTestResult.getStartMillis();
                    String timeFormed = time + "ms";
                    if (passedTestWriter != null) {
                        passedTestWriter.write("<tr><td>" + object[1] + "</td> <td>" + iTestResult.getMethod().getMethodName() + "</td> <td>" + timeFormed + "</td></tr>");
                    }
                }
                for (ITestResult iTestResult : tc.getFailedTests().getAllResults()) {
                    Object[] object = iTestResult.getParameters();
                    long time = iTestResult.getEndMillis() - iTestResult.getStartMillis();
                    String timeFormed = time + "ms";
                    assert failedTestWriter != null;
                    failedTestWriter.write("<tr><td>" + object[1] + "</td> <td>" + iTestResult.getMethod().getMethodName() + "</td><td>" + iTestResult.getThrowable().getMessage() + "</td> <td>" + timeFormed + "</td></tr>");
                }
                for (ITestResult iTestResult : tc.getSkippedTests().getAllResults()) {
                    Object[] object = iTestResult.getParameters();
                    long time = iTestResult.getEndMillis() - iTestResult.getStartMillis();
                    String timeFormed = time + "ms";
                    if (skippedTestWriter != null) {
                        skippedTestWriter.write("<tr><td>" + object[1] + "</td> <td>" + iTestResult.getMethod().getMethodName() + "</td> <td>" + timeFormed + "</td></tr>");
                    }
                }
            }

            if (passedTestWriter != null) {
                passedTestWriter.write(HtmlUtil.endHtml);
            }
            if (failedTestWriter != null) {
                failedTestWriter.write(HtmlUtil.endHtml);
            }
            if (skippedTestWriter != null) {
                skippedTestWriter.write(HtmlUtil.endHtml);
            }


            if (passedTestWriter != null) {
                passedTestWriter.close();
            }
            if (failedTestWriter != null) {
                failedTestWriter.close();
            }
            if (skippedTestWriter != null) {
                skippedTestWriter.close();
            }

        }
    }
}
