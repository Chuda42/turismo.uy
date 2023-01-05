package logica.clases;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ContadorVisitas {
	private Map<String, Integer> registro;
	//private TreeMap<String, Integer> registro;
	private static ContadorVisitas instancia = null;
	
	private ContadorVisitas() {
		registro = new HashMap<String, Integer>();
	}
	
	private Map<String, Integer> valueSort(Map<String, Integer> map){
        Comparator<String> valueComparator = new Comparator<String>() {
            
				public int compare(String k1, String k2){
                	  
                	  Integer absK1 = map.get(k1);
                	  Integer absK2 = map.get(k2);
                	  
                	  int i = absK1.intValue();
                	  int j = absK2.intValue();
                	  
                	  if(Math.abs(i) > Math.abs(j))
                		  return -1;
                	  else
                		  return 1;
                  }
            
              };
              
        Map<String, Integer> sorted = new TreeMap<String, Integer>(valueComparator);
        
        sorted.putAll(map);
        
        return sorted;
    }
	
	public static ContadorVisitas getInstance() {
		if (instancia == null)
            instancia = new ContadorVisitas();
        return instancia;
	}

	public void agregar(String nombre, boolean esActividad) {
		if(esActividad) {
			
			if(registro.containsKey(nombre)) {
				int visitas = registro.get(nombre);
				registro.put(nombre, visitas + 1);
			}
			else {
				registro.put(nombre, 1);
			}
			
		}else {
			
			if(registro.containsKey(nombre)) {
				int visitas = registro.get(nombre);
				registro.put(nombre, visitas - 1);
			}
			else {
				registro.put(nombre, -1);
			}
		}
		
	}
	
	public LinkedHashMap<String, Integer> getTop10(){
		Map<String, Integer> ordenados = new HashMap<String, Integer>();
		LinkedHashMap<String, Integer> res = new LinkedHashMap<String, Integer>();
		ordenados = valueSort(registro);
		
		int count = 0;
		for (Map.Entry<String,Integer> entry:ordenados.entrySet()) {
		     if (count >= 10) break;

		     res.put(entry.getKey(), entry.getValue());
		     count++;
		  }
			
		return res;
	}
}