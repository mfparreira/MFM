package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenu extends BasePage {

    //Construtor do driver
    public TopMenu (WebDriver driver){
        super (driver);
    }

    //Configurando wait da pagina
    WebDriverWait espera = new WebDriverWait(driver, 40);

    //Elementos da tela
    WebElement paginaInicial = espera.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"aspnetForm\"]/div[3]/header/div/div[1]")));
    WebElement visualizarDebitos = espera.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"aspnetForm\"]/div[3]/header/div/ul[1]/li[1]")));
    WebElement negociarDebitos = espera.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"aspnetForm\"]/div[3]/header/div/ul[1]/li[2]")));
    WebElement acordosEmAndamento = espera.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"aspnetForm\"]/div[3]/header/div/ul[1]/li[3]")));
    WebElement pagamentos = espera.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"aspnetForm\"]/div[3]/header/div/ul[1]/li[4]/a")));

    WebElement sair = espera.until( ExpectedConditions.elementToBeClickable( By.id("ctl00_LinkButton1")));

    Actions act = new Actions( driver );

    public void acessarHome (){
        paginaInicial.click();
    }

    public void acessarDebitos (){
        visualizarDebitos.click();
    }

    public void acessarNegociacao (){
        negociarDebitos.click();
    }

    public void acessarAcordos (){
        acordosEmAndamento.click();
    }

    public void acessarPagamentos (){
        WebElement imprimirBoleto = espera.until( ExpectedConditions.elementToBeClickable( By.xpath( ("//*[@id=\"aspnetForm\"]/div[3]/header/div/ul[1]/li[4]/ul/li/a") ) ));
        act.dragAndDrop( pagamentos, imprimirBoleto ).build().perform();
    }

    public void realizarLogoff (){
        sair.click();
    }
}
