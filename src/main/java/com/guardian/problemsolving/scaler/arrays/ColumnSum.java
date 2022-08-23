package com.guardian.problemsolving.scaler.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ColumnSum {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,2,3,4)));
        A.add(new ArrayList<>(Arrays.asList(5,6,7,8)));
        A.add(new ArrayList<>(Arrays.asList(9,2,3,4)));

        solve(A).forEach(ele->System.out.print(ele+" "));
    }
    public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        int N=A.size();
        ArrayList<Integer> ans=A.get(0);

        for(int i=1;i<N;i++){
            ArrayList<Integer> row=A.get(i);
            int M=row.size();

            for(int j=0;j<M;j++)
                ans.set(j,ans.get(j)+ row.get(j));
        }
        return ans;
    }
}
