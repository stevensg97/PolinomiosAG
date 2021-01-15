

// Clase Polinomio

public interface Polinomio 
{
    // Funcion de evaluacion
    
    public double getEvaluacion();
    
    // El cruce debiera de, si procede, mutar
	
    public Polinomio cruce(Polinomio Polinomio);
    
    // Funcion de mutación
    
    public void mutar();
    
    // Pasar cualquier parametro por String
    
    public String toString();
}
