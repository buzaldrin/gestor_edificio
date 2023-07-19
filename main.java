import java.util.Scanner;

public class Main {
     private static Scanner sc =new Scanner(System.in);
    public static void main(String[] args) {


        Edificio ed=new Edificio();

        int op;
        System.out.println("bienvenido a brisa alta");
        final String RESET = "\033[0m";
        do {
            System.out.println(RESET);
            System.out.println("""
                   1-ver edificio
                   2-comprar
                   3-buscar dueño
                   4-ver ganancias
                   5-eliminar dueño
                   6-salir
                   """);
            op=verificarcant(0,7," una opcion ");
            switch (op) {
                case 1 -> ed.ver_edificio();
                case 2 -> ed.compra();
                case 3 -> ed.buscar_dueno();
                case 4 -> System.out.println("la ganancias son "+ed.verGanancias());
                case 5-> ed.eliminarDueno();
                case 6 -> System.out.println("adios");
                default -> System.out.println("ingrese una opcion valida");
            }

        }while (op!=6);

    }

    public static int verificarcant(int minimo, long  maximo, String Stesto){
        while (true) {
            try {
                System.out.println("ingrese "+Stesto);
                while (!sc.hasNextInt()) {
                    System.out.println("ingrese un numero entero ");
                    sc.next();
                }
                int numero = sc.nextInt();
                if (numero>minimo && numero<maximo){
                    return numero;
                }else {
                    System.out.println("debe ser entre "+(minimo+1)+" y "+(maximo-1));
                }
            } catch (Exception e) {
                System.out.println("ingrese el rut sin digito verificador ni guion");
            }
        }
    }

    }
