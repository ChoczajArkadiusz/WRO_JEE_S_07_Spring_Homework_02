package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Cart;
import pl.coderslab.CartItem;
import pl.coderslab.Product;
import pl.coderslab.ProductDao;

import java.util.List;


@Controller
public class CartController {
    private Cart cart;
    private ProductDao productDao;

    @Autowired
    public CartController(Cart cart, ProductDao productDao) {
        this.cart = cart;
        this.productDao = productDao;
    }

    @GetMapping("/addToCart")
    public String addForm(Model model) {
        List<Product> products = productDao.getList();
        model.addAttribute("products", products);
        return "addForm";
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam Long id, @RequestParam int quantity) {
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getId() == id) {
                cartItem.setQuantity(quantity + cartItem.getQuantity());
                return "redirect:/cart";
            }
        }
        if (productDao.getById(id) != null) {
            cart.addToCart(new CartItem(quantity, productDao.getById(id)));
        }
        return "redirect:/cart";
    }

    @RequestMapping("/cart")
    public String carts(Model model) {
        model.addAttribute("numOfItems", cart.numberOfItems());
        model.addAttribute("total", cart.total());
        model.addAttribute("numOfPos", cart.count());
        model.addAttribute("carts", cart.getCartItems());
        return "cart";
    }
}