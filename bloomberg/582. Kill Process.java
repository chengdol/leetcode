// medium


class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++)
        {
            int pp = ppid.get(i);
            int p = pid.get(i);

            map.computeIfAbsent(pp, k -> new ArrayList<>()).add(p);
        }

        List<Integer> res = new ArrayList<>();
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(kill);

        while (!que.isEmpty())
        {
            int size = que.size();
            for (int i = 0; i < size; i++)
            {
                int p = que.poll();
                res.add(p);

                // offer new children process
                que.addAll(map.getOrDefault(p, new ArrayList<>()));
            }
        }

        return res;
    }
}
