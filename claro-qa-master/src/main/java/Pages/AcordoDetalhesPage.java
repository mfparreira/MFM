package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcordoDetalhesPage extends BasePage {

    public AcordoDetalhesPage (WebDriver driver){
        super (driver);
    }

    WebDriverWait espera = new WebDriverWait(driver, 40);

    //Mapear elementos da tela
    WebElement btnMais = espera.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_repAcordos_ctl00_Li4\"]/a/div")));



    public void ValidarAcordo(){

        btnMais.click();



    }




}
