



public class PolinomioSolucionDTO extends PolinomioDTO 
{
	
	public PolinomioSolucionDTO(float pm, int tam)
    {
        super(pm);
        this.tamano = tam;
    }
	
	private int tamano;
	
	public int getTamano()
	{
		return this.tamano;
	}
}
