package treinamentoINMSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestePortal {
	
	public static void main (String[] args) {
		
		//Instanciando o meu driver
		WebDriver driver = new ChromeDriver();
		
		//Abrindo o browser do googlechrome na tela de login do sistema
		driver.get("http://www.inmrobo.tk/accounts/login/");
		
		//Informando o usuário
		driver.findElement(By.name("username")).sendKeys("treinamentoINM");
		//Informando a senha
		driver.findElement(By.name("pass")).sendKeys("123456");
		//Clicando no botão enter
		driver.findElement(By.className("login100-form-btn")).click();
		
		
		
		//Clicar novo funcionario
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a")).click();
		
		
		//Preencher novo funcionario
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
		
		driver.quit();
	}

}
