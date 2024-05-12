package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Set;

public class HomePage extends BasePage{
    String URLpage ="http://www.croper.com/";
    private carouselItems items;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver.get(URLpage);
    }

    @FindBy(css = "span[class='hidden w-full md:block'] span[class*='break-all']")
    private WebElement searchinput;

    @FindBy (css = "input[id*='cp-input-']")
    private WebElement search;

    public ResultPage loadFirstPage() {
        System.out.println("prueba numero 1 busqueda de 'fitrol de aceite'");
        this.clickOnElement(searchinput);
        this.clickOnElement(search);
        this.sendKeysOnElement(search, "filtro de aceite");
        this.clickOnEnter(search);
        return new ResultPage(driver);
    }


    @FindBy(xpath = "/html/body/cp-root/cp-layout/cp-header/header/div[1]/div[1]/a")
    private WebElement logo;


    public void itemsCarousel(){
        System.out.println("prueba numero 3 interactuar algunas cards");

            this.items = new carouselItems(this.driver);
           String[] list = {"Insumo", "Producto", "stores", "login", "banks", "offers"};
            for (int i=1;i<7;i++){
                waitToBeVisible(items.Items(i));
                WebElement item= items.Items(i);
                this.clickOnElement(item);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(driver.getCurrentUrl());
                if (driver.getCurrentUrl().contains(list[i-1])){
                    System.out.println( "el elemento tiene el nombre "+list[i-1]);
                }else {
                    System.out.println( "no se encontro ningun elemento");
                }
                this.clickOnElement(logo);
            }

    }


    @FindBy(xpath = "//*[@id=\"cp-popover-0\"]/div[2]/div/button[2]")
    private WebElement cerrarButton;

    @FindBy(xpath = "//span[contains(.,' Fertilizantes y enmiendas ')]")
    private WebElement Item;

    @FindBy(xpath = "//a[contains(.,' Reguladores de crecimiento ')]")
    private WebElement Item2;

    @FindBy(xpath = "/html/body/cp-root/cp-layout/cp-header/header/div[2]/cp-menu/ul/li[5]/button")
    private WebElement buttonCredito;

    @FindBy(xpath = "//*[@id=\"cp-popover-1\"]/div[2]/ul/li[1]/a")
    private WebElement buttonCredito2;

    @FindBy(className="menu-item")
    private List<WebElement> lista;

    public void menuItemsCheck(){
        Actions action = new Actions(this.driver);
        System.out.println("prueba numero 2 la barra de navegación");
        String[] list = {"category", "offers", "stores", "tuprimero", "login","packages","auth","login","login"};
        int cont = 0;
        waitToBeVisible(cerrarButton);
        clickOnElement(cerrarButton);
        System.out.println("se ha dado click en el boton credito");
        this.clickOnElement(buttonCredito);
        this.waitToBeVisible(buttonCredito2);
        this.clickOnElement(buttonCredito2);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(driver.getCurrentUrl());
        for(WebElement i : lista){
            System.out.println("se ha dado click en el boton "+i.getText());

            if (!i.getText().toLowerCase().contains("categorías")&& !i.getText().toLowerCase().contains("noticias")){
                this.waitToBeClickable(i);
                this.clickOnElement(i);

                if ((i.getText().contains("Listas de productos")) || (i.getText().contains("Vender")) || (i.getText().contains("Gestión"))){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    action.sendKeys(Keys.ESCAPE).perform();
                }else{
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(driver.getCurrentUrl());
                if (driver.getCurrentUrl().contains(list[cont])){
                    System.out.println( "el elemento tiene el nombre "+list[cont]);
                    cont++;
                }else {
                    System.out.println( "no se encontro ningun elemento");
                    cont++;
                }
            }else if(i.getText().toLowerCase().contains("categorías")){
                this.clickOnElement(i);
                this.waitToBeVisible(Item);
                this.clickOnElement(Item);

                this.waitToBeVisible(Item2);
                this.waitToBeClickable(Item2);
                js.executeScript("arguments[0].click();", Item2);
                this.clickOnElement(Item2);
                System.out.println(driver.getCurrentUrl());
                driver.findElement(By.cssSelector("cp-icon[name='croper-logo']")).click();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println( "el elemento tiene el nombre "+driver.getCurrentUrl().contains("category"));
                cont++;

            }else{
                this.clickOnElement(i);
                String mainTab = driver.getWindowHandle();
                Set<String> handles = driver.getWindowHandles();
                for (String t: handles){
                    if (!t.equalsIgnoreCase(mainTab)){
                        driver.switchTo().window(t);
                        System.out.println("Se ha abierto una nueva pestaña.");
                    }
                }
            }
            System.out.println("");
        }
    }
}
