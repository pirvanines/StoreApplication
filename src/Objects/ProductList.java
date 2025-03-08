package Objects;

import java.util.ArrayList;

public class ProductList {
    private static ArrayList<Product> products;
    private static ArrayList<Integer> favourites;
    //private static ArrayList<Integer> shoppingCart;

    public ProductList()
    {
        products = new ArrayList<Product>();
        favourites = new ArrayList<Integer>();
        //shoppingCart = new ArrayList<Integer>();
    }

    public void addProduct(Product product)
    {
        products.add(product);
    }

    public void addFavourite(int index)
    {
        favourites.add(index);
    }
    public void removeFavourite(int index)
    {
        favourites.remove(index);
    }

    /*public void removeFromCart(int index)
    {
        shoppingCart.remove(index);
    }*/

    public int getArraySize()
    {
        return products.size();
    }

    public void FavouritesFilter()
    {
        for (Product element : products)
        {
            if(element.isFavourite())
            {
                favourites.add(products.indexOf(element));
            }
        }
    }

    /*public void BasketFilter()
    {
         for (Product element : products)
        {
            if(element.isShoppingCart())
            {
                shoppingCart.add(products.indexOf(element));
            }
        }
    }*/

    /*public void NameFilter(String name)
    {
        for (Product element : products)
        {
            if(name.equals(element.getName()))
            {
                favourites.add(products.indexOf(element));
            }
        }
    }*/
}
