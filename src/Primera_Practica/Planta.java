

package Primera_Practica;
//A01378844 JESUS OMAR CUENCA ESPINO
//A01373707 Omar Alejandro Castañeda Gomez

public abstract class Planta extends Empleado {

	protected double pagoSemanal;
	protected boolean[] prestaciones;
	protected double diaVacaciones;
	protected String nombrePuesto;
	
	private static final String [] PRESTACIONES = {"Vales despensa", "Afore", "Infonavit", "Vacaciones Semana Santa", 
				"Vacaciones Verano", "Descuento proveedores afiliados", "Seguro de auto", "Seguro de vida"}; 
        private static final double [] PAGO_PRESTACIONES = {1000, 0.2, 0.1, 7, 2, 0.25, 5000, 25000}; 				 
	private static final double PORCENTAJE_PLANTA = 0.1;			
	private static final int MAXIMO_SUELDO = 25000;
	
	

	public Planta( String nombre, String apellido, int antiguedad, double pagoSemanal, boolean[] prestaciones) {
		super(nombre, apellido, antiguedad);
		/*
		 * TODO: 
		 * Constructor de la clase Planta.
		 * 1. Inicializa el atributo  de instancia del arreglo de prestaciones con los valores
		 *    del arreglo de prestaciones que recibe de par�metro.
		 * 2. Valida que el atributo de instancia, pagoSemanal, se inicialice con un valor entre 0 y MAXIMO_SUELDO.
		 *    En caso contrario, se asigna 0.
		 * 3. El atributo de instancia, diaVacaciones, se inicializa con el pagoSemanal * antiguedad * PORCENTAJE_PLANTA. 
		 */
                if (pagoSemanal<0 || pagoSemanal>MAXIMO_SUELDO)
                    pagoSemanal=0;
                this.pagoSemanal=pagoSemanal;
                this.prestaciones=prestaciones.clone();
                this.diaVacaciones=(this.pagoSemanal*this.antiguedad*PORCENTAJE_PLANTA);
	}
   
   
    private String regresaPrestaciones() {
    	/*
    	 * TODO: 
    	 * M�todo privado que recorre el arreglo de instancia de prestaciones y si tiene un valor de true en la posici�n i,
    	 * entonces crea una cadena con el nombre de la prestaci�n correspondiente. Los nombres de las prestaciones est�n en
    	 * el arreglo est�tico PRESTACIONES, en la misma posici�n i. As�, si prestaciones[0] = true, entonces la prestaci�n
    	 * correspondiente es PRESTACIONES[0] (que es �Vales despensa�).
    	 */
        String pres="";
        boolean cuenta=true;
        for (int i=0;i<this.prestaciones.length;i++){
            if(this.prestaciones[i]){
            if(cuenta){
                pres+=PRESTACIONES[i];cuenta=false;}
            else
                pres+=", "+PRESTACIONES[i];}
        }
    	
        return pres;
	}
	
	@Override
	public double sueldo() { 
		/*
		 * TODO:
		 * Calcula el sueldo de un empleado de Planta de la siguiente manera:
		 *    El sueldo inicial es el pagoSemanal.
		 * A ese sueldo se le agregan las prestaciones de la siguiente forma:
		 *    Si el arreglo de instancia de prestaciones tiene un valor de true en la posici�n i, donde i es:
		 *       0, 6, 7: sumarle al sueldo el PAGO_PRESTACIONES de la misma posici�n i
		 *       1, 2, 5: sumarle al sueldo el PAGO_PRESTACIONES de la misma posici�n i multiplicado por el pagoSemanal
		 *       3, 4: sumarle al sueldo el PAGO_PRESTACIONES de la misma posici�n i multiplicado por diaVacaciones
		 */
                double sueldo=this.pagoSemanal;
                for (int i=0;i<this.prestaciones.length;i++){
                    if (prestaciones[i]==true){
                        switch (i){
                            case 0:case 6:case 7:
                                sueldo+=PAGO_PRESTACIONES[i];
                                break;
                            case 1:case 2:case 5:
                                sueldo+=(PAGO_PRESTACIONES[i]*this.pagoSemanal);
                                break;
                            case 3:case 4:
                                sueldo+=(PAGO_PRESTACIONES[i]*this.diaVacaciones);
                                break;
                            default:
                                break;
                        }
                    }
                }
                
		return sueldo;
	}
	
    public void setPagoSemanal( double pagoSemanal ) { 
		if (pagoSemanal > 0 && pagoSemanal <= MAXIMO_SUELDO)
			this.pagoSemanal = pagoSemanal;
	}
    
   @Override
    public String toString() {
		return "\n***  Empleado de Planta  ***\n" + super.toString() + "\nCon puesto: " + this.getNombrePuesto() +
				"\nPago semanal: " + this.pagoSemanal + "\nSueldo integrado: " + this.sueldo() + "\nPrestaciones: " + this.regresaPrestaciones();
	}
	
	public String getNombrePuesto() {
		return this.nombrePuesto;
	}
	
        
        public abstract void setNombrePuesto(String nombrePuesto);
	/*
	 * TODO:
	 * Crear m�todo p�blico abstracto de nombre setNombrePuesto.
	 * El m�todo no regresa nada.
	 * El m�todo recibe una cadena de caracteres con el nombre del puesto (nombrePuesto).
	 */
}