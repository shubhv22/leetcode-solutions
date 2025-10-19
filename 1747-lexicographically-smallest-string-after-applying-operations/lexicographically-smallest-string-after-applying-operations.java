class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        String res = s;
        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        q.add(s);
        seen.add(s);
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(res) < 0) res = cur;
            StringBuilder t = new StringBuilder(cur);
            for (int i = 1; i < n; i += 2) {
                int digit = (t.charAt(i) - '0' + a) % 10;
                t.setCharAt(i, (char) (digit + '0'));
            }
            String addOp = t.toString();
            if (seen.add(addOp)) q.add(addOp);
            String rotOp = cur.substring(n - b) + cur.substring(0, n - b);
            if (seen.add(rotOp)) q.add(rotOp);
        }
        return res;
    }
}