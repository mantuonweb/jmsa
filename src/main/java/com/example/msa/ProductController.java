package com.example.msa;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final Map<Integer, String> products = new HashMap<>();

    @GetMapping
    public List<String> listProducts() {
        return new ArrayList<>(products.values());
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable int id) {
        return products.getOrDefault(id, "Product not found");
    }

    @PostMapping
    public String addProduct(@RequestParam String name) {
        int id = products.size() + 1;
        products.put(id, name);
        return "Product added with id: " + id;
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestParam String name) {
        if (products.containsKey(id)) {
            products.put(id, name);
            return "Product updated";
        } else {
            return "Product not found";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        if (products.containsKey(id)) {
            products.remove(id);
            return "Product deleted";
        } else {
            return "Product not found";
        }
    }
}