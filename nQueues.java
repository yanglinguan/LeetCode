class Solution {

    private boolean[] col;
    private boolean[] dig1;
    private boolean[] dig2;
    
    private List<List<String>> r = new ArrayList<>();
    public void helper(int n, int row, List<Integer> cur, List<List<String>> result) {
        if(row == n) {
            List<String> stringList = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringBuilder s = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(j == cur.get(i)) {
                        s.append('Q');
                    } else {
                        s.append('.');
                    }
                }
                stringList.add(s.toString());
            }
            result.add(stringList);
            return;
        }
        
        for(int c = 0; c < n; c++) {
            if(col[c]) continue;
            if(dig1[c + row]) continue;
            if(dig2[c - row + (n - 1)]) continue;
            
            col[c] = true;
            dig1[c + row] = true;
            dig2[c - row + (n - 1)] = true;
            cur.add(c);
            helper(n, row + 1, cur, result);
            cur.remove(cur.size() - 1);
            col[c] = false;
            dig1[c + row] = false;
            dig2[c - row + (n - 1)] = false;
            
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        dig1 = new boolean[2 * n - 1];
        dig2 = new boolean[2 * n - 1];
        List<List<String>> result = new ArrayList<>();
        helper(n, 0, new ArrayList<Integer>(), result);
        return result;
    }
}
