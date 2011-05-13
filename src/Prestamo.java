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
    }
    abstract double  saldoPendiente();
    abstract double  getTasaInteres( );
}
