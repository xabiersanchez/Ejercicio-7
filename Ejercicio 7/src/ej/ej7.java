/* XABIER SANCHEZ VALERO
https://github.com/xabiersanchez/Ejercicio-7.git */

package ej;

import java.util.Scanner;

public class ej7 {
	
public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Dime cuantas zonas quieres que haya: ");
		int nzonas = sc.nextInt();
		System.out.println("");
		
		String[] aNombreZonas = new String[nzonas];
		int[][] aAreasFactdens = new int[2][nzonas];
		boolean continuar = false;
		int agregar;
		int i;
		int comienza = 0;
		
		
		do {
			for(i = comienza; i < nzonas; i++) {
				System.out.print("Dime el nombre de la zona numero " + (i+1) + ": ");
				aNombreZonas[i] = sc.next();
				
				System.out.println("Dime el area y Factor de densidad de la zona numero " + (i+1));
				System.out.print("Area: ");
				aAreasFactdens[0][i] = sc.nextInt();
				
				System.out.print("Factor de densidad: ");
				aAreasFactdens[1][i] = sc.nextInt();
				System.out.println("");
			}
			
			do {
				System.out.print("Quieres añadir más zonas? (0 no / 1 si): ");
				 agregar = sc.nextInt();
				
				if(agregar == 0) {
					continuar = false;
					System.out.println("");
				}
				else if(agregar == 1) {
					continuar = true;
					System.out.print("Cuantas zonas? ");
					int amplia = sc.nextInt();
					System.out.println("");
					
					int[][] aAreasFactdensAmpl = new int[2][nzonas + amplia];
					String[] aNombreZonasAmpl = new String[nzonas + amplia];
					
					for(int x = 0; x < nzonas; x++) {
						aNombreZonasAmpl[x] = aNombreZonas[x];
					}
					
					for(int x = 0; x < 2; x++) {
						for(int y = 0; y < nzonas; y++) {
							aAreasFactdensAmpl[x][y] = aAreasFactdens[x][y];
						}
					}
					
					aNombreZonas = aNombreZonasAmpl;
					aAreasFactdens = aAreasFactdensAmpl;
					
					comienza = nzonas;
					nzonas += amplia;
				}
				else {
					System.out.println("Introduce 1 (SI) o 0 (NO) \n");
				}
			}while(agregar != 0 && agregar != 1);
			
		}while(continuar != false);
		
		sc.close();
		int arbolplant;
		int arboltotal = 0;
		
		for(int j = 0; j < nzonas; j++) {
			arbolplant = aAreasFactdens[0][j] * aAreasFactdens[1][j];
			System.out.println("El numero de arboles plantados en la zona " + (j+1) + " con nombre " + aNombreZonas[j] + " es: " + arbolplant);
			arboltotal += arbolplant;
		}
		System.out.println("");
		System.out.println("El numero de arboles plantados en total es: " + arboltotal);
	}
}