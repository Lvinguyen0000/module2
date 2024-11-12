package Part3;

public class SumMainDiagonal {
    public static void main(String[] args){
        int[][] matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
            }
            System.out.println(java.util.Arrays.toString(matrix[i]));
        }

        int[] diagSum = sumDiagnal((matrix));
        System.out.println("Sum of the main diagonals of the matrix is: " + diagSum[0] + " + " + diagSum[1] + " = " + ((int)diagSum[0] + (int)diagSum[1]));
    }

    public static int[] sumDiagnal(int[][] matrix){
        int[] sum = {0, 0};
        for (int i = 0, j = 0; i < matrix.length; i++, j++){
            sum[0] += matrix[i][j];
            sum[1] += matrix[i][matrix.length - 1 - j];
        }
        return sum;
    }
}