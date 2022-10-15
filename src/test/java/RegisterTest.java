import entities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageRegister;
import java.util.ArrayList;

public class RegisterTest extends BaseTest {
    @Test
    public void shouldRegisterPerson() {
        PageRegister page = new PageRegister(getDriver());

        String result = page.fillProductName("Macarrao")
                .selectCategory("Alimentos")
                .selectChannel("E-Commerce")
                .selectChannel("Loja Física")
                .fillMinStock("3")
                .fillMaxStock("10")
                .selectImmediateSale(true)
                .selectSaleForm("unidade")
                .selectSaleForm("pacote")
                .register()
                .getResultText();

        Assert.assertTrue(result.contains("Cadastrado!"));
        Assert.assertTrue(result.contains("Nome: Macarrao"));
        Assert.assertTrue(result.contains("Categoria: alimento"));
        Assert.assertTrue(result.contains("Canais de Venda: E-Commerce Loja Física"));
        Assert.assertTrue(result.contains("Estoque Minimo: 3"));
        Assert.assertTrue(result.contains("Estoque Máximo: 10"));
        Assert.assertTrue(result.contains("Disponibilizar para venda imediata?: sim"));
        Assert.assertTrue(result.contains("Formas de Venda: Unidade Pacote"));
    }

    @Test
    public void shouldValidateLinks() {
        PageRegister page = new PageRegister(getDriver());

        Assert.assertEquals(page.clickGoogleLink(), "Google");

        Assert.assertEquals(page.clickGauchaLink(), "empresas: Últimas Notícias | GZH");
    }
}
