import java.util.Scanner;
import java.util.ArrayList;

    public class Edificio {


        private ArrayList<Registro> registros;

        private ArrayList<Persona> personas;
        private Persona persona;



        private final static Scanner sc=new Scanner(System.in);

        private final boolean[][] edificio =new boolean[10][4];
        private int rut;
        private static final String ANSI_RESET = "\u001B[0m";
        private static final String ANSI_RED = "\u001B[31m";
        private static final String ANSI_GREEN = "\u001B[32m";
        private String nombre;
        private int ganacias=0;
        private int rutt;
        private  int piso;
        private int depa;

        public Edificio() {
            this.registros = new ArrayList<>();
            this.personas=new ArrayList<>();
            this.persona = new Persona();
        }


        public void compra(){
            /*int piso = verificarcant(0, 11, " el piso ");
            int columa = verificarcant(0, 5, " el departamento ");
            int por2;
            int pisop = piso;
            int departamento = columa;
            por2 = piso * 2;
            piso += edificio.length;
            columa -= 1;
            int comversion;
            comversion = piso - por2;*/ //porsiacaso

            int []resultados=PisoDepa();
             piso=resultados[0];
             depa=resultados[1];
             int piso2=resultados[2];
             int departamento=resultados[3];
            if (!edificio[piso][depa]){
                edificio[piso][depa] = true;
                rut=persona.rutsapado();


               if (existencia()){
                   System.out.println("ya esta registrado en el sistema");

                   for (Persona p:personas) {
                       rutt = p.getRut();
                       if (rut == rutt) {
                            nombre=p.getNombre1();
                       }
                   }


               }else {
                   nombre=persona.validarnombre();
               }

                int pago;
                if (piso<=2){
                    pago=pagamiento(200000000,"200");
                    ganacias+= pago;

                }else {
                    pago=pagamiento(150000000,"150");
                    ganacias+= pago;
                }
                if (!existencia()){
                            Persona p =new Persona(nombre,rut);
                            this.personas.add(p);

                }
                Persona p =new Persona(nombre,rut);
                Registro registro=new Registro(rut,p,piso2,departamento);
                this.registros.add(registro);

                System.out.println("compra realiza con exito");
            }else {
                System.out.println("ese departamento esta ocupado");
            }

        }


        public void buscar_dueno(){
            int  cont=0;
            rut=persona.rutsapado();
            for (Registro r:registros){
                rutt=r.consulatarDatos();
                if (rut==rutt){
                        System.out.println(r);

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




        private static int verificarcant(int minimo, long  maximo, String Stesto){
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

    public int verGanancias(){
            return  ganacias;
    }

    private boolean existencia() {
        boolean econtrado = false;
        for (Registro r : registros) {
            rutt = r.consulatarDatos();
            if (rutt == rut) {
                econtrado = true;
            }

        }
        return econtrado;

    }

    private int[] PisoDepa(){
        int pis = verificarcant(0, 11, " el piso ");
        int columa = verificarcant(0, 5, " el departamento ");
        int por2;
        int pisop = pis;
        int departamento = columa;
        por2 = pis * 2;
        pis += edificio.length;
        columa -= 1;
        int comversion;
        comversion = pis - por2;
        int[]valores={comversion,columa,pisop,departamento};

        return valores;
    }

    public void  eliminarDueno(){


            int []resultados=PisoDepa();
            piso=resultados[0];
            depa=resultados[1];
            int piso2=resultados[2];
            int departamento=resultados[3];

        rut=persona.rutsapado();
        for (Registro r:registros){
            rutt=r.consulatarDatos();
            if (rut==rutt){
                    int p=r.getPiso();
                    int d=r.getDepartemanto();
                  if (d==departamento && p==piso2){
                      registros.remove(r);
                      break;
                  }
                }
            }
            edificio[piso][depa]=false;
        }



    }


