
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  
  public static int vetorElemento(int tamanho) {
    
    switch (tamanho) {
      case 1:
        return 5000;
      case 2:
        return 1000000;
      
      default:
     return 0;
      
  }

}

 
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int tamArray, op = 0 ;
   
   System.out.println("Digite o 1 para o vetor de 5000 elementos.");
    System.out.println("Digite o 2 para o vetor de 1000000 elementos.");
 // while(op != 1|| op!=2);
    try {
      op = in.nextInt();
      
    } catch (InputMismatchException e) {
      System.out.println("não foi digitado um numero inteiro\n logo o vetor sera de 5000 elementos");
      in.nextLine();

    }

    tamArray = vetorElemento(op);
    
    
    int[] vetor = new int[tamArray];
    

for (int index = 0; index < vetor.length; index++) {
  vetor[index] = index+1;
}
int menu = 1;
int valor = 0, retorno =-1;
System.out.println("Digite o valor a ser buscado");
try {
  valor = in.nextInt();
} catch (Exception e) {
  System.out.println(" O valor não foi um numero entao foi considerado 1");
}

long time = 0L, time2;

String buscar = null;
long memory =0L;
Runtime runtime;
do{
  System.out.println("Digite: \n 1- Busca sequencial iterativa \n 2- Busca sequencial recursiva\n 3- Busca binaria iterativa\n 4- Busca binaria recursiva ");
  try {
    menu = in.nextInt();
  } catch (Exception e) {
    System.out.println(" O valor não foi um numero entao foi considerado 0");
  }
 time2 = System.currentTimeMillis();
 time = System.nanoTime();
 

  switch (menu) {
      case 1:
     
       
      retorno = buscaSequencialIterativa(vetor, valor);
      time = System.nanoTime() - time;
      time2 = System.currentTimeMillis()- time2;
      runtime = Runtime.getRuntime();
      runtime.gc();
      memory = runtime.totalMemory() - runtime.freeMemory();
       buscar = "sequencial iterativa foi: ";
      break;
      case 2:
      
      retorno = buscaSequencialRecursiva(vetor, valor, 0);
      time = System.nanoTime() - time;
      time2 = System.currentTimeMillis()- time2;
      runtime = Runtime.getRuntime();
      runtime.gc();
      memory = runtime.totalMemory() - runtime.freeMemory();
       buscar = "sequencial recursiva foi: ";
      break;
      case 3:
       
      retorno = buscaBinariaInterativa(vetor, valor);
      time = System.nanoTime() - time;
      time2 = System.currentTimeMillis()- time2;
      runtime = Runtime.getRuntime();
      runtime.gc();
      memory = runtime.totalMemory() - runtime.freeMemory();
      buscar = "binaria iterativa foi: ";
      break;
      case 4:
     
      retorno = buscaBinariaRecursiva(vetor, valor, 0 , vetor.length-1);
      time = System.nanoTime() - time;
      time2 = System.currentTimeMillis()- time2;
      runtime = Runtime.getRuntime();
      runtime.gc();
      memory = runtime.totalMemory() - runtime.freeMemory();
      buscar = "binaria recursiva foi: ";
      break;
  
    default:
    menu = 0;
      break;
  }}while(menu == 0);

  if (retorno == -1) {

      System.out.println("Esse valor não existe no seu array");

    } else {
      System.out.println("O valor do array existe no indice: " +  retorno);
    }
   
    System.out.println("o tempo de execução do algoritimo de "+buscar + time + " nanosegundos");
    System.out.println("o tempo de execução do algoritimo de "+buscar + time2 + " milisegundos");
    System.out.println("O uso de memoria no algoritimo de "+buscar +memory+" bytes");
    System.out.println("O uso de memoria no algoritimo de "+buscar +memory/(1024L*1024L)+" megabytes");

  }
  public static int buscaSequencialIterativa(int array[], int valor) {
    for (int i = 0; i < array.length; i++) {
      if (valor == array[i]) {
        return i;
      }
    }
    return -1;
  }
   public static int buscaBinariaInterativa(int array[], int valor) {
    int pos_I = 0;
    int pos_F = array.length-1;
    int pos_M;

    while (pos_I <= pos_F) {
      pos_M = (pos_F + pos_I) / 2;

      if (valor == array[pos_M]) {

        return pos_M;

      } else if (valor > array[pos_M]) {
        pos_I = pos_M + 1;

      } else {
        pos_F = pos_M - 1;

      }
    }
    return -1;
  }

  public static int buscaSequencialRecursiva(int array[], int valor, int indice) {

    if (indice >= array.length) {
      return -1;

    } 
      if (valor == array[indice]) {
        return indice;

      }

        return buscaSequencialRecursiva(array, valor, indice + 1);
      }
    

  

  public static int buscaBinariaRecursiva(int array[], int valor, int pos_I, int pos_F) {

    if (pos_I > pos_F) {
      return -1;
    }
    int pos_M = (pos_F + pos_I) / 2;

    if (valor == array[pos_M]) {

      return pos_M;

    } else if (valor > array[pos_M]) {
      pos_I = pos_M + 1;

      return buscaBinariaRecursiva(array, valor, pos_I, pos_F);

    } else {
      pos_F = pos_M - 1;
      return buscaBinariaRecursiva(array, valor, pos_I, pos_F);

    }
  }
}
//1082992 bytes
//1082984 bytes
//1083240 bytes
//1083168 bytes

//119671 nanosegundos
//1012200 nanosegundos
// 7140 nanosegundos
// 6880