package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GerenciarDetalhesPage extends BasePage {

    public GerenciarDetalhesPage (WebDriver driver) {
        super (driver);
    }

    WebDriverWait espera = new WebDriverWait(driver, 20);

     WebElement btnNegociar = espera.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_rptResumoNegociao_ctl00_repDetalheNegociacao_ctl00_buttonNegociar\"]")));


     public void negociarDivida(){
     btnNegociar.click();

         WebElement btnConfirmarData = espera.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_btnConfirmarcao\"]")));
         ((JavascriptExecutor)driver).executeScript("arguments[0].click()", btnConfirmarData);
         WebElement btnConfirmaAcordo = espera.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_btnConfirmarcao\"]")));
         ((JavascriptExecutor)driver).executeScript("arguments[0].click()", btnConfirmaAcordo);
         WebElement campoInserirEmail = espera.until( ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_txtEmailConfirmar\"]")));
         ((JavascriptExecutor)driver).executeScript("arguments[0].click()", campoInserirEmail);
         campoInserirEmail.sendKeys( "marcelo.francoparreira@gmail.com" );


         WebElement btnConfirmarEmail =  espera.until( ExpectedConditions.elementToBeClickable(By.xpath( "//*[@id=\"ctl00_ContentPlaceHolder1_btnConfirmarcao\"]")));
         ((JavascriptExecutor)driver).executeScript("arguments[0].click()", btnConfirmarEmail);
         WebElement btnSelecionarFormaPagamento =  espera.until( ExpectedConditions.elementToBeClickable(By.xpath( "//*[@id=\"ctl00_ContentPlaceHolder1_rdbBoleto\"]")));
         ((JavascriptExecutor)driver).executeScript("arguments[0].click()", btnSelecionarFormaPagamento);

         WebElement btnConfirmaFormaPagamento =  espera.until( ExpectedConditions.elementToBeClickable(By.xpath( "//*[@id=\"ctl00_ContentPlaceHolder1_btnConfirmarcao\"]")));
         ((JavascriptExecutor)driver).executeScript("arguments[0].click()", btnConfirmaFormaPagamento);
         WebElement btnConfirma =  espera.until( ExpectedConditions.elementToBeClickable(By.id( "ctl00_ContentPlaceHolder1_btnConfirmarcao")));
         ((JavascriptExecutor)driver).executeScript("arguments[0].click()", btnConfirma);




     }
}
