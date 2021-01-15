import java.util.*;


public class NReinas 
{

	/**
	 * @param args
	 */

    public static void main(String args [])
    {        
        //Declaracion de variables
        List<Individuo> poblacion = new ArrayList<Individuo>();
        IndividuoNReinasDTO inreinas = null;
        Evolucion evolucion = null;
        IndividuoNReinas elite = null;
        //parámetros default
        float probabilidadMutacion = (float)0.50;
        int tamano = 0;
        int tamPoblacion = 0;
        int modo = 0; 
        int cantidadGeneraciones = 0;
        
        //Validación parámetros de entrada
        if ((5 < args.length) || (args.length < 4))
        {
        	System.out.println("ERROR: numero incorrecto de parámetros");
        	return;
        }
        try
        {
        	probabilidadMutacion = Float.parseFloat(args[0]);
        }
        catch (Exception e)
        {
        	System.out.println("ERROR: el primer parámetro (probabilidad de mutación) tiene que ser flotante");
        }
        try
        {
	        tamano = Integer.parseInt(args[1]);
	        if (tamano < 4) tamano = 4;
	        
	        tamPoblacion = Integer.parseInt(args[2]);
	        if (tamPoblacion < 2) tamPoblacion = 2;
	        
	        modo = Integer.parseInt(args[3]);
        }
        catch (Exception e)
        {
        	System.out.println("ERROR: los parámetros del segundo en adelante tienen que ser número enteros");
        	return;
        }
        if (modo == 1 || modo == 2)
        {
            if (args.length != 5)
            {
            	System.out.println("ERROR: si el modo es 1 ó 2 tiene que ser 5 parámetros");
            	return;
            }
            try
            {
            	cantidadGeneraciones = Integer.parseInt(args[4]);
            }
            catch (Exception e)
            {
            	System.out.println("ERROR: solo se aceptan parámetros enteros");
            	return;
            }
        }
        else if (modo == 3)
        {
            if (args.length != 4)
            {
            	System.out.println("ERROR: si el modo es 3 tiene que ser 4 parámetros");
            	return;
            }
        }
        else
        {
        	System.out.println("ERROR: número de modo incorrecto");
        	return;
        }
        
        //Inicialización de IndividuoNReinasDTO
        inreinas = new IndividuoNReinasDTO(probabilidadMutacion, tamano);
        
        //Inicialización de la población
        for (int i = 0; i < tamPoblacion; i++)
        {
            poblacion.add(new IndividuoNReinas(inreinas));
            ((IndividuoNReinas) poblacion.get(i)).rellenar();
        }
         
        //Inicializar EvolucionImpl
        evolucion = new EvolucionImpl(poblacion);
        
    	//Crear las generaciones
    	switch (modo)
    	{
    	case 1:
    		do
    		{
    			evolucion.nextGeneration();
    		} while ((evolucion.getGenerationNumber() < cantidadGeneraciones)
    			&& (evolucion.getElite().getEvaluacion() < 1));
    		break;
    	case 2:
    		do
    		{
    			evolucion.nextGeneration();
    		} while ((evolucion.getEliteNoChanges() < cantidadGeneraciones)
    			&& (evolucion.getElite().getEvaluacion() < 1));
    		break;
    	case 3:
    		do
    		{
    			evolucion.nextGeneration();
    		} while (evolucion.getElite().getEvaluacion() < 1);
    		break;
    	}
    	
    	//Guardar solución o lo más cercano
    	elite = (IndividuoNReinas) evolucion.getElite();
    	
    	System.out.println();
    	System.out.println("##################################");
    	System.out.println();
    	
		//imprimir primera linea horizontal
		for (int numTabs = 0; numTabs < tamano; numTabs++)
		{
			System.out.print("----");
		}
    	System.out.println("-");
    	
    	for (int numFila = 0; numFila < tamano; numFila++)
    	{
			System.out.print("| ");
    		for (int numTabs = 0; numTabs < elite.getSolucion()[numFila]; numTabs++)
    		{
    			System.out.print("  | ");
    		}
    		System.out.print("R |");
    		for (int numTabs = 0; numTabs < tamano-elite.getSolucion()[numFila]-1; numTabs++)
    		{
    			System.out.print("   |");
    		}
        	System.out.println();
        	
        	//imprimir línea horizontal divisoria
    		for (int numTabs = 0; numTabs < tamano; numTabs++)
    		{
    			System.out.print("----");
    		}
        	System.out.println("-");
    	}
    	
    	System.out.println();
    	if (evolucion.getElite().getEvaluacion() < 1)
    	{	//no encontró la solución
    		System.out.println("No se pudo encontrar la solución");
    	}
    	else
    	{	//sí encontró la solución
    		System.out.println("SE ENCONTRÓ LA SOLUCIÓN!!!");
    	}
		System.out.println("Resultado final en la generación " + evolucion.getGenerationNumber() + ": " + elite.toString());
    	System.out.println("El élite se actualizó " + evolucion.getEliteChanges() + " veces.");
    }
}

	
	

	
