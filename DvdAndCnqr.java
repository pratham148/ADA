import java.util.*;
class DvdAndCnqr
{
  public static int[][] generateMatrix(int n)
  {
    Random r = new Random();
    int matrix[][] = new int[n][n];
    for (int i=0;i<n;i++) 
    {
      for(int j=0;j<n;j++)
      {
        matrix[i][j] = r.nextInt(100);
      }
    }
    return matrix;
  }
  public static void displayMatrix(int X[][])
  {
    for(int i=0;i<X.length;i++)
    {
      for(int j=0;j<X.length;j++)
      {
        System.out.printf(X[i][j]+"    ");
      }
      System.out.println();
    }
  }
  public static void deconstructMatrix(int initialMatrix[][],int newMatrix[][],int a,int b)
  {
    int y=b;
    for(int i=0 ; i<newMatrix.length ; i++)
    {
      for(int j=0 ; j<newMatrix.length ; j++)
      {
        newMatrix[i][j] = initialMatrix[a][y++];
      }
    }
    y=b;
    a++;
  }
  public static void constructMatrix(int initialMatrix[][],int newMatrix[][],int a,int b)
  {
    int y=b;
    for(int i=0 ; i<initialMatrix.length ; i++)
    {
      for(int j=0 ; j<initialMatrix.length ; j++)
      {
        newMatrix[a][y++] = initialMatrix[i][j];
      }
    }
    y=b;
    a++;
  }
  public static int [][] addMatrix(int X[][],int Y[][],int n)
  {
    int C[][] = new int [n][n];
    for(int i=0;i<n;i++)
    {
      for(int j=0;j<n;j++)
      {
        C[i][j] = X[i][j] + Y[i][j];
      }
    }
    return C;
  }
  public static int[][] DivideAndConquerMM(int X[][],int Y[][],int n)
  {
    int C[][] = new int [n][n];

    if(n==1)
    {
      C[0][0] = X[0][0] * Y[0][0];
      return C;
    }
    else
    {
      int [][] A11 = new int[n/2][n/2];
      int [][] A12 = new int[n/2][n/2];
      int [][] A21 = new int[n/2][n/2];
      int [][] A22 = new int[n/2][n/2];
      int [][] B11 = new int[n/2][n/2];
      int [][] B12 = new int[n/2][n/2];
      int [][] B21 = new int[n/2][n/2];
      int [][] B22 = new int[n/2][n/2];

      deconstructMatrix(X,A11,0 , 0);
      deconstructMatrix(X,A12,0 , n/2);
      deconstructMatrix(X,A21,n/2,0);
      deconstructMatrix(X,A22,n/2,n/2);
      deconstructMatrix(Y,B11,0,0);
      deconstructMatrix(Y,B12,0,n/2);
      deconstructMatrix(Y,B21,n/2,0);
      deconstructMatrix(Y,B22,n/2,n/2);

      int [][] C11 = addMatrix(DivideAndConquerMM(A11,B11,n/2 ),DivideAndConquerMM(A12,B21,n/2),n/2);
      int [][] C12 = addMatrix(DivideAndConquerMM(A11,B12,n/2 ),DivideAndConquerMM(A12,B22,n/2),n/2);
      int [][] C21 = addMatrix(DivideAndConquerMM(A21,B11,n/2 ),DivideAndConquerMM(A22,B21,n/2),n/2);
      int [][] C22 = addMatrix(DivideAndConquerMM(A21,B12,n/2 ),DivideAndConquerMM(A22,B22,n/2),n/2);

      constructMatrix(C11,C,0,0);
      constructMatrix(C12,C,0,n/2);
      constructMatrix(C21,C,n/2,0);
      constructMatrix(C22,C,n/2,n/2);
    }
    return C;
  }
  public static void main(String[] args) 
  {
    
    int n = 2;
    System.out.println("N-->");
    int X[][] = generateMatrix(n);
    int Y[][] = generateMatrix(n);

    System.out.println("First Matrix :");
    displayMatrix(X);
    System.out.println("Second Matrix");
    displayMatrix(Y);

    long startTime = System.nanoTime();
    int [][]C = DivideAndConquerMM(X,Y,X.length);
    long endTime = System.nanoTime();
    long totalTime = endTime - startTime ;

    System.out.println("Resultant Matrix after matrix multiplication :");
    displayMatrix(C);
    System.out.println("\nElasped Time in ns --> "+totalTime);
  }
}