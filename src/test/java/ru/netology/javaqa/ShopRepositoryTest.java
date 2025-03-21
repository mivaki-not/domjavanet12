package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

@Test
    public void testSuccessfulDletion(){
    ShopRepository repo =  new ShopRepository();
    Product product1 = new Product(1, "сумка", 55_000);
    Product product2 = new Product(2, "кошелек", 15_000);
    Product product3 = new Product(3, "ремень", 5_000);

    repo.add(product1);
    repo.add(product2);
    repo.add(product3);

    repo.remove(2);

    Product[] actual = repo.findAll();
    Product[] expected = {product1, product3};

    Assertions.assertArrayEquals(expected, actual);
}

    @Test
    public void testSuccessfulDletionError(){
        ShopRepository repo =  new ShopRepository();
        Product product1 = new Product(1, "сумка", 55_000);
        Product product2 = new Product(2, "кошелек", 15_000);
        Product product3 = new Product(3, "ремень", 5_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(21331));
    }

}