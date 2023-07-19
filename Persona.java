import java.util.ArrayList;
import java.util.Scanner;

public class Persona {
    private Scanner sc=new Scanner(System.in);

    private String nombre1;
    private int rut;

    public Persona() {

    }

    public Persona(String nombre, int rut) {
        this.nombre1 = nombre;
        this.rut = rut;
    }
    public Persona( int rut) {
        this.rut = rut;
    }


    public int getRut(){
        return  rut;
    }
    public String getNombre1(){
        return nombre1;
    }

    public String validarnombre(){
        String nombre;
        while (true){
            System.out.println("ingrese su nombre: ");
            nombre= sc.nextLine();
            String nombre2=nombre.replace(" ","");
            boolean letras=nombre2.matches("[a-zA-Z]+");
            if (nombre.length()>3 && letras){
                break;
            }else {
                System.out.println("ingrese un nombre de una logitud mayor a 3 y que solo contenga letras ");
            }
        }
        return nombre;
    }
    public int rutsapado(){

        while (true) {
            try {
                System.out.println("ingrese el rut: ");
                while (!sc.hasNextInt()) {
                    System.out.println("ingrese el rut sin digito verificador ni guion");
                    sc.next();
                }
                int rut = sc.nextInt();
                if (rut>=1000000 && rut<=99000000){
                    return rut;
                }else {
                    System.out.println("el rut debe estar entre 1 millon y 99 millones");
                }


            } catch (Exception e) {
                System.out.println("ingrese el rut sin digito verificador ni guion");
            }
        }
    }

    public String verDatos() {
        return "nombre: "+"\n"+nombre1;
    }
}
