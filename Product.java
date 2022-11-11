import java.io.*;

public class Product {
    private String productType;
    private double price;

    private int id;


    public Product(String productType, double price, int id) {
        this.productType = productType;
        this.price = price;
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product() {
    }

    public void save(){
        Product e = null;
        try {

            FileOutputStream fileOut = new FileOutputStream("object.ser");
            // ^ opening a connect to a new file and allowing to connect
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // ^ streaming data from an object into a file
            out.writeObject(e);
            // take this object and i'm lobbing it
            out.close();
            // close it once we are done with the file
            fileOut.close();
            // close it once we are done with the file
            System.out.println("Your products have been saved!");


        } catch (IOException i) {
            i.printStackTrace();
            // history of all the methods that were called - allows us to see where the code went wrong.
            //principle of a stack is similar to pringles - last in, first out
        }

    }

    public void load() {
        Product e = null; // this create an object of type employee to receive data from file or return

        try {
            // read object from a file
            FileInputStream file = new FileInputStream("object.ser");
            // create a connect to a file
            ObjectInputStream in = new ObjectInputStream(file);

            // method for deserialization for an object
            e = (Product) in.readObject();
            // ^ read object and convert data to type Employee

            in.close();
            file.close();

            System.out.println("Here are your previous products: ");
            System.out.println(e.toString());

        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return "Product: " + productType + '\'' +
                ", price: " + price;
    }

}
