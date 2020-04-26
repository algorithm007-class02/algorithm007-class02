class Solution {

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);
        int max = map[25] - 1;
        int idle_slots = max * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }

}