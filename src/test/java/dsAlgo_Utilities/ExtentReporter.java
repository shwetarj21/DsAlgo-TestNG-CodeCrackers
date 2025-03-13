package dsAlgo_Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

    private static ExtentReports extent;

    public static ExtentReports getExtentReport() {
        if (extent == null) {
            synchronized (ExtentReporter.class) {
                if (extent == null) {
                    String reportPath = System.getProperty("user.dir") + "/target/extent-reports/ExtentReport.html";
                    ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
                    reporter.config().setReportName("Test Execution Report");
                    reporter.config().setDocumentTitle("Test Results");

                    extent = new ExtentReports();
                    extent.attachReporter(reporter);
                    extent.setSystemInfo("Tester", "QA Team");
                    extent.setSystemInfo("OS", System.getProperty("os.name"));
                }
            }
        }
        return extent;
    }
}
