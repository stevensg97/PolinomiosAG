

// Librerias

import java.util.*;

// Clase EvolucionImpl

public class EvolucionImpl implements Evolucion
{	
    public EvolucionImpl(List<Individuo> poblacion)
    {
    	this.Poblacion = poblacion;
    }
    
    int NumEliteAnterior = -1;
    int NumEliteActual = -1;
    IndividuoNReinas Elite = null;
    List<Individuo> Poblacion = null;
    int NumGeneration = 0;
    int NumEliteChanges = 0;
    int NumEliteNoChanges = 0;
    
    public List<Individuo> getPoblacion()
    {
    	return this.Poblacion;
    }
    
    public void nextGeneration ()
    {
    	this.NumEliteActual = getNumElite();
    	this.Elite = (IndividuoNReinas) getElite();
    	
    	for (int numIndividuo = 0; numIndividuo < this.Poblacion.size(); numIndividuo++)
    	{
    		if (numIndividuo != this.NumEliteActual)
    		{
    			this.Poblacion.set(numIndividuo, this.Elite.cruce(this.Poblacion.get(numIndividuo)));
    		}
    	}

        this.NumGeneration++;
        
        if ((this.NumGeneration % 20 == 0) || (this.NumGeneration == 1))
        {
        	System.out.println("Generación número " + this.NumGeneration + ": " + this.Elite.toString());
        }
    }
    
    public int getGenerationNumber()
    {
    	return this.NumGeneration;
    }
    
    public int getEliteChanges()
    {
    	return this.NumEliteChanges;
    }
    
    public int getEliteNoChanges()
    {
    	return this.NumEliteNoChanges;
    }
    
    // Necesito dos atributos, el de la nueva generacion y el de la vieja
    
    public Individuo getElite()
    {
    	return this.Poblacion.get(this.NumEliteActual);
    }
    
    private int getNumElite()
    {
        double evaluacionTemp = 0;
        double mejorEvaluacion = 0;
        
        this.NumEliteAnterior = this.NumEliteActual;
        
    	//Seleccionar el élite
    	for (int numIndividuo = 0; numIndividuo < this.Poblacion.size(); numIndividuo++)
    	{
    		evaluacionTemp = ((IndividuoNReinas) this.Poblacion.get(numIndividuo)).getEvaluacion();
    		if (mejorEvaluacion <= evaluacionTemp)
    		{
            	mejorEvaluacion = evaluacionTemp;
            	this.NumEliteActual = numIndividuo;
    		}
    	}
    	
    	if (this.NumEliteAnterior == this.NumEliteActual)
    	{
    		this.NumEliteNoChanges++;
    	}
    	else
    	{
    		this.NumEliteChanges++;
    		this.NumEliteNoChanges = 0;
    	}
    	
    	return this.NumEliteActual;
    }
}
