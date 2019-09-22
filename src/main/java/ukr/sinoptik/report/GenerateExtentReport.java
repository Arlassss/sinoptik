package ukr.sinoptik.report;


import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

public class GenerateExtentReport {
    private static volatile ExtentReports extentReports;

    private GenerateExtentReport() {
    }

    public static ExtentReports getReportInstance(String fullFileName) {
        if (extentReports == null) {
            synchronized (GenerateExtentReport.class) {
                if (extentReports == null) {

                    extentReports = new ExtentReports(System.getProperty("user.dir") + "/extentTest-output/Report_" + fullFileName + ".html", true);
                    extentReports.addSystemInfo("Environment", "QA");
                    extentReports.loadConfig(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\extendReport\\extendReport-config.xml"));
                }
            }
        }
        return extentReports;
    }
}
