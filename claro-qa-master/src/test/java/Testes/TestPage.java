
package Testes;


import Pages.*;
import Suporte.ConexaoDB;
import Suporte.Web;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class TestPage  {
    private WebDriver driver;

    ConexaoDB con = new ConexaoDB();
    String LoginComDividaCPF = con.aux ;

    String LoginComACordo = "00357782592";
    String LoginInválido = "123";
    String LoginComDividaCNPJ = "73681881715";


    public static String getClipboardContents() {
        String result = "";
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // odd: the Object param of getContents is not currently used
        Transferable contents = clipboard.getContents( null );
        boolean hasTransferableText = (contents != null)
                && contents.isDataFlavorSupported( DataFlavor.stringFlavor );
        if (hasTransferableText) {
            try {
                result = (String) contents
                        .getTransferData( DataFlavor.stringFlavor );
            } catch (UnsupportedFlavorException | IOException ex) {
                System.out.println( ex );
                ex.printStackTrace();
            }
        }
        return result;
    }


    @Before
    public void setUp() {
        driver = Web.createChrome();


    }



    @After
    public void TearDown(){
        driver.quit();

    }





        //Testes de login


        @Test
        public void realizarLoginPositivoCPF() throws InterruptedException {


            new LoginPage( driver )
                    .realizarLoginCPF( LoginComDividaCPF );

            String aux = driver.findElement( By.id( "LinkButton1" ) ).getText();
            String comparaPositivo = "Sair";
            assertEquals( aux,comparaPositivo );

            }

        //@Test
        public void realizarLoginPositivoCNPJ() throws InterruptedException {

            new LoginPage( driver )
                    .realizarLoginCNPJ( LoginComDividaCPF );
            String aux = driver.findElement( By.id( "ctl00_LinkButton1" ) ).getText();
            String comparaPositivo = "Sair";
            assertEquals( aux,comparaPositivo );

        }

        @Test
        public void realizarLoginNegativoCPF()throws InterruptedException {


            new LoginPage( driver )
                    .realizarLoginCPF( LoginInválido );

            String aux = driver.findElement( By.id( "lblMensagem" ) ).getText();
            String comparaNegativo = "Cliente não localizado ou não existe débito em aberto!";
            assertEquals( aux,comparaNegativo );

            }


        //Teste de criação de acordo

        @Test
        public void GravarAcordo() throws InterruptedException {



            new LoginPage( driver )
                    .realizarLoginCPF( LoginComDividaCPF );
            new MenuPage( driver )
                    .AcessarNegociarDebitos();
            new VisualizarDebitosPage( driver )
                    .detalhesDebitos();
            new GerenciarDetalhesPage( driver )
                    .negociarDivida();
            Thread.sleep( 5000 );

        }

        @Test
        public void ConsultarAcordo() throws InterruptedException {
            new LoginPage( driver )
                    .realizarLoginCPF( LoginComACordo );
            new MenuPage( driver )
                    .AcessarACordosEmAndamento();
            new AcordoDetalhesPage( driver )
                    .ValidarAcordo();

        }

        //Testes de boleto

        @Test
        public void Enviarboleto() throws InterruptedException {
            new LoginPage( driver )
                    .realizarLoginCPF( LoginComDividaCPF );
            new MenuPage( driver )
                    .AcessarPagamentoBoleto();
            new BoletoPage( driver )
                    .enviarBoleto( "marcelo.parreira@mfmti.com.br" );
        }


        @Test
        public void GerarBoleto() throws InterruptedException {
            new LoginPage( driver )
                    .realizarLoginCPF( LoginComACordo );
            new MenuPage( driver )
                    .AcessarPagamentoBoleto();
            new BoletoPage( driver )
                    .gravarBoleto();
        }

        @Test
        public void validarLinhaDigitavel() throws InterruptedException  {
            new LoginPage( driver )
                    .realizarLoginCPF( LoginComACordo );
            new MenuPage( driver )
                    .AcessarPagamentoBoleto();
            new BoletoPage( driver )
                    .copiarLinhaDigitavel();
            WebElement aux = driver.findElement( By.id( "btnCopiarLinhaDigitavel" ));
            aux.click();
            String copia = getClipboardContents();
            assertEquals( copia.length(), 58 );

        }


        //Teste de logoff

        @Test
        public void RealizarLogoff() throws InterruptedException {
            new LoginPage( driver )
                    .realizarLoginCPF( LoginComACordo );

            new TopMenu( driver )
                    .realizarLogoff();
        }





    }







