import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       Edificio ed=new Edificio();
       Scanner sc =new Scanner(System.in);
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
                   5-salir
                   """);
           op=ed.verificarcant(0,6," una opcion ");
           switch (op) {
               case 1 -> ed.ver_edificio();
               case 2 -> ed.compra();
               case 3 -> ed.buscar_dueno();
               case 4 -> System.out.println("la ganancias son "+ed.ganacias);
               case 5 -> System.out.println("adios");
               default -> System.out.println("ingrese una opcion valida");
           }

       }while (op!=5);

    }

}
