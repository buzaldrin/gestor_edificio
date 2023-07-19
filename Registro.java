import java.util.ArrayList;

public class Registro {

    private int rut;
    private int piso;
    private int departemanto;
    private Persona persona;


    public Registro(int rut, Persona persona,int piso, int departemanto) {
        this.rut=rut;
        this.persona = persona;
        this.piso = piso;
        this.departemanto = departemanto;

    }


    public Registro(int rut,int piso, int departemanto) {
        this.rut=rut;
        this.piso = piso;
        this.departemanto = departemanto;

    }



    public int consulatarDatos(){
        return rut;
    }

    public int getPiso() {
        return piso;
    }

    public int getDepartemanto() {
        return departemanto;
    }

    @Override
    public String toString() {
        return "Registro: " +"\n"+
                "> persona= " + persona.verDatos() +"\n"+"rut: "+rut+"\n"+
                "> piso= " + piso +"\n"+
                "> departemanto= " + departemanto ;
    }


}
