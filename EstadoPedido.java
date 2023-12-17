
public class EstadoPedido {
    
    private Integer id;
    private String nombre;
    private String descripcion;
    
    public EstadoPedido() {
    }
    
    /**
     * Constructor con todos los atributos de la clase Estado.
     * @param nombre
     * @param descripcion 
     */
    public EstadoPedido(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    /**
     * Método que devuelve true si el estado es Pendiente de Facturación
     * @return 
     */
    public boolean esPteFacturacion() {
        return nombre.equals("Pendiente de Facturación");
    }
    /**
     * Método que devuelve true si el estado es Facturado, sino devuelve false.
     * @return 
     */
    public boolean esFacturado() {
        return nombre.equals("Facturado");
    }
    
    /**
     * Método que devuelve true si el estado es Generada, sino devuelve false.
     */
    public boolean esGenerada() {
        return nombre.equals("Generada");
    }    
    
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
