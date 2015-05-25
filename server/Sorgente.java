package server;

public abstract class Sorgente {
	//Oggetto container per i dati personali
	protected IData dati;
	//Cerca i dati sulla sorgente
	public abstract void FillData(final String name);
	//Ritorna i dati della sorgente
	public abstract IData GetData();
}
