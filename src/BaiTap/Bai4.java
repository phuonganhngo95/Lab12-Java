package BaiTap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Product implements Serializable {
    private String proId;
    private String proName;
    private String producer;
    private int yearMaking;
    private float price;

    public String getProName() {
        return proName;
    }
}

class ProductTest {
    private List<Product> products;

    public ProductTest() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(products);
        }
    }

    public void readFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            products = (List<Product>) ois.readObject();
        }
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void searchProduct(String productName) {
        for (Product product : products) {
            if (product.getProName().contains(productName)) {
                System.out.println("Tìm thấy sản phẩm: " + product);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm tên '" + productName + "'");
    }
}
