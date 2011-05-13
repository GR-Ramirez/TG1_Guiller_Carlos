/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CARLOS TALENO
 */
public class Prestamo_vivienda extends Prestamo{
    private boolean usa_Banprovi;

    public Prestamo(double mon, int np,String nom, boolean usa){
        super(mon,np,nom);
        usa_Banprovi=usa;
    }

    public double getTasaInteres(){
        if(usa_Banprovi){
            return 0.20;
        }
           return 0.15;
    }

    public double getsaldoPendiente(){
        double retraso=0;
          for(Cuota x: cuotas){
              if(!x.pagada){
               retraso=retraso+x.pago_mensual;
              }
           }
          retraso=retraso+57,000;
          return retraso;
    }

}
