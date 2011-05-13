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
        double inte=1+getTasaInteres();
        llenarCuotas(mensualBasico*inte);
    }
    abstract double  getSaldoPendiente();
    abstract double  getTasaInteres( );

    public void llenarCuotas(double pg){
        for(int i=0; i<cuotas.length; i++)
            cuotas[i]= new Cuota(pg);
    }

    public void imprimir(){
        System.out.println("Nombre de cliente:" + nombre );
    }
}
