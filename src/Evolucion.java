

// Librerias

import java.util.*;

// Clase Evolucion

public interface Evolucion 
{
    public List<Polinomio> getPoblacion();
    
    public void nextGeneration();
    
    public int getGenerationNumber();
    
    public int getEliteChanges();
    
    public int getEliteNoChanges();
    
    // Necesito dos atributos, el de la nueva generacion y el de la vieja
    
    public Polinomio getElite();
}
