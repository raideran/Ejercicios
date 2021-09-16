/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */

import javax.swing.JOptionPane;

public class EjercicioString_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        try{
            
            
            String oracion; //Variable en donde se digitará la oración a modificar
            String extraido = ""; //Variable que se utilizara para almacenar la oración modificada
            oracion = JOptionPane.showInputDialog("Digite una oración");






            //Variable que servirá de auxiliar:
            int a = 1;

            for( int f = 0; f < oracion.length(); f++ ){


                //Si el caracter en la posicion f diferente a un espacio y f es indiferente al tamaño de oracion-1
                if ( (oracion.charAt(f) != ' ') && (f != oracion.length()-1) ){ 



                }
                //Si no si f es igual al tamaño de la variable oración-1
                else if ( f == oracion.length()-1 ){

                    while ( oracion.charAt(f) != ' ' ){

                        extraido = extraido + oracion.charAt(f);
                        f--;
                    }
                    //Se declará f con el valor del tamaño de la variable oración para que se termine el for
                    f = oracion.length();

                }

                else if ( a == 1 ){

                    //Este caso se aplicará unicamente para almacenar la primera palabra de la oración
                    while( f > 0 ){
                        f--;
                        extraido = extraido + oracion.charAt(f);
                        if( f == 0 ){
                            a = 2;
                        }




                    }        
                    extraido = extraido + " ";
                }
                else if ( a == 2 ){

                    a = 3;

                }
                
                else if( a == 3 ){

                    f--;

                    while ( oracion.charAt(f) != ' ' ){

                        extraido = extraido + oracion.charAt(f);
                        f--;
                    }

                    a = 2;

                    extraido = extraido + " ";

                }



            }

            JOptionPane.showMessageDialog(null, extraido);
        }catch(NullPointerException npe){
            
        }
            
    }
    
}
