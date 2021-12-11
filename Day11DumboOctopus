public class Day11DumboOctopus {

    private static int[][] DIR = {{1,0}, {0,1}, {1,1}, {-1,0}, {0,-1}, {-1,-1}, {-1, 1}, {1, -1}};

    public static void main(String[] args) {
        String[] input1 = new String[]{
            "8258741254",
            "3335286211",
            "8468661311",
            "6164578353",
            "2138414553",
            "1785385447",
            "3441133751",
            "3586862837",
            "7568272878",
            "6833643144"
            };
        String[] input2 = new String[] {
            "5483143223",
            "2745854711",
            "5264556173",
            "6141336146",
            "6357385478",
            "4167524645",
            "2176841721",
            "6882881134",
            "4846848554",
            "5283751526"
        };
        String[] input3 = new String[] {
            "11111",
            "19991",
            "19191",
            "19991",
            "11111"
        };
        System.out.println("part1 : " + ansPart1(parse(input1)));
        System.out.println("part2 : " + ansPart2(parse(input1)));
    }

    private static int ansPart1(int[][] input) {
        int burstOctopus = 0;
        for(int i = 0; i < 100; i++) {
            burstOctopus += burst(input);
        }
        return burstOctopus;
    }

    private static int ansPart2(int[][] input) {
        for(int i = 0; i < 500; i++) {
            burst(input);
            if(nonZeroCount(input) == 0) {
                return i+1;
                //System.out.println(Arrays.deepToString(input));
            }
        }
        return -1;
    }

    private static int nonZeroCount(int[][] inp) {
        int M = inp.length;
        int N = inp[0].length;
        int c = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(inp[i][j] != 0) {
                    c++;
                }
            }
        }
        return c;
    }

    private static int burst(int[][] inp) {
        int M = inp.length;
        int N = inp[0].length;
        int allburstedOct = 0;
        boolean bursted = true;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                inp[i][j] += 1;
            }
        }
        while(bursted) {
            bursted = false;
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    if(inp[i][j] > 9) {
                        inp[i][j] = 0;
                        bursted = true;
                        allburstedOct++;
                        for(int[] d : DIR) {
                            int row = i + d[0];
                            int col = j + d[1];
                            if(row < 0 || row >= M || col < 0 || col >= N || inp[row][col] == 0) {
                                continue;
                            }
                            inp[row][col] += 1;
                        }
                    }
                }
            }
        }
        return allburstedOct;
    }

    private static int[][] parse(String[] input) {
        int M = input.length;
        int N = input[0].length();
       int[][] inp = new int[M][N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                inp[i][j] = input[i].charAt(j) - '0';
            }
        }
        return inp;
    }
}



/*
34543
40004
50005
40004
34543

*/
