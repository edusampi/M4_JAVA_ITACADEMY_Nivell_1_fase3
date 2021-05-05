import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.HashMap;

public class M4_Nivell1_fase3 {

	public static void main(String[] args) {
	    int cinc = 5;
	    int deu = 10;
	    int vint = 20;
	    int cinquanta = 50;
	    int cent = 100;
	    int doscents = 200;
	    int cinccents = 500;
	    int totalFood = 0;

	    String[] menuList = new String[10];
	    int[] foodPriceList = new int[10];

	    // Omplim els arrays amb les dades
	    
	    for (int i = 0; i < menuList.length; i++) {
	      String auxMenuList = "bufalina,4 formaggi,pino daniele,marghuerita,prosciutto,parmiggiana,al tono,carbonara,massimo troise, ortolana";
	      String[] partsMenuList = auxMenuList.split(",");
	      menuList[i] = partsMenuList[i];

	      String auxPriceList = "12,12,18,9,10,11,13,11,17,12";
	      String[] partPriceList = auxPriceList.split(",");
	      foodPriceList[i] = Integer.parseInt(partPriceList[i]);
	    }

	    // Demanem plats fins que el client escull la opció 2 (NO)
	    
	    boolean keepAdding = true;
	    ArrayList<String> menuSelected = new ArrayList<String>();
	    do {
	      printMenu(menuList);
	      Scanner console = new Scanner(System.in);
	      int chosenDish = console.nextInt();
	      switch (chosenDish) {
	        case 1:
	        	menuSelected.add("bufalina");
	        	break;
	        case 2:
	        	menuSelected.add("4 formaggi");
	        	break;
	        case 3:
	        	menuSelected.add("pino daniele");
	        	break;
	        case 4:
	        	menuSelected.add("margherita");
	        	break;
	        case 5:
	        	menuSelected.add("prosciutto");
	        	break;
	        case 6:
	            menuSelected.add("parmiggiana");
	            break;
	        case 7:
	            menuSelected.add("al tonno");
	            break;
	        case 8:
	            menuSelected.add("carbonara");
	            break;    
	        case 9:
	            menuSelected.add("massimo troise");
	            break;
	        case 10:
	            menuSelected.add("ortolana");
	            break;
	           
	        default:
	          System.out.println("Perdoni, esculli plat de l'1 al 10");
	      }

	      System.out.print("Vol continuar demanant plats? \t 1(Si) / 2(No) \t");
	      String answer = console.next();

	      if (answer.equals("2")) {
	        keepAdding = false;
	      } else if (answer.equals("1")) {
	        keepAdding = true;
	      } else {
	        System.out.println("Perdoni, resposta incorrecta, 1(Si) / 2(No) ");
	      }

	    }
	    while (keepAdding);

	    printOrden(menuSelected);
	    getCheck(menuSelected, menuList, foodPriceList);

	  }

	  public static void printPrice(int[] arrayToPrint) {
	    for (int actual : arrayToPrint) {
	      System.out.println(actual + " - ");
	    }
	  }

	  public static void printMenu(String[] arrayToPrint) {
	    int cont = 0;
	    System.out.println("Que vol menjar?");
	    for (String actual : arrayToPrint) {
	      System.out.print(++cont + ")" + actual + "\t");
	    }
	  }

	  public static void printOrden(ArrayList<String> arrayToPrint) {
	    Iterator<String> it = arrayToPrint.iterator();
	    System.out.println("\n-------- La seva comanda --------");
	    while (it.hasNext())
	      System.out.println(it.next());
	  }

	  public static void getCheck(ArrayList<String> arrayToPrint, String[] menuList, int[] foodPriceList){
	    int check = 0;
	    Iterator<String> it = arrayToPrint.iterator();
	    while (it.hasNext()){
	      String actual = it.next();
	      for (int i = 0; i < menuList.length; i++) {
	        if(menuList[i].equals(actual)){
	          check += foodPriceList[i];
	        }
	      }
	    }
	    System.out.println("\n-------- Total comanda --------");
	    System.out.println("El preu és: " + check +" €");
	  }

	}