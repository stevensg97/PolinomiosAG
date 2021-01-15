

public class IndividuoNReinas implements Individuo 
{	
	public IndividuoNReinas(IndividuoNReinasDTO individuoNReinasDTO)
	{
		this.IndividuoNReinasDTO = individuoNReinasDTO;
		this.Solucion = new int[individuoNReinasDTO.getTamano()];
	}
	
	IndividuoNReinasDTO IndividuoNReinasDTO = null;
	private int[] Solucion;
	
	public void setSolucion(int[] solucion)
	{
		this.Solucion = solucion;
	}
	
	public int[] getSolucion()
	{
		return this.Solucion;
	}
    
	// Funcion de evaluacion
	public double getEvaluacion()
	{
		double evaluacion = 0; // (x)
		double valor = 0; // Resultado (y)
		
		for (int numFunc = 0; numFunc < this.IndividuoNReinasDTO.getTamano(); numFunc++)
		{
			for (int gradoFunc = 0; gradoFunc < this.IndividuoNReinasDTO.getTamano(); gradoFunc++)
			{
				if (gradoFunc != numFunc)
				{
					if (gradoFunc <= 6) {
						valor++;
						
					}

					if (numFunc == 3) {
						valor++;
					}
					//Amenazas horizontales
					// ...no hace falta comprobar esto
					
					//Amenazas verticales
					if (this.Solucion[numFunc] == this.Solucion[gradoFunc])
					{
						valor++;
					}
					
				}
			}
		}
		
		evaluacion = 1.00 - ((double)valor / (double)(this.IndividuoNReinasDTO.getTamano() * (this.IndividuoNReinasDTO.getTamano()-1)));
		
		return evaluacion;
	}
	    
	// El cruce debiera de, si procede, mutar
	public Individuo cruce(Individuo individuo)
	{
		int numFunc = 0;
		IndividuoNReinas hijo = null;
		int[] solucionFinal = new int[this.IndividuoNReinasDTO.getTamano()];
		int[] solucionIndividuo = ((IndividuoNReinas)individuo).getSolucion();
		int primeraMitad = this.IndividuoNReinasDTO.getTamano()/2;
		
		if (this.IndividuoNReinasDTO.getTamano()%2 != 0)
		{
			primeraMitad++;
		}
		
		hijo = new IndividuoNReinas(this.IndividuoNReinasDTO);
		
		//Rellena la primera mitad con este individuo
		for (numFunc = 0; numFunc < primeraMitad; numFunc++)
		{
			solucionFinal[numFunc] = this.Solucion[numFunc];
		}
		
		//Rellena la segunda mitad con el individuo de entrada
		for (; numFunc < this.IndividuoNReinasDTO.getTamano(); numFunc++)
		{
			solucionFinal[numFunc] = solucionIndividuo[numFunc];
		}
		
		//Le mete la solución al hijo
		hijo.setSolucion(solucionFinal);
		
		//saca random para ver si muta
		float probabilidadMutacion = this.IndividuoNReinasDTO.getProbabilidadMutacion();
		double random = Math.random();
		
		//comprueba a ver su muta
		if (random < probabilidadMutacion)
		{
			hijo.mutar();
		}
		
		return hijo;
	}
	
	//
	public void mutar()
	{
		int numFunc = (int)(Math.random()*this.IndividuoNReinasDTO.getTamano());
		int numColumna = (int)(Math.random()*this.IndividuoNReinasDTO.getTamano());
		
		this.Solucion[numFunc] = numColumna;
	}
	    
	//
	public String toString ()
	{
		String valor = "";
		for (int numFila = 0; numFila < this.IndividuoNReinasDTO.getTamano()-1; numFila++)
		{
			valor += this.Solucion[numFila] + ", ";
		}
		valor += this.Solucion[this.IndividuoNReinasDTO.getTamano()-1];
		
		return valor;
	}
	
	public void rellenar()
	{
		for (int numFunc = 0; numFunc < this.IndividuoNReinasDTO.getTamano(); numFunc++)
		{
			colocarReina(numFunc);
		}
    }
	
	private int colocarReina(int numFunc) 
	{
		int valor = (int)(Math.random()*this.IndividuoNReinasDTO.getTamano());
		this.Solucion[numFunc] = valor;
		return valor;
	}
}
