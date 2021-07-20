package br.com.cesar.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class testes {
	
	@Test
	public void testDiscourse(){
		String url = "https://www.discourse.org/";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'Demo')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
		List<String> abas = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(1));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 5000)");		
		
		
		String topico2 = driver.findElement(By.xpath("//a[contains(text(),'Totally amped about the 80s')]")).getText();
		System.out.print("Tópico fechado: " + topico2 + "\n");
		js.executeScript("window.scrollTo(0, 5000)");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String topico1 = driver.findElement(By.xpath("//a[contains(text(),'Do microwave ovens kill bacteria?')]")).getText();
		System.out.print("Tópico fechado: " + topico1 + "\n");
		js.executeScript("window.scrollTo(0, -250)");		

		driver.findElement(By.cssSelector("body.navigation-topics:nth-child(2) section.ember-application:nth-child(3) div.ember-view div.wrap:nth-child(2) div.list-controls:nth-child(4) div.container section.navigation-container.ember-view ul.nav.nav-pills.ember-view li.ember-view:nth-child(3) > a:nth-child(1)")).click();
		
		List<WebElement> list = driver.findElements(By.className("categories-and-latest ember-view"));

		for (int i = 0; i < list.size(); i++) {
		    System.out.println(list.get(i).getText() + "\n");
		}
		driver.findElement(By.id("site-text-logo")).click();
		driver.findElement(By.xpath("//th[contains(text(),'Views')]")).click();
		String mostView = driver.findElement(By.cssSelector("body.navigation-topics:nth-child(2) section.ember-application:nth-child(3) div.ember-view div.wrap:nth-child(2) div.container.list-container:nth-child(7) div.row:nth-child(2) div.full-width div.contents.ember-view table.topic-list.ember-view:nth-child(2) tbody:nth-child(2) tr.topic-list-item.category-movies.ember-view:nth-child(1) td.main-link.clearfix:nth-child(1) span.link-top-line > a.title.raw-link.raw-topic-link")).getText();
		System.out.println( "\nMost views: " + mostView );
		
		driver.quit();
	}
	
	@Test
	public void testCesar(){
		String url = "https://www.cesar.school/";
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'Aceitar Cookies')]")).click();

		WebElement menu = driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/nav[1]/div[1]/ul[1]/li[2]/a[1]/span[4]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();   
		driver.findElement(By.xpath("//span[contains(text(),'Blog')]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 9000)");

		driver.findElement(By.xpath("//body/div[@id='page']/div[@id='content']/div[1]/div[1]/div[1]/nav[1]/div[1]/a[3]")).click();
		
		String tituloSegundaPublic = driver.findElement(By.xpath("//a[contains(text(),'Turma de T2i da School promove Arraial Solidário p')]")).getText();
		String mesSegundaPublic = driver.findElement(By.className("date-month")).getText();
		String diaSegundaPublic = driver.findElement(By.className("date-day")).getText();
		String anoSegundaPublic = driver.findElement(By.className("date-year")).getText();
		System.out.println("Título: " + tituloSegundaPublic + "\nData: " + diaSegundaPublic+"/"+mesSegundaPublic+"/"+anoSegundaPublic+";\n");
		
		String tituloTerceiraPublic = driver.findElement(By.xpath("//a[contains(text(),'Colaboradora do CESAR conquista prêmio nacional de')]")).getText();
		String autorTerceiraPublic = driver.findElement(By.className("entry-meta")).getText();
		System.out.println("Título: " + tituloTerceiraPublic + "\nAutor: " + autorTerceiraPublic + ";\n");
		
		js.executeScript("window.scrollTo(0, 15000)");
		String enderecoCesar = driver.findElement(By.xpath("//p[contains(text(),'Rua Bione, Cais do Apolo, 220, Recife - PE, 50030-')]")).getText();
		System.out.println("Endereço: " + enderecoCesar);
		
		driver.quit();
	}	
}
