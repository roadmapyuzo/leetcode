import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    /*
    Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:




Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]


Constraints:

1 <= numRows <= 30
     */

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> start = new ArrayList<>();
        start.add(1);

        backTracking(1, numRows, start, res);

        return res;



    }

    public void backTracking(int row, int maxRows, List<Integer> list, List<List<Integer>> res) {

        if (row == maxRows) {

            res.add(list);
            return;
        }

        if (row == 1) {

            List<Integer> copia = List.copyOf(list);
            res.add(copia);
            list.add(1);
            row++;
            backTracking(row, maxRows, list, res);

        } else {

            List<Integer> copia = List.copyOf(list);
            res.add(copia);

            int position = 1;
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            newList.add(1);

            for (int i = 0; i < (row -1); i++) {

                Integer newNumber = list.get(i) + list.get(i+1);
                newList.add(position, newNumber);
                position++;

            }

            row++;

            backTracking(row, maxRows, newList, res);

        }

    }

}
