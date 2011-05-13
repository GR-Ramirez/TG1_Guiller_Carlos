/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CARLOS TALENO
 */
public class Prestamo_auto extends Prestamo {
private String serieAutoMotor;
Cuota cuotaSeguro [];


public Prestamo_auto(double mon, int np,String nom, String motor){
        super(mon,np,nom);
        this.serieAutoMotor=motor;
        cuotaSeguro = new Cuota [np];
        for (Cuota y: cuotaSeguro)
             y=new Cuota(200);
}

public double getTasaInteres(){
           return 0.20;
    }

    public double getSaldoPendiente(){
        double retraso=0;
          for(Cuota x: cuotas){
              if(!(x.pagada)){
               retraso+= x.pago_mensual;
              }
           }
          for(Cuota x: cuotaSeguro){
              if(!(x.pagada)){
               retraso+= x.pago_mensual;
              }
           }
          return retraso;
    }


}
