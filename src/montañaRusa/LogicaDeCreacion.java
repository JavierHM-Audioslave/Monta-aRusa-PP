package monta�aRusa;

import java.io.*;
import javax.swing.JOptionPane;

public class LogicaDeCreacion {
	
	Monta�a miMonta�a;
	Integer posXInicial;
	
	public LogicaDeCreacion()
	{
		File archIn;
		FileReader fr;
		BufferedReader br;
		try
		{
			archIn=new File(JOptionPane.showInputDialog("Ingrese el PATH completo de entrada"));
			fr=new FileReader(archIn);
			br=new BufferedReader(fr);
			int cantDeCimasYValles=Integer.parseInt(br.readLine());
			//int cantDeCimasYValles=Integer.parseInt(br.readLine());
			miMonta�a=new Monta�a((float)cantDeCimasYValles);
			for(int i=0; i<cantDeCimasYValles; i++)
			{
				if(i%2==0)
				{
					miMonta�a.setElementoDeCima(Integer.parseInt(br.readLine()));
				}
				else
				{
					miMonta�a.setElementoDeValle(Integer.parseInt(br.readLine()));
				}				
			}
			posXInicial=Integer.parseInt(br.readLine());
			
			try
			{
				fr.close();
				br.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	public void generarSalida()
	{
		File archSal;
		FileWriter fw;
		PrintWriter pw;
		int velAcumulada=0;
		int posYDelCoche=posInicialY(-1,posXInicial);
		int flag1=0, flag2=0;
		int acumDeX=0;
		for(int i=0; i<miMonta�a.getArrDeCima().length+miMonta�a.getArDeValle().length-1; i++)
		{
			if(i%2==0)
			{
				velAcumulada+=Math.abs(miMonta�a.getArDeValle()[flag2]-posYDelCoche);
				posYDelCoche=miMonta�a.getArDeValle()[flag2];
				acumDeX+=posXRespectoDeUnaY(-1,flag1,miMonta�a.getArDeValle()[flag2]);
				flag1++;
				velAcumulada--;
			}
			else
			{
				if(velAcumulada>=Math.abs(miMonta�a.getArrDeCima()[flag1]-miMonta�a.getArDeValle()[flag2]))
				{
					velAcumulada-=Math.abs(miMonta�a.getArDeValle()[flag2]-miMonta�a.getArrDeCima()[flag1]);
					posYDelCoche=miMonta�a.getArrDeCima()[flag1];
					acumDeX+=posXRespectoDeUnaY(1,flag2,miMonta�a.getArrDeCima()[flag1]);
					flag2++;
				}
				else
				{
					posYDelCoche=miMonta�a.getArDeValle()[flag2]+velAcumulada;
					velAcumulada=0;
					break;
				}
			}
		}
		
		int posXDelCarrito=acumDeX+posXRespectoDeUnaY(1,flag2,posYDelCoche);
		
		try
		{
			archSal=new File(JOptionPane.showInputDialog("Ingrese el path completo del archivo de salida"));
			fw=new FileWriter(archSal);
			pw=new PrintWriter(fw);
			pw.print(posXDelCarrito+" "+posYDelCoche);
			try
			{
				fw.close();
				pw.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/*private int obtenerPendiente(int y2, int y1, int x2, int x1)
	{		
		return (y2-y1)/(x2-x1);
	}*/
	
	private int posInicialY(int pendiente, int posXInicial)
	{
		int b=miMonta�a.getArrDeCima()[0]-pendiente*0;
		return pendiente*posXInicial+b;
	}
	
	private int posXRespectoDeUnaY(int pendiente, int flag2, int posYFin)
	{
		if(pendiente==1)
		{
			//flag1--;
			int b=miMonta�a.getArDeValle()[flag2];
			int posXFinal=(posYFin-b)/pendiente;
				
			return posXFinal;
		}
		else
		{
			//flag1--;
			int b=miMonta�a.getArrDeCima()[flag2];
			int posXFinal=(posYFin-b)/pendiente;
				
			return posXFinal;
		}
	}

}
