package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VisualizarDebitosPage extends BasePage {

    public VisualizarDebitosPage(WebDriver driver){
        super (driver);
    }

    WebDriverWait espera = new WebDriverWait(driver, 10);

    WebElement btnDetalhes = espera.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"but_collapse-2151785\"]")));


    public void detalhesDebitos(){

        btnDetalhes.click();
    }



}
