package montañaRusa;

import java.util.ArrayList;

public class Montaña {
	
	private Integer[] arrDeCima;
	private Integer[] arrDeValle;
	private Integer topeDeCimaIngresada;
	private Integer topeDeValleIngresado;
	
	public Montaña(float cimasYValles)
	{
		Integer cimas=(int) Math.ceil(cimasYValles/2);
		Integer valles=(int)cimasYValles-cimas;
		arrDeCima=new Integer[cimas];
		arrDeValle=new Integer[valles];
		topeDeCimaIngresada=0;
		topeDeValleIngresado=0;
	}

	public Integer[] getArrDeCima() {
		return arrDeCima;
	}

	public void setArrDeCima(Integer[] arrDeCima) {
		this.arrDeCima = arrDeCima;
	}
	
	public void setElementoDeCima(Integer elemento)
	{
		arrDeCima[topeDeCimaIngresada]=elemento;
		topeDeCimaIngresada++;
	}

	public Integer[] getArDeValle() {
		return arrDeValle;
	}

	public void setArDeValle(Integer[] arrDeValle) {
		this.arrDeValle = arrDeValle;
	}
	
	public void setElementoDeValle(Integer elemento)
	{
		arrDeValle[topeDeValleIngresado]=elemento;
		topeDeValleIngresado++;
	}

}
