

// Clase PolinomioDTO

public class PolinomioDTO 
{

	// Constructores
	public PolinomioDTO(float pm)
	{
		if (pm > 1)
		{
	        this.ProbabilidadMutacion = 1;
		}
		else if (pm < 0)
		{
        	this.ProbabilidadMutacion = 0;
		}
	    else
	    {
			this.ProbabilidadMutacion = pm;
	    }
	}
	
	// Atributos

	private float ProbabilidadMutacion;

	private float Coeficientes[];

	private int Grado;
	    
	// Métodos 
	
	public float getProbabilidadMutacion()
	{
		return ProbabilidadMutacion;
	}
	    
	public void setProbabilidadMutacion(float pm)
	{
		if (pm > 1)
		{
	        this.ProbabilidadMutacion = 1;
		}
		else if (pm < 0)
		{
        	this.ProbabilidadMutacion = 0;
		}
	    else
	    {
			this.ProbabilidadMutacion = pm;
	    }
	}

	public float[] getCoeficientes(){
		return this.Coeficientes;
	}
}
