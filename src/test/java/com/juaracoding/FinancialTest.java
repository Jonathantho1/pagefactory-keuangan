package com.juaracoding;

import com.juaracoding.pages.FinancialRecord;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FinancialTest {

    private static AndroidDriver<MobileElement> driver;
    private FinancialRecord financialRecord;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired Capabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","Pixel 2 API 30");
        desiredCapabilities.setCapability("UUID","emulator-5554");
        desiredCapabilities.setCapability("platformName","android");
        desiredCapabilities.setCapability("appPackage","com.chad.financialrecord");
        desiredCapabilities.setCapability("appActivity","com.rookie.catatankeuangan.feature.splash.SplashActivity");
        desiredCapabilities.setCapability("noReset",true);

        //URL
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        //instance Android Driver
        driver = new AndroidDriver(url,desiredCapabilities);
    }

    @BeforeMethod
    public void pageObject(){
        financialRecord = new FinancialRecord(driver);
    }

    @Test(priority = 1)
    public void pengeluaran(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        financialRecord.pengeluaran("25000000000","BMW");
        System.out.println("Saldo Sekarang: "+financialRecord.getTxtSaldo());
        Assert.assertEquals(financialRecord.getTxtSaldo(),"-25.000.000.000");
    }

    @Test(priority = 2)
    public void pemasukan(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        financialRecord.pemasukan("30000000000","BMW Sold");
        System.out.println("Saldo Sekarang: "+financialRecord.getTxtSaldo());
        Assert.assertEquals(financialRecord.getTxtSaldo(),"5.000.000.000");
    }

    @AfterClass
    public void finish(){
        driver.quit();
    }
}
