
package Primera_Practica;
//A01378844 JESUS OMAR CUENCA ESPINO
//A01373707 Omar Alejandro Castañeda Gomez

public class Secretaria extends Planta {

	public Secretaria( String nombre, String apellido, int antiguedad, boolean[] prestaciones, double pagoSemanal, String nombrePuesto) {
		super( nombre, apellido, antiguedad, pagoSemanal, prestaciones);  
		setNombrePuesto(nombrePuesto);
	}
   
   
   public String toString() {
		return "\n\n***  Secretaria  ***\n" + super.toString() + "\nSueldo integrado: " + this.sueldo();
	}
	
	
	public void setNombrePuesto(String nombre){
		this.nombrePuesto = nombre;
	}
	
	
	public String llenaRegistros() {
		return "llena los registros de los empleados del departamento";
	}
	
}