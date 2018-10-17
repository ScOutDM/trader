package ru.itpark.trader.controller;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.trader.DTO.ProductDTO;
import ru.itpark.trader.service.ProductService;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class IndexPageController {
    private final ProductService productService;

    public IndexPageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("products", productService.getAll());
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model) {
        model.addAttribute("products", productService.findByName(name));
        return "searchresult";
    }

    @GetMapping("/product/{id}")
    public String getById(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product";
    }

    @GetMapping("product/add")
    public String addForm(){
        return "product-add";
    }

    @PostMapping("product/add")
    public String add(@Valid @ModelAttribute ProductDTO productDTO) {
        productService.add(productDTO);
        return "redirect:/";
    }

    @PostMapping("/products/{id}/delete")
    public String delete(@PathVariable int id) {
        productService.deleteById(id);
        return "redirect:/";
    }
}
