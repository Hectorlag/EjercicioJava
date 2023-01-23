
package javaapplication43;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public abstract class Libreria {
    private String titulo;
    private String editorial;
    private Date fecha_edi;
    private float precio;
    private int stock;
    
    Libreria(){
    titulo="";
    editorial="";
    fecha_edi=null;
    precio=0;
    stock=0;
    }
    Libreria(String tit, String edi, Date fed, float p, int st){
        this.titulo=tit;
        this.editorial=edi;
        this.fecha_edi=fed;
        this.precio=p;
        this.stock=st;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * @return the fecha_dev
     */
    public Date getFecha_edi() {
        return fecha_edi;
    }

    
    public void setFecha_edi(Date fecha_edi) {
        this.fecha_edi = fecha_edi;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void registrar_Libreria() throws ParseException{
      SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
      String fech="";
        
        do{
           this.titulo=JOptionPane.showInputDialog("\n Ingrese el titulo: ");
             if(this.getTitulo().compareToIgnoreCase("") == 0){
               JOptionPane.showMessageDialog(null,"\n Debe ingresar algun caracter");
             }
        }while(this.getTitulo().compareToIgnoreCase("") == 0);
        
        do{
           this.editorial=JOptionPane.showInputDialog("\n Ingrese la editorial: ");
              if(this.getEditorial().compareToIgnoreCase("") == 0){
                JOptionPane.showMessageDialog(null,"\n Debe ingresar algun caracter");
              }
        }while(this.getEditorial().compareToIgnoreCase("") == 0);
        
        do{
          fech=JOptionPane.showInputDialog("\n Ingrese la fecha: ");
            if(fech.compareToIgnoreCase("") == 0){
              JOptionPane.showMessageDialog(null,"\n Debe ingresar la fecha de edicion: formato---> DD/MM/AAAA");
            }
        }while(fech.compareToIgnoreCase("") == 0);
        this.fecha_edi=formato.parse(fech);
        
        do{
          this.precio=Float.parseFloat(JOptionPane.showInputDialog("\n Ingrese el precio: "));
            if(this.precio < 1){
              JOptionPane.showMessageDialog(null,"\n El precio debe ser mayor a cero");
            }
        }while(this.getPrecio() < 1);
        
        do{
           this.stock=Integer.parseInt(JOptionPane.showInputDialog("\n Ingrese el stock: "));
              if(this.getStock() < 0){
                JOptionPane.showMessageDialog(null,"\n El stock debe ser mayor a cero");
              }
        }while(this.getStock() < 0);
    }
    
    @Override
    public String toString(){
      SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String f,mensaje;
          f=mensaje="";
            f=formato.format(fecha_edi);
              mensaje= "\n Titulo: " + this.titulo +
                         "\n Editorial: " + this.editorial +
                          "\n Fecha de edicion: " + f +
                           "\n Precio: " + this.precio +
                            "\n Stock: " + this.stock;
             return mensaje;               
    }
    
    public void mostrar_Libreria(){
      JOptionPane.showMessageDialog(null, toString());
    }
    
    public abstract float valor_Total_Stock();
    
    public int anio(){
      Date h = new Date();
      int a=0;
      a= this.getFecha_edi().getYear();
      return a;
    }
       
}
