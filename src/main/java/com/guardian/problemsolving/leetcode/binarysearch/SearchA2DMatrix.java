package com.guardian.problemsolving.leetcode.binarysearch;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target=3;
        System.out.println(searchMatrix(matrix,target));
    }
    private static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Pointer leftP = new Pointer(0,0);
        Pointer rightP = new Pointer(rows-1,cols-1);
        Pointer middleP = leftP;

        while(leftP.isLessThan(rightP)){
            middleP = Pointer.getMiddlePointer(leftP,rightP,rows,cols);
            if(matrix[middleP.row][middleP.col]==target){
                return true;
            }
            else if(matrix[middleP.row][middleP.col]<target){
                leftP = middleP;
            }
            else{
                rightP = middleP;
            }
        }
        return matrix[middleP.row][middleP.col]==target;
    }

    private static class Pointer implements Comparable<Pointer>{
        int row;
        int col;

        public Pointer(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        @Override
        public int compareTo(Pointer p) {
            if(this.row == p.row && this.col == p.col)
                return 0;
            else if(this.row > p.row || (this.row == p.row && this.col > p.col))
                return 1;
            else
                return -1;
        }

        public boolean isLessThan(Pointer p){
            return this.compareTo(p) <= 0;
        }

        public static Pointer getMiddlePointer(Pointer left, Pointer right, int rows, int cols){
            int leftDist = left.row*cols + left.col + 1;
            int rightDist = right.row*cols + right.col + 1;
            int midLength = (rightDist-leftDist)/2;
            int i = left.row + midLength/cols;
            int j;
            int remainder = midLength%cols;
            if(left.col+remainder<cols){
                j = left.col+remainder;
            }
            else {
                j = remainder-(cols-left.col);
                i++;
            }
            return new Pointer(i,j);
        }
    }
}
