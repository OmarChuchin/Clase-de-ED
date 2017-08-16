
package Primera_Practica;

public abstract class Empleado {

	protected String nombre;
	protected String apellido;
	protected int antiguedad;

	public Empleado( String nombre, String apellido, int antiguedad ) {
		this.nombre = nombre;
		this.apellido = apellido;
		
		if (antiguedad > 0)
			this.antiguedad = antiguedad;
	}	
   
	public String getNombre() { 
		return nombre; 
	}

	public String getApellido() { 
		return apellido; 
	}
	
	public void setAntiguedad(int antiguedad) {
		if (antiguedad > this.antiguedad)
			this.antiguedad = antiguedad;
	}

	protected abstract double sueldo(); 
	
	public String toString() {
		return "\nNombre: " + this.nombre + "\nApellido: " + this.apellido + "\nAntiguedad: " + this.antiguedad;
	}
}
