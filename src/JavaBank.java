
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Owner
 */
public class JavaBank {
    static Prestamo prestamos[];
    static int cantPrestamos=0;
    static Scanner lea= new Scanner(System.in);


    public static void main(String[] argv){
        System.out.println("Cuantos prestamos irá a permitir?");
        int presti= lea.nextInt();
        prestamos= new Prestamo[presti];
    }

    private boolean AdicionCliente( char tipo){
        if (!(tipo=='V'||tipo=='A'))
            return false;
        int pos=0;
        for(Prestamo p: prestamos){
            if(p instanceof Prestamo)
                pos++;
            else
                break;
        }
        if(pos==prestamos.length)
            return false;
        System.out.println("Nombre del candidato a prestamo: ");
        String n= lea.next();
        System.out.println("Monto del prestamo: ");
        double m= lea.nextDouble();
        System.out.println("Numero de cuotas a pagar: ");
        int c= lea.nextInt();
        if (tipo=='A'){
            System.out.println("Ingrese el numero de serie del motor: ");
            String s= lea.next();
            prestamos[pos]= new Prestamo_auto(m,c,n,s);
            cantPrestamos++;
        }
        else{
            System.out.println("Usará Banprovi? \n1.Sí \n2.No");
            boolean b;
            respuesta:
            while(true){
                short op= lea.nextByte();
                switch(op){
                    case 1:
                        b=true;
                        break respuesta;
                    case 2:
                        b= false;
                        break respuesta;
                    default:
                        System.out.println("Respuesta no reconocida.");
                }
            }
            prestamos[pos]= new Prestamo_vivienda(m,c,n,b);
        }
        return true;
    }

   static double montoTotalPendiente( ){
       double mTP=0;
       for(Prestamo p: prestamos)
           if(p instanceof Prestamo)
           mTP = mTP + p.getsaldoPendiente();
       return mTP;
   }

   static void ImprimirDetalleMensual(){
       for(Prestamo p: prestamos)
           if(p instanceof Prestamo){
               p.imprimir();
               if(p instanceof Prestamo_vivienda)
                    System.out.println("Tipo: vivienda");
                if(p instanceof Prestamo_auto)
                    System.out.println("Tipo: auto");
           }
   }
}
