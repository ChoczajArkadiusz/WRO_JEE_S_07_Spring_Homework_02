package pl.coderslab;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public int count() {
        return cartItems.size();
    }

    public double total() {
        double sum = 0.0;
        for (CartItem cartItem : cartItems) {
            sum += cartItem.getQuantity() * cartItem.getProduct().getPrice();
        }
        return sum;
    }

    public int numberOfItems() {
        int numOfItems = 0;
        for (CartItem cartItem : cartItems) {
            numOfItems += cartItem.getQuantity();
        }
        return numOfItems;
    }
}