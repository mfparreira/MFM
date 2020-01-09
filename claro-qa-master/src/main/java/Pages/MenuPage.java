package Pages;

import cucumber.api.java.da.Men;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage extends BasePage {

    public MenuPage (WebDriver driver){
        super (driver);
    }

    //Configurando wait da pagina
    WebDriverWait espera = new WebDriverWait(driver, 40);


    //Mapear elementos da tela
    WebElement btnVisualizarDebitos = espera.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"UpdatePanel1\"]/div[1]/div/div/div/div[1]/a")));
    WebElement btnNegociarDebitos = espera.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"UpdatePanel1\"]/div[1]/div/div/div/div[2]/a")));
    WebElement btnAcordosEmAndamento = espera.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"UpdatePanel1\"]/div[1]/div/div/div/div[3]/a")));
    WebElement btnPagamentoBoletoBancario = espera.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"UpdatePanel1\"]/div[1]/div/div/div/a")));


    public void AcessarVisualizarDebitos (){
        btnVisualizarDebitos.click();
    }

    public void AcessarNegociarDebitos (){
        btnNegociarDebitos.click();
    }

    public void AcessarACordosEmAndamento (){
        btnAcordosEmAndamento.click();
    }

    public void AcessarPagamentoBoleto (){
        btnPagamentoBoletoBancario.click();
    }








}
