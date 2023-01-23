
package javaapplication43;

import java.text.ParseException;
import javax.swing.JOptionPane;


public class JavaApplication43 {

    
    public static void main(String[] args) throws ParseException {
        int n,op=0;
        
        n=Integer.parseInt(JOptionPane.showInputDialog("\n Productos a registrar: "));
          Libreria [] vec = new Libreria[n];
          
          for(int i=0;i<vec.length;i++){
            vec[i] = null;
          }
          //CARGA DE DATOS
          for(int i=0;i<vec.length;i++){
            int c=0;
            c=Integer.parseInt(JOptionPane.showInputDialog("\n Productos que va a registrar: 1)Revista---2)Libro "));
            if(c == 1){
              Revista r = new Revista();
              r.registrar_Revista();
              vec[i] = r; 
            }
            else{
             Libro l = new Libro();
             l.registrar_Libro();
             vec[i] = l;
            }
          }
          
          //MUESTRO LOS DATOS
          Revista rev=null;
          Libro lib= null;
          for(int i=0;i<vec.length;i++){
            if(vec[i] instanceof Revista){
              rev = (Revista) vec[i];
              rev.mostrar_Revista();
            }
            else{
              lib = (Libro) vec[i];
              lib.mostrar_Libro();
            }
          }
          
        do{
        JOptionPane.showMessageDialog(null,"\t MENU DE OPCIONES");
        op=Integer.parseInt(JOptionPane.showInputDialog("\n 1.Calcular el valor total de stock que posee la librería para libros y revistas ( 2totales)" +
        "\n 2.Buscar los datos de todos los libros que fueron editado en el año “X”.Ingresar el año por teclado"+
        "\n 3.Listar los datos de las revistas educativas." +
        "\n 4.Emitir un listado ordenado de libros por su ISBN" +
        "\n 5. Salir"));
        
        switch(op){
            case 1: total(vec);
                break;
                
            case 2: buscar_Xanio(vec);   
                break;
                
            case 3: revistas_Educ(vec);
                break;
                
            case 4: listado_Xisbn(vec);
                break;
                
            case 5: JOptionPane.showMessageDialog(null,"\n Gracias por utlizar el programa");
                break;
                
            default: JOptionPane.showMessageDialog(null,"\n Opcion no valida");
        }
          }while(op != 5);
    }
    
public static void total(Libreria vec[]){
  String mensaje,frase;
    mensaje=frase="";
      Revista r=null;
        Libro l=null;
          float acur,acul;
            acur=acul=0;
            boolean b,ban;
              b=ban=false;
                for(int i=0;i<vec.length;i++){
                  if(vec[i] instanceof Revista){
                    r = (Revista) vec[i];
                    acur+=r.valor_Total_Stock();
                    b=true;
                  }
                  else{
                      if(vec[i] instanceof Libro)
                       l = (Libro) vec[i];
                    acul+=l.valor_Total_Stock();
                    ban=true;
                  }
              }
              if(b==false){
                JOptionPane.showMessageDialog(null,"\n No hay revistas registradas" );
              }
               if(ban==false){
                JOptionPane.showMessageDialog(null,"\n No hay Libros registradas" );
              }
              
              JOptionPane.showMessageDialog(null,"\n El valor total de revistas segun stock es: " + acur);
              JOptionPane.showMessageDialog(null,"\n El valor total de libros segun stock es: " + acul);
}

public static void buscar_Xanio(Libreria vec[]){
   String mensaje="";
     boolean ban=false;
       Libro l=null;       
         int a=0;
           a=Integer.parseInt(JOptionPane.showInputDialog("\n Ingrese el año: "));
          
             for(int i=0;i<vec.length;i++){
               if(vec[i] instanceof Libro){
                 l = (Libro) vec[i];
                   if(l.anio()+1900 == a){
                     mensaje+="\n Datos: " + l.toString();
                     mensaje+="\n------";
                     ban=true;
                   }
               }
             }
             if(ban==false){
                JOptionPane.showMessageDialog(null,"\n No hay libros registrados en ese anio");
             }
             else{
                JOptionPane.showMessageDialog(null, mensaje);
             }
            
} 

public static void revistas_Educ(Libreria vec[]){
  String mensaje="";
    boolean ban=false;
      Revista r=null;
        for(int i=0;i<vec.length;i++){
          if(vec[i] instanceof Revista){
            r = (Revista) vec[i];
              if(r.getTipo().compareToIgnoreCase("educativa") == 0){
                mensaje+="\n Revista educativa: " + r.toString();
                mensaje+="\n-------";
                ban=true;
              }
          }
        }
        if(ban==false){
          JOptionPane.showMessageDialog(null,"\n No hay revistas educativas registradas");
        }
        else{
          JOptionPane.showMessageDialog(null, mensaje);
        }
}

public static void listado_Xisbn(Libreria vec[]){
  String mensaje="";
  Libro l=null;
  Libro aux=null;
  int x,c;
  x=c=0;
    for(int i=0;i<vec.length;i++){
      if(vec[i] instanceof Libro){
        c++;
      }
    }
    //CREO EL VECTOR DE LIBROS
    Libro [] vlib = new Libro[c];
    //RECORRO EL VECTOR LIBRERIA
      for(int i=0;i<vec.length;i++){
        if(vec[i] instanceof Libro){
          l = (Libro) vec[i];
          vlib[x] = l;
          x++;
        }
      }
      //ORDENAMIENTO
      for(int i=0;i<vlib.length-1;i++){
       for(int j=i+1;j<vlib.length;j++){
         if(vlib[i].getIsbn() < vlib[j].getIsbn()){
            aux=vlib[i];
            vlib[i]=vlib[j];
            vlib[j]=aux;
         }
         }
      }
      //MUESTRO LOS DATOS
        for(int i=0;i<vlib.length;i++){
         mensaje+=vlib[i].toString();
         mensaje+="\n-----";
        }
        JOptionPane.showMessageDialog(null, mensaje);
        
}
    
}
