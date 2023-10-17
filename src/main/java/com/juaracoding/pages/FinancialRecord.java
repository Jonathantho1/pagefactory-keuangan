package com.juaracoding.pages;

import com.juaracoding.Main;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class FinancialRecord {

    public AndroidDriver<MobileElement> driver;

    public FinancialRecord(AndroidDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.chad.financialrecord:id/btnIncome")
    public MobileElement pemasukanBtn;
    @AndroidFindBy(id = "com.chad.financialrecord:id/fabMenu")
    public MobileElement add;
    @AndroidFindBy(id = "com.chad.financialrecord:id/tvDate")
    public MobileElement tanggal;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"17 Oktober 2023\"]")
    public MobileElement tanggalPengeluaran;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"19 Oktober 2023\"]")
    public MobileElement tanggalPemasukan;
    @AndroidFindBy(id = "android:id/button1")
    public MobileElement tanggalButton;
    @AndroidFindBy(id = "com.chad.financialrecord:id/tvName")
    public MobileElement kategori;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout")
    public MobileElement kategoriPengeluaran;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[10]/android.widget.LinearLayout/android.widget.TextView")
    public MobileElement kategoriPemasukan;
    @AndroidFindBy(id = "com.chad.financialrecord:id/etAmount")
    public MobileElement jumlah;
    @AndroidFindBy(id = "com.chad.financialrecord:id/etNote")
    public MobileElement keterangan;
    @AndroidFindBy(id = "com.chad.financialrecord:id/btSave")
    public MobileElement simpan;
    @AndroidFindBy(id = "com.chad.financialrecord:id/tvBalance")
    public MobileElement saldo;

    public void pengeluaran(String jumlah,String keterangan){
        add.click();
        tanggal.click();
        tanggalPengeluaran.click();
        tanggalButton.click();
        kategori.click();
        kategoriPengeluaran.click();
        this.jumlah.sendKeys(jumlah);
        this.keterangan.sendKeys(keterangan);
        simpan.click();
    }

    public void pemasukan(String jumlah,String keterangan){
        add.click();
        pemasukanBtn.click();
        tanggal.click();
        tanggalPemasukan.click();
        tanggalButton.click();
        kategori.click();
        kategoriPemasukan.click();
        this.jumlah.sendKeys(jumlah);
        this.keterangan.sendKeys(keterangan);
        simpan.click();
    }

    public String getTxtSaldo(){
        return saldo.getText();
    }





}
