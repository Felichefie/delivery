public class impnom {
    

        private double base;
        private double porcentaje;
        
            
            public double obtenerIva(double b, double p) {
        
            this.base = b;
            return this.porcentaje = p;
        
            }
            
           public double impnomi(){
                return this.base * this.porcentaje/100;
            }
        
        }

