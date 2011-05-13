/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public abstract class Prestamo {
    protected double montoPrestamo;
    protected String nombre;
    Cuota[] cuotas;

    public Prestamo(double monto, int numPagos, String nom){
        montoPrestamo= monto;
        nombre= nom;
        cuotas= new Cuota[numPagos];
        double mensualBasico= monto/numPagos;
        double inte= 1+getsaldoPendiente();
        llenarCuotas(mensualBasico*inte);
    }
    abstract double  getsaldoPendiente();
    abstract double  getTasaInteres( );

    public void llenarCuotas(double pg){
        for(Cuota cuot: cuotas)
            cuot= new Cuota(pg);
    }

    public void imprimir(){
        System.out.println("Nombre de cliente:" + nombre );
    }
}
