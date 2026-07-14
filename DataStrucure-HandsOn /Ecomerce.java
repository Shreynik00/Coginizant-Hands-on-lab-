class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    void display() {
        System.out.println(
            "ID: " + productId +
            ", Name: " + productName +
            ", Category: " + category
        );
    }
}

class SearchByLinear {

    public static Product linearSearch(Product[] products, int id) {

        for(Product product : products) {

            if(product.productId == id) {
                return product;
            }
        }

        return null;
    }
}

class SearchByBinary {

    public static Product binarySearch(Product[] products, int id) {

        int left = 0;
        int right = products.length - 1;


        while(left <= right) {

            int mid = (left + right) / 2;


            if(products[mid].productId == id) {
                return products[mid];
            }


            else if(products[mid].productId < id) {
                left = mid + 1;
            }


            else {
                right = mid - 1;
            }
        }

        return null;
    }
}

public class EcommerceSearch {

    public static void main(String args[]) {


        // Array for Linear Search
        Product products[] = {

            new Product(101,"Laptop","Electronics"),
            new Product(205,"Shoes","Fashion"),
            new Product(310,"Mobile","Electronics"),
            new Product(450,"Watch","Accessories")

        };


        // Linear Search

        System.out.println("Linear Search Result:");

        Product result1 =
        SearchByLinear.linearSearch(products,310);


        if(result1 != null)
            result1.display();
        else
            System.out.println("Product Not Found");



        // Sorted array for Binary Search

        Product sortedProducts[] = {

            new Product(101,"Laptop","Electronics"),
            new Product(205,"Shoes","Fashion"),
            new Product(310,"Mobile","Electronics"),
            new Product(450,"Watch","Accessories")

        };


        System.out.println("\nBinary Search Result:");

        Product result2 =
        SearchByBinary.binarySearch(sortedProducts,450);


        if(result2 != null)
            result2.display();
        else
            System.out.println("Product Not Found");

    }
}
