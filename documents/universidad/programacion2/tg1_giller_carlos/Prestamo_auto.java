/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CARLOS TALENO
 */
public class Prestamo_auto extends Prestamo {
private String Serie;
private String auto;
private String motor;

public Prestamo(double mon, int np,String nom, boolean usa){
        super(mon,np,nom);
        Cuota cuotaSeguro [] = new Cuota [np];
        for (Cuota y: cuotaSeguro)
             y=new cuota (200);
}

public double getTasa_Interes(){
           return 0.20;
    }

    public double getSaldo_Pendiente(){
        double retraso=0;
          for(Cuota x: cuotas){
              if(!x.pagada){
               retraso=retraso+x.pago_mensual;
              }
           }
          return retraso;
    }


}
