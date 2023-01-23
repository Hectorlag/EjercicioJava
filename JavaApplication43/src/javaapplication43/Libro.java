
package javaapplication43;

import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;


public class Libro extends Libreria {
    private String autor;
    private int tomo;
    private int isbn;
    
    Libro(){
     super();
     autor="";
     tomo=0;
     isbn=0;
    }
    
    Libro(String tit, String edi, Date fed, float p, int st, String aut, int t, int is){
      super(tit, edi, fed, p, st);
      this.autor=aut;
      this.tomo=t;
      this.isbn=is;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the tomo
     */
    public int getTomo() {
        return tomo;
    }

    /**
     * @param tomo the tomo to set
     */
    public void setTomo(int tomo) {
        this.tomo = tomo;
    }

    /**
     * @return the isbn
     */
    public int getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    
    public void registrar_Libro() throws ParseException{
       super.registrar_Libreria();
       
         do{
           this.autor=JOptionPane.showInputDialog("\n Ingrese el autor: ");
             if(this.getAutor().compareToIgnoreCase("") == 0){
               JOptionPane.showMessageDialog(null,"\n Debe ingresar algun caracter");
             }
         }while(this.getAutor().compareToIgnoreCase("") == 0);
         
         do{
           this.tomo=Integer.parseInt(JOptionPane.showInputDialog("\n Ingrese el tomo: "));
             if(this.getTomo() < 1){
               JOptionPane.showMessageDialog(null,"\n El tomo debe ser mayor a cero");
             }
         }while(this.getTomo() < 1);
         
         do{
           this.isbn=Integer.parseInt(JOptionPane.showInputDialog("\n Ingrese el ISBN: "));
             if(this.getIsbn() < 1){
               JOptionPane.showMessageDialog(null,"\n El ISBN debe ser mayor a cero");
             }
         }while(this.getIsbn() < 1);
    }
    
    @Override
    public String toString(){
      String mensaje="";
        mensaje=  super.toString()  +  "\n Autor: " + this.autor +
                                       "\n Tomo: " + this.tomo +
                                       "\n ISBN: " + this.isbn;
        return mensaje;
    }
    
    public void mostrar_Libro(){
      JOptionPane.showMessageDialog(null, toString());
    }
    
    @Override
    public float valor_Total_Stock(){
        float tot=0;
          tot= super.getPrecio() * super.getStock();
        return tot;  
    
    }
    
}
