package server;

public abstract class Sorgente {
	//Cerca i dati sulla sorgente
	abstract void FillData(final String name);
	//Ritorna i dati della sorgente
	abstract IData GetData();
}
