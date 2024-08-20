package com.reader.scanner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rfconsole")
public class DummyRFConsoleController {

    private static final Map<String, Map<String, String>> productDatabase = new HashMap<>();

    static {
        Map<String, String> product1 = new HashMap<>();
        product1.put("name", "Product A");
        product1.put("price", "10.99");
        product1.put("weight", "2.5");
        product1.put("rfid", "74562547558");
        product1.put("productId", "001"); // Ensure productId is included
        productDatabase.put("74562547558", product1);

        Map<String, String> product2 = new HashMap<>();
        product2.put("name", "Product B");
        product2.put("price", "5.99");
        product2.put("weight", "1.0");
        product2.put("rfid", "12345678901");
        product2.put("productId", "002"); // Ensure productId is included
        productDatabase.put("12345678901", product2);

        Map<String, String> product3 = new HashMap<>();
        product3.put("name", "Product C");
        product3.put("price", "7.50");
        product3.put("barcode", "98765432100");
        productDatabase.put("98765432100", product3);

        Map<String, String> product4 = new HashMap<>();
        product4.put("name", "Product D");
        product4.put("price", "12.99");
        product4.put("barcode", "11223344556");
        productDatabase.put("11223344556", product4);

        Map<String, String> product5 = new HashMap<>();
        product5.put("name", "Product E");
        product5.put("price", "3.49");
        product5.put("barcode", "66778899000");
        productDatabase.put("66778899000", product5);

        Map<String, String> product6 = new HashMap<>();
        product6.put("name", "Product F");
        product6.put("price", "8.25");
        product6.put("barcode", "33445566778");
        productDatabase.put("33445566778", product6);

        Map<String, String> product7 = new HashMap<>();
        product7.put("name", "Product G");
        product7.put("price", "6.75");
        product7.put("barcode", "99887766554");
        productDatabase.put("99887766554", product7);

        Map<String, String> product8 = new HashMap<>();
        product8.put("name", "Product H");
        product8.put("price", "14.99");
        product8.put("barcode", "44556677889");
        productDatabase.put("44556677889", product8);

        Map<String, String> product9 = new HashMap<>();
        product9.put("name", "Product I");
        product9.put("price", "9.99");
        product9.put("barcode", "55667788990");
        productDatabase.put("55667788990", product9);

        Map<String, String> product10 = new HashMap<>();
        product10.put("name", "Product J");
        product10.put("price", "11.49");
        product10.put("barcode", "12312312312");
        productDatabase.put("12312312312", product10);
    }

    @GetMapping("/product/{barcode}")
    public Map<String, String> getProductDetails(@PathVariable String barcode) {
        return productDatabase.getOrDefault(barcode, null);
    }
}
