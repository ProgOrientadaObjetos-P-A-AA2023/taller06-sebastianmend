/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejecutor;
import taller06.*;
import java.util.Scanner;

/**
 *
 * @author sebas
 */
public class Ejecutor {
    public static void main(String[] args) { 
        Scanner entrada = new Scanner(System.in);
        
        String nombreHospital;
        String direcc;
        String nombreCiudad;
        String provincia;
        int numEspecialidades;
        int numDoc;
        int numEnfermeros;
        // Estas variables vamos a enviarlas a cada objeto       
        
        System.out.println("---Programa para administrar hospitales del país---");
        System.out.println("--Datos del hospital--");
        System.out.println("Ingrese el nombre: ");
        nombreHospital = entrada.nextLine();
        
        System.out.println("Ingrese la dirección: ");
        direcc = entrada.nextLine();
        
        System.out.println("Ingrese la ciudad en la que está ubicado: ");
        nombreCiudad = entrada.nextLine();
        
        System.out.println("Ingrese la provincia: ");
        provincia = entrada.nextLine();
        
        // Creamos un objeto de tipo ciudad para enviarle a la clase Hospital
        Ciudad ciudad = new Ciudad (nombreCiudad,provincia);        
        
        System.out.println("Ingrese el número de especialidades: ");
        numEspecialidades = entrada.nextInt();
        
        System.out.println("Ingrese el número de médicos: ");
        numDoc = entrada.nextInt();
        
        System.out.println("Ingrese el número de enfermeros(as): ");
        numEnfermeros = entrada.nextInt();       
        
        // Creamos dos arreglos uno de tipo Medico y otro de tipo Enfermero
        // Su tamaño serán dados por el usuario que dirá cuántos médicos y 
        // enfermeros hay en el hospital
        Medico[] medicos = new Medico [numDoc];
        Enfermero [] enfermeros = new Enfermero [numEnfermeros];
        
        String nombre;
        String apellido;
        String especialidad;
        String tipo;
        double sueldoMensual;
        // Creamos los siguientes ciclos que nos ayudarán a llenar los arreglos
        entrada.nextLine();
        
        for (int i=0; i<numDoc; i++) {
            System.out.println("Ingrese el nombre del médico ["+(i+1)+"]:");
            nombre = entrada.next();
            
            System.out.println("Ingrese el apellido del médico["+(i+1)+"]:");
            apellido = entrada.next();
            
            System.out.println("Ingrese la especialidad del médico ["+(i+1)+"]:");
            especialidad = entrada.next();
            
            System.out.println("Ingrese el sueldo mensual del médico["+(i+1)+"]:");
            sueldoMensual = entrada.nextDouble();
            
            medicos[i]= new Medico(nombre,apellido,especialidad,
                    sueldoMensual);
            // Llenamos el arreglo en la posición i con un objeto tipo Medico
        }
        
        entrada.nextLine();
        
        for (int i=0; i<numEnfermeros; i++) {
            System.out.println("Ingrese el nombre del enfermero["+(i+1)+"]:");
            nombre = entrada.next();
            
            System.out.println("Ingrese el apellido del enfermero["+(i+1)+"]:");
            apellido = entrada.next();
            
            System.out.println("Ingrese el tipo (nombramiendo o contrato)"
                    + "del enfermero ["+(i+1)+"]:");
            tipo = entrada.next();
            
            System.out.println("Ingrese el sueldo mensual del enfermero["+(i+1)+"]:");
            sueldoMensual = entrada.nextDouble();
            
            enfermeros[i]= new Enfermero(nombre,apellido,tipo,
                    sueldoMensual);
            // Llenamos el arreglo en la posición i con un objeto tipo Enfermero
        }
        
        Hospital hospital = new Hospital(nombreHospital,direcc,ciudad,
                medicos,enfermeros,numEspecialidades);
        // Por último creamos el objeti tipo Hospital y le enviamos los 
        // parpametros que necesita
        
        //Calculamos el total a pagar en cuanto a sueldos
        hospital.calcularSueldos(medicos, enfermeros);
        
        // Llamamos al método toString para imprimir
        System.out.printf("\n%s\n", hospital);
    }
        
    
    
}
