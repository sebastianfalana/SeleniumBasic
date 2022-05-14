package ch1_TestNg;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MySecondTest {

    public int multiply(int a, int b) {
        return 4;
    }

    public int add(int a, int b) {
        return a + b;
    }

    @Test
    public void shouldAdd(){
        Assert.assertEquals(add(2,3),5);
    }

    @Test
    public void shouldMultiply(){
        Assert.assertEquals(multiply(2,3),6);
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Run BEFORE each test");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Run AFTER each test");
    }

}
