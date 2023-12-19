import java.math.BigDecimal;

public class Pizza {
    
    private Integer id;
    private String nombre;
    private BigDecimal precio;

    public Pizza() {
    }
    
    /**
     * Constructor sin atributos referenciales de la clase Pizza.
     * @param nombre
     * @param precio 
     */
    public Pizza(String nombre, BigDecimal precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    /**
     * Constructor con todos los atributos de la clase Pizza.
     * @param nombre
     * @param precio
     */
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza \n - Nombre: ").append(nombre).append("\n - Precio: $ ").append(precio);
        return sb.toString();}
}