package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class PageRegister extends BasePage {
    @FindBy(id="txt01")
    private WebElement textProductName;

    @FindBy(id="categoria")
    private WebElement selectProductCategory;

    @FindBy(id="venda")
    private WebElement selectSellChannel;

    @FindBy(id="txt02")
    private WebElement numberMinimumStock;

    @FindBy(id="txt03")
    private WebElement numberMaximumStock;

    @FindBy(id="sim")
    private WebElement radioImmediateSaleYes;

    @FindBy(id="nao")
    private WebElement radioImmediateSaleNo;

    @FindBy(id="unidade")
    private WebElement checkboxSaleFormUnity;

    @FindBy(id="caixa")
    private WebElement checkboxSaleFormBox;

    @FindBy(id="pacote")
    private WebElement checkboxSaleFormPackage;

    @FindBy(id="duzia")
    private WebElement checkboxSaleFormDozen;

    @FindBy(partialLinkText="google")
    private WebElement linkGoogle;

    @FindBy(partialLinkText="GZH Empresas")
    private WebElement linkGaucha;

    @FindBy(id="elementosForm:cadastrar")
    private WebElement buttonRegister;

    @FindBy(id="resultado")
    private WebElement result;

    public PageRegister(WebDriver driver) {
        super(driver);
    }

    public PageRegister fillProductName(String productName) {
        textProductName.sendKeys(productName);

        return this;
    }

    public PageRegister selectCategory(String productCategory) {
        Select categories = new Select(selectProductCategory);

        categories.selectByVisibleText(productCategory);

        return this;
    }

    public PageRegister selectChannel(String sellChannel) {
        Select channels = new Select(selectSellChannel);

        channels.selectByVisibleText(sellChannel);

        return this;
    }

    public PageRegister fillMinStock(String minStock) {
        numberMinimumStock.sendKeys(minStock);

        return this;
    }

    public PageRegister fillMaxStock(String maxStock) {
        numberMaximumStock.sendKeys(maxStock);

        return this;
    }

    public  PageRegister selectImmediateSale(boolean yes) {
        if (yes) {
            radioImmediateSaleYes.click();
        } else {
            radioImmediateSaleNo.click();
        }

        return this;
    }

    public PageRegister selectSaleForm(String saleForm){
        switch (saleForm){
            case "unidade":
                checkboxSaleFormUnity.click();
                break;
            case "caixa":
                checkboxSaleFormBox.click();
                break;
            case "pacote":
                checkboxSaleFormPackage.click();
                break;
            case "duzia":
                checkboxSaleFormDozen.click();
        }

        return this;
    }

    public String clickGoogleLink(){
        linkGoogle.click();

        String title = driver.getTitle();

        driver.navigate().back();

        return title;
    }

    public String clickGauchaLink(){
        linkGaucha.click();

        String title = driver.getTitle();

        driver.navigate().back();

        return title;
    }

    public PageRegister register() {
        buttonRegister.click();

        return this;
    }

    public String getResultText() {
        return result.getText();
    }
}
