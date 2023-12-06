public class Producto {
    private int id;
    private double price;
    private String img;
    private String desc;
    private int stock;
    private int Subtotal;

    public int getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(int subtotal) {
        Subtotal = subtotal;
    }

    Producto(){
        this.id = 0;
        this.price = 0.0;
        this.img = "";
        this.desc = "";
        this.stock = 0;
    }

    Producto(int id, double price, String img, String desc, int stock){
        this.id = id;
        this.price = price;
        this.img = img;
        this.desc = desc;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
