package com.arraylistdemo;

import java.util.ArrayList;
import java.util.List;

//第i行 有i+1个列(从零开始)
//针对每一行来说 第0列是1 最后一列也是1
//针对第i行第j列的元素来说 (i-1行j-1列 元素)+(i-1行j列 元素)
public class TestYHTriangle {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            //每次循环构造一行
            for (int i = 0 ; i < numRows ; i++){
                //表示当前行
                List<Integer> row = new ArrayList<>();
                //填写若干列
                for(int j = 0 ; j <= i ; j++){
                    if(j == 0 || j == i ){
                        row.set(j,1);
                    }else{
                        List<Integer> lastList = result.get(i-1);
                        int curValue = lastList.get(j) + lastList.get(j-1);
                        row.set(j,curValue);
                    }
                }
                result.add(row);
            }
            return result;
        }
    }
}

