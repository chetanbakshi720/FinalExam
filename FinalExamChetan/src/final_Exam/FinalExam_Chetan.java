package final_Exam;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FinalExam_Chetan {
   
	WebDriver driver = new ChromeDriver();



    ///////// 1 Launching Browser and and going to a website.
    
    @BeforeTest
    public void launchBrowser() throws InterruptedException {
        System.out.println("launching chrome browser");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe ");
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    
    
    
    ///////// 2 Entering the wrong login details to see does it work.
    
    @Test(priority = 1)
    public void LoginWithWrongusername() throws InterruptedException {
        driver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("Chetan");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("hetan123");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(2000);
    }
    
    
    
    //////// 3 Entering the right credentials login successful.
    
    @Test(priority = 2)
    public void LoginWithRightUsername() throws InterruptedException {
        driver.navigate().refresh();
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }




    ////////4 Sorting Items on price high to low.
    
    @Test(priority = 3)
    public void sorting() throws InterruptedException {
        driver.findElement(By.cssSelector("select[class='product_sort_container']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//option[contains(text(),'Price (high to low)')]")).click();
        Thread.sleep(2000);

    }
    
    
    
    //////// 5 Adding items to the inventory.
    
    @Test(priority = 4)
    public void inventory() throws InterruptedException {

        Thread.sleep(1000);

        List < WebElement > products = driver.findElements(By.cssSelector("div.inventory_item_name"));
        System.out.println(products.size());


        for (int i = 0; i < products.size(); i++) {

            driver.findElements(By.cssSelector("button.btn_inventory")).get(i).click();
            Thread.sleep(1000);
        }
    }
    
    
    
    ///////// 6 clicking the cart.
    
    @Test(priority = 5)
    public void cart() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }
    
    
    
    //////// 7 Removing items to the inventory.
    
    @Test(priority = 6)
    public void removefromcart() throws InterruptedException {
        Thread.sleep(1000);
        String[] itemsNeeded = {
            "Sauce Labs Fleece Jacket"
        };
        Thread.sleep(2000);
        int j = 0;
        List < WebElement > products = driver.findElements(By.cssSelector("div.inventory_item_name"));

        for (int i = 0; i < products.size(); i++) {
            Thread.sleep(1000);
            WebElement name = products.get(i);
            String Name_text = name.getText();
            System.out.println(Name_text);
            //String formattedname = name.trim();
            List iteam = Arrays.asList(itemsNeeded);
            if (iteam.contains(Name_text)) {
                j++;
                Thread.sleep(2000);
                driver.findElements(By.xpath("//div[@class='item_pricebar']//button")).get(i).click();

                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
    }




    //////// 8 Going back and again proceeding with removed items of the inventory.
    
    @Test(priority = 7)
    public void goingback() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a.shopping_cart_link")).click();


    }




    //////// 9 Moving Forward with items in the inventory.

    @Test(priority = 8)
    public void checkout() throws InterruptedException {

        driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
        Thread.sleep(2000);

    }

    //////// 10 Checkout.

    @Test(priority = 9)
    public void checkout1() throws InterruptedException {

        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        Thread.sleep(2000);

    }


    //////// 11 Adding personal information/details.
    
    @Test(priority = 10)
    public void personaldetails() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("chetan");
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("bakshi");
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("H2m187");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        Thread.sleep(2000);
    }



    //////// 12 Checkout overview Finish.

    @Test(priority = 11)
    public void finalcheckout() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='finish']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
    }
    
    
    
    /////// 13 closing driver

    @AfterTest public void driverclose() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }

}