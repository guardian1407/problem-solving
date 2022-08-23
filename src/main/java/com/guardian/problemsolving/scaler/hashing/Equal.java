package com.guardian.problemsolving.scaler.hashing;

import java.util.*;

public class Equal {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(3, 4, 7, 1, 2, 9, 8));
        equal(A).forEach(e->System.out.print(e+" "));
    }
    static ArrayList<Integer> equal(ArrayList<Integer> A) {
        int N=A.size();
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<ArrayList<Integer>> ansList=new ArrayList<>();
        Map<Integer,List<Integer>> hm=new HashMap<>();

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                int sum=A.get(i)+A.get(j);
                if(!hm.containsKey(sum))
                    hm.put(sum,new ArrayList<>(Arrays.asList(i,j)));
            }
        }

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                int sum=A.get(i)+A.get(j);
                if(hm.containsKey(sum)){
                    List<Integer> pair=hm.get(sum);
                    int l=pair.get(0);
                    int r=pair.get(1);

                    if(l<i && r!=i && r!=j)
                        ansList.add(new ArrayList<>(Arrays.asList(l,r,i,j)));
                }
            }
        }

        if(ansList.size()>=1)
            ans=ansList.get(0);

        for(int i=1;i<ansList.size();i++){
            ArrayList<Integer> list=ansList.get(i);
            int a1=list.get(0);
            int b1=list.get(1);
            int c1=list.get(2);
            int d1=list.get(3);

            int a2=ans.get(0);
            int b2=ans.get(1);
            int c2=ans.get(2);
            int d2=ans.get(3);

            if(a1<a2 || (a1==a2 && b1<b2) || (a1==a2 && b1==b2 && c1<c2) || (a1==a2 && b1==b2 && c1==c2 && d1<d2))
                ans=list;
        }
        return ans;
    }
}
