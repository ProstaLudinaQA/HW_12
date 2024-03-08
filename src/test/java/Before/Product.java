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
           Assert.assertEquals(detailsProductName=cartProductName, "Sauce Labs Backpack", "Назва продукту однакова");
           Assert.assertEquals(detailsProductPrice=cartProductPrice,"$29.99", "Ціна продукту однакова");

        }
        @Test
        public void backProduct(){
            driver.get("https://www.saucedemo.com/v1/inventory-item.html?id=4");
            driver.findElement(By.cssSelector("#inventory_item_container > div > button")).click();
            String HomePageProduct = driver.findElement(By.cssSelector("#inventory_filter_container > div")).getText();
            Assert.assertTrue(HomePageProduct.contains("Product"));
    }

    @Test
    public void TrashFolderNumber(){
        driver.get("https://www.saucedemo.com/v1/inventory.html");
        // Отримуємо інформацію про перший товар на сторінці
        String productTitle = driver.findElement(By.cssSelector("#item_4_title_link > div")).getText();
        String productPrice = driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(1) > div.pricebar > div")).getText();

        // Клікаємо на назву першого товару
        driver.findElement(By.cssSelector("#item_4_title_link > div")).click();

        // Очікуємо, що відкриється нова сторінка з одним товаром
        // Клацкаємо на кнопку "Додати до кошика"
        driver.findElement(By.cssSelector("#inventory_item_container > div > div > div > button")).click();

        // Перевірка, що на кнопці корзина з'явилася одиниця
        String cartItemCount = driver.findElement(By.cssSelector("#shopping_cart_container > a > span")).getText();
        Assert.assertEquals(cartItemCount, "1", "Кількість товарів у кошику відображається правильно" );



        // Додаткові дії та перевірки за необхідності
    }
    }





