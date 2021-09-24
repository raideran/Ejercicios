
import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicios_JAPS {

    public static String formaUno(String sentence){
        /*
        Esta primera forma usa dos ciclos for, uno para recorrer toda la oración y el segundo
        para invertir la palabra cuando encuentra un espacio o cuando encuentra el final de la frase.
        */
        String reversed = "";

        for(int i=0; i<sentence.length(); i++){
            if(sentence.charAt(i)==' ' || i==sentence.length()-1){
                int reverse_length = reversed.length();
                for(int f=i; f>=reverse_length; f--){
                    reversed = sentence.charAt(f) != ' ' ? reversed + sentence.charAt(f) : reversed;
                }
                if(sentence.length()-1!=i)
                    reversed += ' ';
            }
        }

        return reversed;
    }

    public static String formaDos(String sentence){
        /*
        La segunda forma usa solo un ciclo, lo que es más eficiente, en vez de usar un string normal, usa
        un string builder que permite insertar palabras al inicio del objeto por medio del offset.
        Se recorre la frase de final a inicio lo cual invierte las palabras y al insertar al inicio (offset=0)
        del stringbuilder las acomoda en el orden original de la frase.
         */
        StringBuilder reversed = new StringBuilder();
        String temp = "";
        for(int i = sentence.length()-1; i>=0; i--){
            if(sentence.charAt(i)==' '){
                reversed.insert(0, " " + temp);
                temp = "";
            }
            else{
                temp += sentence.charAt(i);
            }
        }
        reversed.insert(0, temp);
        return  new String(reversed);

    }

    public static String formaTres(String sentence){
        /*
        La tercer forma es similar a la segunda pero usa una función nativa de del string builder para reversar las palabras
        y usa la función split de la clase String
         */
        String words[] = sentence.split("\\s");
        String reversed = "";
        for(String word:words){
            reversed +=  new StringBuilder(word).reverse() + " ";
        }

        return reversed.trim();

    }

    public static String formaLuis(String oracion){
        String extraido = ""; //Variable que se utilizara para almacenar la oración modificada
        try{


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

        }catch(NullPointerException npe){

        }
        return extraido;
    }


    public static void main(String[] args) {
        String sentence = JOptionPane.showInputDialog("Digite una oración");
        JOptionPane.showMessageDialog(null, "Forma Uno: " + formaUno(sentence));
        JOptionPane.showMessageDialog(null, "Forma Dos: " + formaDos(sentence));
        JOptionPane.showMessageDialog(null, "Forma Tres: " + formaTres(sentence));
        JOptionPane.showMessageDialog(null, "Forma Luis: " + formaLuis(sentence));

    }

}