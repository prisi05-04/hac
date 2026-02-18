class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] w = s.split(" ");
        if (pattern.length() != w.length) {
            return false;
        }
        Map<Character, String> d1 = new HashMap<>();
        Map<String, Character> d2 = new HashMap<>();
        for (int i = 0; i < w.length; ++i) {
            char a = pattern.charAt(i);
            String b = w[i];
            if (!d1.getOrDefault(a, b).equals(b) || d2.getOrDefault(b, a) != a) {
                return false;
            }
            d1.put(a, b);
            d2.put(b, a);
        }
        return true;
    }
}