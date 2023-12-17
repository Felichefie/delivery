
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Factura {
   
   private Date fechaHoraEmision;
   private long numero;
   private EstadoFactura estado;
   private List<DetallePedido> detallesPedido;

   /**
    * Constructor por defecto de la clase Factura.
    */
   public Factura() {
       detallesPedido= new ArrayList();
   }
   
   /**
    * Constructor sin atributos referenciales de la clase Factura.
    * @param fechaHoraEmision
    * @param numero 
    */
   public Factura(Date fechaHoraEmision, long numero) {
       this.fechaHoraEmision = fechaHoraEmision;
       this.numero = numero;
   }
   /**
    * Constructor con todos los atributos de la clase Factura.
    * @param fechaHoraEmision
    * @param numero
    * @param estado
    * @param detallesPedido 
    */
   public Factura(Date fechaHoraEmision, long numero, EstadoFactura estado, List<DetallePedido> detallesPedido) {
       this.fechaHoraEmision = fechaHoraEmision;
       this.numero = numero;
       this.estado = estado;
       this.detallesPedido = detallesPedido;
   }
   
   public Date getFechaHoraEmision() {
       return fechaHoraEmision;
   }

   public void setFechaHoraEmision(Date fechaHoraEmision) {
       this.fechaHoraEmision = fechaHoraEmision;
   }

   public long getNumero() {
       return numero;
   }

   public void setNumero(long numero) {
       this.numero = numero;
   }

   public EstadoFactura getEstado() {
       return estado;
   }

   public void setEstado(EstadoFactura estado) {
       this.estado = estado;
   }

   public List<DetallePedido> getDetallesPedido() {
       return detallesPedido;
   }

   public void setDetallesPedido(List<DetallePedido> detallesPedido) {
       this.detallesPedido = detallesPedido;
   }
} 
