package treinamentoINMSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DomainSpecificLanguage {
	
	private WebDriver driver;
	
	public DomainSpecificLanguage (WebDriver driver){
		this.driver = driver;
	}
	
	public void escreverByName (String nameCampo, String texto) {
		driver.findElement(By.name(nameCampo)).sendKeys(texto);
	}
	
	public void escreverByid (String idCampo, String texto) {
		driver.findElement(By.name(idCampo)).sendKeys(texto);
	}

}
