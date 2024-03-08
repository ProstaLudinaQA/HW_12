package Before;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Product extends Ttest  {



    @BeforeClass
    public void ProductCSS() {
        driver.get("https://www.saucedemo.com/v1/inventory.html");
        System.out.println("ProductCSS");
    }
        @Test
        public void testSaveProduct() {
            // Клік на продукт
            driver.findElement(By.cssSelector("#item_4_title_link > div")).click();

            // Додавання продукту до кошика
            driver.findElement(By.cssSelector("#inventory_item_container > div > div > div > button")).click();

            // Отримання тексту про продукт
            String cartProductName = driver.findElement(By.cssSelector("#inventory_item_container > div > div > div > div.inventory_details_name")).getText();
            String cartProductPrice = driver.findElement(By.cssSelector("#inventory_item_container > div > div > div > div.inventory_details_price")).getText();

            // Перехід до кошика
            driver.findElement(By.cssSelector("#shopping_cart_container > a > svg > path")).click();

            // Отримання тексту про продукт у кошику
            String detailsProductName = driver.findElement(By.cssSelector("#item_4_title_link > div")).getText();
            String detailsProductPrice = driver.findElement(By.cssSelector("#cart_contents_container > div > div.cart_list > div.cart_item > div.cart_item_label > div.item_pricebar > div")).getText();

            // Порівняння текстів
           Assert.assertEquals("Назва продукту  збігається", detailsProductName, cartProductName);
           Assert.assertEquals("Ціна продукту збігається", detailsProductPrice, cartProductPrice);
        }
        @Test
        public void backProduct(){
            driver.get("https://www.saucedemo.com/v1/inventory-item.html?id=4");
            driver.findElement(By.cssSelector("#inventory_item_container > div > button")).click();
            String HomePageProduct = driver.findElement(By.cssSelector("#inventory_filter_container > div")).getText();
            Assert.assertTrue(HomePageProduct.contains("Product"));
    }

    @Test
    public void BasketNumber(){

    }

}



