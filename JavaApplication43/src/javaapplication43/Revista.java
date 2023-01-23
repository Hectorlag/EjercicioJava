
package javaapplication43;

import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;


public class Revista extends Libreria{
    private int numero;
    private String tipo;
    
    Revista(){
     super();
     numero=0;
     tipo="";
    }
    Revista(String tit, String edi, Date fed, float p, int st, int num, String tip){
        super(tit, edi, fed, p, st);
        this.numero=num;
        this.tipo=tip;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void registrar_Revista() throws ParseException{
      super.registrar_Libreria();
        
      do{
         this.numero=Integer.parseInt(JOptionPane.showInputDialog("\n Numero de revista: "));
           if(this.getNumero() < 1){
             JOptionPane.showMessageDialog(null,"\n El numero de revista debe ser mayor a cero");
           }
      }while(this.getNumero() < 1);
    
    
      do{
         this.tipo=JOptionPane.showInputDialog("\n Ingrese el tipo de revista: ");
           if(this.getTipo().compareToIgnoreCase("educativa") != 0 &&
             this.getTipo().compareToIgnoreCase("historieta") != 0){
               JOptionPane.showMessageDialog(null,"\n Las opciones validas son: (EDUCATIVA---HISTORIETA");
           }   
      }while(this.getTipo().compareToIgnoreCase("educativa") !=0 &&
              this.getTipo().compareToIgnoreCase("historieta") != 0);
    }
    
    @Override
    public String toString(){
      String mensaje="";
        mensaje= super.toString() + "\n Numero de revista: " + this.numero + "\n Tipo: " + this.tipo;
          return mensaje;  
    }
    
    public void mostrar_Revista(){
      JOptionPane.showMessageDialog(null, toString());
    }
    
    @Override
    public float valor_Total_Stock(){
        float mont=0;
          mont= this.getPrecio() * this.getStock();
          return mont;
    }
    
    
}
