package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoletoPage extends BasePage {

    public BoletoPage (WebDriver driver){
        super (driver);
    }

    WebDriverWait espera = new WebDriverWait(driver, 10);

    //mapear os elementos da pagina
    WebElement btnExibir2 = espera.until( ExpectedConditions.elementToBeClickable( By.xpath( "//*[@id=\"ctl00_ContentPlaceHolder1_repAcordo_ctl00_repDetalheAcordos_ctl00_visualizarBoleto\"]" )));


    public void gravarBoleto() throws InterruptedException {

        btnExibir2.click();


        WebElement btnSalvarBoleto = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_btnGerarDPdf\"]")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", btnSalvarBoleto);
        Thread.sleep( 10000 );

    }


    public void enviarBoleto(String email) {
        btnExibir2.click();
        WebElement preencherEmail = espera.until(ExpectedConditions.elementToBeClickable(By.xpath( "//*[@id=\"ctl00_ContentPlaceHolder1_txtEmail\"]")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", preencherEmail);

        WebElement btnEnviarEmail = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_btnEnviarBoletoEmail\"]")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", btnEnviarEmail);
    }


   public void copiarLinhaDigitavel () throws InterruptedException {
       btnExibir2.click();
       WebElement linhaDigitavel = espera.until(ExpectedConditions.elementToBeClickable(By.id( "btnCopiarLinhaDigitavel")));
       ((JavascriptExecutor)driver).executeScript("arguments[0].click()", linhaDigitavel);

        }
   }
