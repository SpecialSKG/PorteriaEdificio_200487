package Controlador;

import Conexion.Conex;
import Dao.EntradasDao;
import Modelo.Entradas;
import java.util.List;
import java.util.Scanner;

public class EntradasController {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Entradas Ent = new Entradas(0);
        Conex conn = new Conex();
        EntradasDao Entd = new EntradasDao(conn);
        
        int op = 1;
        
        while (op == 1 || op == 2) {            
            System.out.println("Que desea hacer? \n"
                    + "1. Guardar \n"
                    + "2. Ver Lista \n"
                    + "3. Salir");
            op = scan.nextInt();
            System.out.println("-------------");
            switch(op){
                case 1:
                    System.out.println("Ingrese Nombre");
                    Ent.setNombre(scan.next());
                    System.out.println("Ingrese Apellido");
                    Ent.setApellido(scan.next());
                    System.out.println("Ingrese Nª de Habitacion");
                    Ent.setHabitacion(scan.nextInt());
                    
                    boolean resp = Entd.Insertar(Ent);
                    if (resp) {
                        System.out.println("Registro Guardado con Exito");
                        System.out.println("-------------");
                    } else {
                        System.out.println("Error en Guardado");
                        System.out.println("-------------");
                    }
                break;
                case 2:
                    List<Entradas> list = Entd.selectAll();
                    for (Entradas entra :list) {
                        System.out.println("El Nombre es: " + entra.getNombre());
                        System.out.println("El Apellido es: " + entra.getApellido());
                        System.out.println("La Habitacion es: " + entra.getHabitacion());
                        System.out.println("La Fecha de Entrada es: " + entra.getEntrada());
                        System.out.println("------------------------");
                    }
                break;
            }
        }
    }
}
