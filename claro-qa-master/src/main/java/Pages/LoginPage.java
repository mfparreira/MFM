package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage  extends BasePage {
    public LoginPage(WebDriver  driver) {
        super(driver);
    }

    //Configurando wait da pagina
    WebDriverWait espera = new WebDriverWait(driver, 40);

    //Mapear elementos da pagina
    //WebElement botaoCPF = espera.until( ExpectedConditions.elementToBeClickable( By.id("rbCpf")));
    WebElement botaoCNPJ = driver.findElement( By.className("rbCnpj"));
    WebElement campoCPF = espera.until( ExpectedConditions.elementToBeClickable( By.id("txtCPFUsuario")));
    WebElement botaoEntrar = espera.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"form1\"]/div[3]/div[5]/button")));


    //Realizar ações
    public void realizarLoginCPF(String cpf) throws InterruptedException {

        campoCPF.click();
        campoCPF.sendKeys( cpf );
        Thread.sleep( 2000 );

        botaoEntrar.click();

    }

    public void realizarLoginCNPJ(String cnpj) throws InterruptedException {

        botaoCNPJ.click();

        campoCPF.click();
        campoCPF.sendKeys( cnpj );
        botaoEntrar.click();

    }


}
