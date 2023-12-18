import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Productos{

    private String imageUrl;
    private String description;
    private double price;
    private int StockQuantity;
    private String StockDescription;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return StockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        StockQuantity = stockQuantity;
    }

    public String getStockDescription() {
        return StockDescription;
    }

    public void setStockDescription(String stockDescription) {
        StockDescription = stockDescription;
    }

    public Productos(String imageUrl, String description, double price, int StockQuantity, String StockDescription) {
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
        this.StockQuantity = StockQuantity;
        this.StockDescription = StockDescription;
    }

    public static ImageIcon loadImageFromURL(String imageUrl) {
        try {
            return new ImageIcon(new URL(imageUrl));
        } catch (MalformedURLException e) {
            System.err.println("Error al cargar la imagen desde el URL:" + imageUrl);
            e.printStackTrace();
        }
        return null;
    }

    
    static final String[] IMAGE_URLS = {
        "https://gobeef.mx/cdn/shop/products/GoBeef_ProductShot_PechugaPollo_800x.png",
        "https://notitotal.com/wp-content/uploads/2020/06/panintegralfinaalfinaaal.jpg",
        "https://th.bing.com/th/id/OIP.-Q622cEzXpYluF_jk7F_bwHaHa?rs=1&pid=ImgDetMain",
        "https://http2.mlstatic.com/D_NQ_NP_2X_803237-MLA48551207726_122021-F.jpg",
        "https://i5.walmartimages.com/asr/3268d77a-4b14-46a1-9eff-78709e4eb02d.df3e1a4ac9ed37823f9889bc2a95d4bf.jpeg",
        "https://images-na.ssl-images-amazon.com/images/I/71UnD6gYfFL.jpg",
        "https://peruviannutrition.com/wp-content/uploads/2022/06/PSICHOTYC-GOLD.png"
    };

    
    static final String[] DESCRIPTIONS = {
        "Pechuga de pollo: 100% carne magra y saludable.",
        "Pan integral: Rico en fibra y nutrientes esenciales.",
        "Proteina: Suplemento para el desarrollo muscular.",
        "Creatina: Mejora el rendimiento en actividades físicas intensas.",
        "Omega 3: Ácidos grasos esenciales para la salud cardiovascular.",
        "Straps: Accesorio para levantamiento de pesas.",
        "Pre-workout: Suplemento para mejorar el rendimiento antes del entrenamiento."
    };

    private static final double[] PRICES = {
        180,
        65,
        1500,
        850,
        620,
        150,
        480
    };

    private static final int [] STOCKQUANTITY = {
        100,
        29 ,
        16 ,
        65 ,
        49 ,
        37 ,
        13,
    };

    private static final String [] STOCKDESCRIPTION ={

        "Kilogramos",
        "Unidades",
        "Unidades",
        "Unidades",
        "Unidades",
        "Unidades",
        "Pares",
        "Unidades",

    };

    public static List<Productos> getProductos(){
        List <Productos> productos = new ArrayList<>();

        for (int i = 0; i < IMAGE_URLS.length; i++) {
            Productos producto = new Productos(
                IMAGE_URLS[i],
                DESCRIPTIONS[i],
                PRICES[i],
                STOCKQUANTITY[i],
                STOCKDESCRIPTION[i]);
                productos.add(producto);
            };
            return productos;
    }
}