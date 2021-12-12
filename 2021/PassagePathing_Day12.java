/*
Question : https://adventofcode.com/2021/day/11
*/

public class PassagePathing_Day12 {

    private Set<String> cache = new HashSet<>();

    public static void main(String[] args) {
        String[] input1 = {
            "start-A",
            "start-b",
            "A-c",
            "A-b",
            "b-d",
            "A-end",
            "b-end"
        };

        String[] input2 = {
            "dc-end",
            "HN-start",
            "start-kj",
            "dc-start",
            "dc-HN",
            "LN-dc",
            "HN-end",
            "kj-sa",
            "kj-HN",
            "kj-dc"
        };

        String[] myInput = {
            "pg-CH",
            "pg-yd",
            "yd-start",
            "fe-hv",
            "bi-CH",
            "CH-yd",
            "end-bi",
            "fe-RY",
            "ng-CH",
            "fe-CH",
            "ng-pg",
            "hv-FL",
            "FL-fe",
            "hv-pg",
            "bi-hv",
            "CH-end",
            "hv-ng",
            "yd-ng",
            "pg-fe",
            "start-ng",
            "end-FL",
            "fe-bi",
            "FL-ks",
            "pg-start"
        };

        Map<Cave, List<Cave>> caveMap = parse(myInput);
        Cave start = caveMap.keySet().stream().filter(c -> c.name.equals("start")).findFirst().get();
        System.out.println("part 1 : " + dfs(caveMap, start, new ArrayList<>(), 0));
        System.out.println("part 2 : " + dfs(caveMap, start, new ArrayList<>(), 1));
    }

    private static int dfs(Map<Cave, List<Cave>> caveMap, Cave cave, List<Cave> visited, int extraQuota) {
        // System.out.println(cave + "(" + extraQuota + ") : " + visited);
        if(cave.name.equals("end")) {
            return 1;
        }
        if(visited.contains(cave) && !cave.big) {
            if(extraQuota > 0) {
                extraQuota--;
            } else {
                return 0;
            }
        }
        visited.add(cave);
        int paths = 0;
        for(Cave child : caveMap.get(cave)) {
            paths += dfs(caveMap, child, visited, extraQuota);
        }
        visited.remove(visited.size()-1);
        return paths;
    }

    private static void cleanInput(Map<Cave, List<Cave>> map) {
        List<Cave> toBeDeletedKeys = new ArrayList<>();
        map.forEach((from, to) -> {
            boolean delete = true;
            for(Cave c : to) {
                if(c.terminal || c.big) {
                    delete = false;
                    break;
                }
            }
            if(delete && !from.terminal) {
                toBeDeletedKeys.add(from);
            }
        });
        for(Cave c : toBeDeletedKeys) {
            map.remove(c);
            map.values().forEach(list -> list.remove(c));
        }
    }

    private static Map<Cave, List<Cave>> parse(String[] input) {
        Map<Cave, List<Cave>> parsedMap = new HashMap<>();
        Map<String, Cave> visited = new HashMap<>();
        for(int i = 0; i < input.length; i++) {
            String[] caves = input[i].split("-");
            Cave from = new Cave(caves[0]);
            Cave to = new Cave(caves[1]);
            if(visited.containsKey(caves[0])) {
                from = visited.get(caves[0]);
            }
            if(visited.containsKey(caves[1])) {
                to = visited.get(caves[1]);
            }
            visited.put(caves[0], from);
            visited.put(caves[1], to);
            if(!from.name.equals("end") && !to.name.equals("start")) {
                parsedMap.merge(from, new ArrayList<>(Arrays.asList(to)), (l1, l2)->{l1.addAll(l2);return l1;});
            }
            if(!from.name.equals("start") && !to.name.equals("end")) {
                parsedMap.merge(to, new ArrayList<>(Arrays.asList(from)), (l1, l2)->{l1.addAll(l2);return l1;});
            }
        }
        return parsedMap;
    }

    public static class Cave {
        public String name;
        public boolean big;
        public boolean terminal;

        public Cave(String name) {
            this.name = name;
            this.big = (name.charAt(0) >= 'A' && name.charAt(0) <= 'Z') ? true : false;
            this.terminal = (name.equalsIgnoreCase("start") || name.equalsIgnoreCase("end")) ? true : false;
        }

        @Override
        public boolean equals(Object b) {
            return this.name.equals(((Cave)b).name);
        }

        @Override
        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return this.name;
        }
    }
}
