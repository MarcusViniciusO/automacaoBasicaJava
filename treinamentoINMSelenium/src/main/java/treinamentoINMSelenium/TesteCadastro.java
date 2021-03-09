package treinamentoINMSelenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TesteCadastro {
	
	private WebDriver driver;
	private DomainSpecificLanguage dsl;
	
	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.get("http://www.inmrobo.tk/accounts/login/");
		dsl = new DomainSpecificLanguage(driver);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void deveValidarLoginComSucesso() {
		
		dsl.escreverByName("username", "treinamentoINM");
		//driver.findElement(By.name("username")).sendKeys("treinamentoINM");
		driver.findElement(By.name("pass")).sendKeys("123456");
		driver.findElement(By.className("login100-form-btn")).click();
		
		Assert.assertEquals("NOVO FUNCIONÁRIO", driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a")).getText());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void deveValidarLoginSemSucesso() {
	
		driver.findElement(By.name("username")).sendKeys("treinamentoINM");
		driver.findElement(By.name("pass")).sendKeys("123455");
		driver.findElement(By.className("login100-form-btn")).click();
		
		Assert.assertTrue(driver.findElement(By.className("alert-danger")).getText().contains("ERRO! Usuário ou Senha inválidos"));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void deveValidarCadastroFuncionarioComSucesso() {
			
				driver.findElement(By.name("username")).sendKeys("treinamentoINM");
				driver.findElement(By.name("pass")).sendKeys("123456");
				driver.findElement(By.className("login100-form-btn")).click();
				
				driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a")).click();
				
				driver.findElement(By.id("inputNome")).sendKeys("Marcelo" + 1 + (int)(Math.random() * 100000) + "Souza");
				driver.findElement(By.id("cpf")).sendKeys("550.816.480-43");
				
				WebElement elemento = driver.findElement(By.id("slctSexo"));
				Select combo = new Select(elemento);
				combo.selectByVisibleText("Masculino");
				
				driver.findElement(By.id("inputAdmissao")).sendKeys("08-03-2021");
				driver.findElement(By.id("inputCargo")).sendKeys("Automatizador JR");
				driver.findElement(By.id("dinheiro")).sendKeys("3.000,00");
				
				driver.findElement(By.id("clt")).click();
				
				driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[3]/input")).click();
				
				Assert.assertTrue(driver.findElement(By.className("alert-success")).getText().contains("SUCESSO! Usuário cadastrado com sucesso"));
				
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	

}
