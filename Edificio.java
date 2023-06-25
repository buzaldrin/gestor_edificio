
import java.util.Scanner;
import java.util.ArrayList;

public class Edificio {

    ArrayList<Integer> ruts = new ArrayList<>();

    ArrayList<Integer> departamentos = new ArrayList<>();
    ArrayList<Integer> pisos = new ArrayList<>();

    ArrayList<String> nombres = new ArrayList<>();
   private final Scanner sc=new Scanner(System.in);

      private final boolean[][] edificio =new boolean[10][4];
    private int rut;
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
     private String nombre;
     int ganacias=0;



    public void compra(){
        int piso = verificarcant(0, 11, " el piso ");
        int columa = verificarcant(0, 5, " el departamento ");
          int por2;
        int pisop = piso;
        int departamento = columa;
          por2 = piso * 2;
          piso += edificio.length;
          columa -= 1;
          int comversion;
          comversion = piso - por2;
          if (!edificio[comversion][columa]){
              edificio[comversion][columa] = true;
              rut=rutsapado();
              sc.nextLine();
              boolean encontrado = false;
              for (int i=0;i<ruts.size();i++){
                  if (ruts.get(i).equals(rut)){
                      System.out.println("usted ya compro no se preocupe");
                      encontrado=true;
                      break;
                  }
              }if (!encontrado){
                  nombre=validarnombre();
              }
              int pago;
              if (comversion<=2){
                 pago=pagamiento(200000000,"200");
                  ganacias+= pago;

              }else {
                  pago=pagamiento(150000000,"150");
                  ganacias+= pago;
              }
              encontrado=false;
              for (int i = 0; i < ruts.size(); i++) {
                  if (ruts.get(i).equals(rut)) {
                      ruts.add(rut);
                      nombre = nombres.get(i);
                      nombres.add(nombre);
                      departamentos.add(departamento);
                      pisos.add(pisop);
                      encontrado = true;
                      break;
                  }
              }

              if (!encontrado) {
                  ruts.add(rut);
                  nombres.add(nombre);
                  departamentos.add(departamento);
                  pisos.add(pisop);
              }
              System.out.println("compra realiza con exito");
          }else {
              System.out.println("ese departamento esta ocupado");
          }

      }



      public void buscar_dueno(){
        rut=rutsapado();
          for (int i = 0; i < ruts.size(); i++) {
             if (ruts.get(i)==rut){
                 System.out.println("dueño "+nombres.get(i));
                 System.out.println("piso "+pisos.get(i));
                 System.out.println("departemento "+(departamentos.get(i)));
                 System.out.println("\n");
             }
          }

      }



      public void ver_edificio(){
          int num = 10;

          System.out.println(" ");
          for (int i=0;i<edificio.length;i++){
              System.out.print(num +" ");
              num--;
              int departamento=0;
              for (int k=0;k<edificio[i].length;k++){

                  if (edificio[i][k]){
                      departamento++;

                      System.out.print(ANSI_RED+"["+departamento+"]"+ANSI_RESET);
                  }else {
                      departamento++;
                      System.out.print(ANSI_GREEN+"["+departamento+"]"+ANSI_RESET);
                  }

              }
              System.out.println(" ");
          }
      }


      private int rutsapado(){

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



      public int verificarcant(int minimo, long  maximo, String Stesto){
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




      private String validarnombre(){
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





      private int pagamiento(int minimo,String testo){
        while (true){
            System.out.println("su edificio tiene un precio de " +testo+" millones");
            int pago =verificarcant(0,1000000000," pago ");
            if (pago>minimo){
                int vuelto=pago-minimo;
                System.out.println("su vuelto es :"+vuelto);
                return pago;
            } else if (pago==minimo) {
               return pago;
            } else {
                System.out.println("ingrese una cantidad mayor o igual");
            }
        }
      }




}
