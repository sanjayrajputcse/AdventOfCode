package com.sanjay.advent_of_code.aoc_2021;

/**
 * Question: https://adventofcode.com/2021/day/1
 * Answer :
 *   Part1 : 1715
 *   Part2 : 1739
*/
public class Day1_SonarSweep {

    public static void main(String[] args) {
        int[] readings = myReading();
        int last = readings[0];
        int increasing = 0;
        for(int i = 1; i < readings.length; i++) {
            if(last < readings[i]) {
                increasing++;
            }
            last = readings[i];
        }
        System.out.println("part1 : " + increasing);
        int lastSum = readings[0] + readings[1] + readings[2];
        increasing = 0;
        for(int i = 3; i < readings.length; i++) {
            int nextSum = lastSum - readings[i-3] + readings[i];
            if(nextSum > lastSum) {
                increasing++;
            }
            lastSum = nextSum;
        }
        System.out.println("part2 : " + increasing);
    }

    private static int[] myReading() {
        return new int[] {
                100, 125, 124, 127, 141, 145, 160, 161, 178, 185, 193, 196, 195, 200, 212, 216, 222, 244, 274, 276, 279, 307, 309, 325, 332, 336, 338, 339, 359, 378, 380, 381, 386, 388,
                417, 418, 432, 458, 459, 462, 463, 467, 468, 480, 482, 486, 495, 510, 518, 526, 528, 539, 537, 536, 537, 545, 564, 566, 567, 571, 580, 595, 602, 596, 605, 618, 630, 631,
                633, 632, 634, 645, 657, 673, 693, 694, 705, 721, 722, 743, 744, 753, 754, 755, 756, 757, 772, 775, 812, 801, 811, 812, 813, 816, 806, 807, 808, 825, 837, 838, 833, 825,
                827, 826, 818, 808, 825, 828, 834, 836, 839, 859, 879, 870, 875, 886, 889, 894, 897, 898, 901, 904, 942, 955, 965, 983, 982, 984, 985, 987, 984, 1005, 1012, 1024, 1033,
                1036, 1048, 1052, 1058, 1070, 1078, 1080, 1079, 1094, 1102, 1104, 1110, 1122, 1117, 1118, 1107, 1108, 1118, 1133, 1138, 1165, 1167, 1172, 1169, 1179, 1193, 1157, 1164,
                1165, 1167, 1170, 1178, 1179, 1180, 1188, 1187, 1188, 1202, 1201, 1200, 1206, 1213, 1214, 1213, 1219, 1220, 1223, 1233, 1235, 1237, 1245, 1246, 1250, 1251, 1256, 1263,
                1268, 1271, 1294, 1295, 1308, 1311, 1314, 1317, 1321, 1332, 1336, 1337, 1327, 1330, 1310, 1319, 1323, 1325, 1356, 1353, 1370, 1372, 1397, 1410, 1413, 1425, 1428, 1432,
                1440, 1443, 1452, 1451, 1455, 1456, 1457, 1461, 1462, 1463, 1464, 1456, 1467, 1470, 1471, 1474, 1492, 1478, 1492, 1498, 1508, 1516, 1515, 1516, 1519, 1520, 1509, 1510,
                1521, 1526, 1528, 1533, 1536, 1547, 1560, 1571, 1589, 1586, 1589, 1591, 1597, 1598, 1605, 1613, 1615, 1617, 1618, 1642, 1632, 1628, 1638, 1641, 1640, 1657, 1669, 1675,
                1690, 1714, 1715, 1716, 1715, 1717, 1740, 1741, 1743, 1741, 1746, 1759, 1766, 1772, 1773, 1792, 1793, 1795, 1827, 1832, 1833, 1834, 1846, 1867, 1868, 1872, 1877, 1878,
                1876, 1878, 1881, 1883, 1886, 1904, 1920, 1921, 1924, 1929, 1955, 1956, 1961, 1962, 1968, 1971, 1968, 1955, 1973, 1974, 1991, 1984, 1989, 1990, 1987, 1991, 1998, 2002,
                2005, 1989, 1986, 1985, 1987, 1991, 2011, 2014, 2019, 2021, 2022, 2033, 2039, 2044, 2046, 2045, 2056, 2060, 2062, 2058, 2063, 2072, 2073, 2075, 2100, 2124, 2131, 2143,
                2145, 2153, 2155, 2154, 2156, 2157, 2158, 2174, 2197, 2187, 2188, 2192, 2194, 2195, 2205, 2206, 2208, 2210, 2211, 2222, 2227, 2229, 2230, 2240, 2245, 2246, 2243, 2244,
                2261, 2262, 2263, 2258, 2261, 2263, 2284, 2294, 2295, 2294, 2289, 2290, 2293, 2294, 2295, 2290, 2319, 2323, 2324, 2332, 2336, 2340, 2373, 2374, 2375, 2377, 2408, 2417,
                2422, 2442, 2443, 2444, 2447, 2448, 2465, 2467, 2468, 2485, 2486, 2489, 2504, 2505, 2506, 2529, 2530, 2531, 2557, 2563, 2579, 2582, 2583, 2595, 2629, 2634, 2638, 2635,
                2640, 2643, 2653, 2658, 2656, 2657, 2658, 2660, 2662, 2670, 2679, 2672, 2685, 2688, 2699, 2695, 2696, 2714, 2698, 2702, 2703, 2707, 2711, 2718, 2719, 2727, 2742, 2758,
                2759, 2768, 2769, 2773, 2787, 2801, 2810, 2811, 2805, 2806, 2811, 2812, 2815, 2848, 2850, 2856, 2845, 2855, 2866, 2874, 2885, 2887, 2877, 2878, 2879, 2880, 2887, 2888,
                2892, 2899, 2900, 2891, 2901, 2900, 2876, 2885, 2893, 2921, 2923, 2925, 2940, 2945, 2947, 2950, 2944, 2947, 2949, 2950, 2958, 2959, 2961, 2957, 2958, 2959, 2963, 2959,
                2966, 2976, 2985, 2986, 2987, 2993, 2994, 3005, 3008, 3010, 3011, 3028, 3032, 3035, 3036, 3059, 3060, 3061, 3060, 3065, 3069, 3115, 3123, 3129, 3130, 3128, 3126, 3123,
                3124, 3120, 3124, 3134, 3138, 3143, 3145, 3149, 3188, 3196, 3203, 3201, 3203, 3204, 3206, 3208, 3214, 3201, 3220, 3236, 3237, 3259, 3260, 3274, 3276, 3283, 3280, 3282,
                3301, 3313, 3319, 3326, 3338, 3339, 3341, 3345, 3331, 3335, 3363, 3364, 3369, 3364, 3371, 3370, 3388, 3390, 3398, 3399, 3398, 3387, 3394, 3395, 3396, 3404, 3408, 3416,
                3414, 3437, 3451, 3453, 3455, 3477, 3481, 3482, 3489, 3488, 3486, 3501, 3510, 3520, 3538, 3561, 3564, 3570, 3583, 3563, 3565, 3566, 3567, 3569, 3573, 3575, 3576, 3584,
                3593, 3569, 3585, 3586, 3585, 3591, 3593, 3596, 3597, 3592, 3611, 3614, 3620, 3621, 3637, 3641, 3642, 3648, 3660, 3667, 3664, 3678, 3687, 3703, 3715, 3725, 3730, 3731,
                3738, 3739, 3740, 3754, 3756, 3760, 3768, 3772, 3775, 3779, 3809, 3816, 3806, 3807, 3806, 3811, 3813, 3820, 3819, 3820, 3822, 3827, 3828, 3826, 3836, 3837, 3838, 3832,
                3833, 3835, 3836, 3839, 3849, 3853, 3854, 3862, 3868, 3871, 3872, 3877, 3878, 3881, 3910, 3911, 3912, 3913, 3925, 3926, 3958, 3961, 3964, 3977, 3995, 4001, 3997, 3981,
                3960, 3961, 3954, 3964, 3963, 3968, 3964, 3965, 3980, 3984, 3985, 3986, 3991, 3998, 4008, 4015, 4019, 4020, 4023, 4040, 4055, 4061, 4064, 4074, 4078, 4079, 4078, 4086,
                4101, 4102, 4104, 4106, 4109, 4107, 4113, 4112, 4120, 4108, 4116, 4118, 4119, 4130, 4123, 4135, 4132, 4133, 4136, 4109, 4088, 4090, 4091, 4092, 4094, 4099, 4102, 4113,
                4131, 4130, 4151, 4152, 4153, 4157, 4161, 4180, 4182, 4186, 4192, 4223, 4218, 4219, 4220, 4246, 4255, 4259, 4257, 4258, 4274, 4293, 4294, 4303, 4305, 4316, 4314, 4315,
                4324, 4330, 4317, 4318, 4331, 4332, 4376, 4379, 4388, 4396, 4399, 4403, 4405, 4401, 4409, 4415, 4419, 4421, 4427, 4428, 4446, 4447, 4448, 4456, 4467, 4483, 4484, 4486,
                4495, 4496, 4503, 4516, 4517, 4521, 4523, 4532, 4536, 4555, 4557, 4563, 4564, 4565, 4577, 4579, 4576, 4577, 4581, 4598, 4600, 4620, 4623, 4624, 4627, 4630, 4645, 4646,
                4658, 4668, 4671, 4682, 4665, 4702, 4701, 4705, 4712, 4716, 4715, 4716, 4720, 4726, 4741, 4760, 4765, 4760, 4761, 4764, 4755, 4756, 4757, 4758, 4759, 4761, 4767, 4768,
                4769, 4776, 4774, 4775, 4780, 4782, 4780, 4781, 4782, 4785, 4795, 4788, 4793, 4800, 4812, 4830, 4832, 4831, 4832, 4833, 4846, 4849, 4845, 4849, 4853, 4866, 4870, 4898,
                4900, 4904, 4905, 4907, 4909, 4910, 4911, 4906, 4866, 4868, 4881, 4882, 4894, 4898, 4900, 4913, 4914, 4918, 4926, 4925, 4926, 4918, 4933, 4925, 4932, 4933, 4939, 4940,
                4946, 4947, 4957, 4958, 4960, 4961, 4963, 4968, 4969, 4963, 4964, 4966, 4946, 4950, 4974, 4975, 4978, 4980, 4983, 4985, 5005, 4990, 5002, 5026, 5021, 5039, 5052, 5025,
                5024, 5023, 5026, 5037, 5045, 5056, 5058, 5059, 5060, 5040, 5047, 5050, 5079, 5081, 5086, 5088, 5064, 5067, 5068, 5083, 5097, 5102, 5101, 5087, 5090, 5089, 5088, 5090,
                5092, 5104, 5109, 5111, 5116, 5113, 5114, 5103, 5120, 5122, 5117, 5104, 5126, 5127, 5128, 5121, 5123, 5124, 5127, 5129, 5131, 5132, 5137, 5141, 5164, 5178, 5184, 5196,
                5211, 5210, 5218, 5219, 5250, 5251, 5260, 5250, 5256, 5253, 5251, 5243, 5244, 5245, 5256, 5261, 5262, 5266, 5269, 5270, 5276, 5291, 5299, 5300, 5315, 5317, 5320, 5321,
                5322, 5324, 5333, 5330, 5359, 5362, 5383, 5386, 5389, 5391, 5412, 5413, 5415, 5438, 5439, 5441, 5459, 5460, 5459, 5465, 5461, 5463, 5466, 5470, 5467, 5477, 5483, 5485,
                5486, 5487, 5490, 5518, 5537, 5546, 5556, 5576, 5574, 5582, 5583, 5587, 5583, 5584, 5589, 5590, 5600, 5601, 5602, 5604, 5605, 5606, 5607, 5617, 5604, 5609, 5596, 5597,
                5601, 5607, 5612, 5613, 5625, 5627, 5640, 5642, 5651, 5655, 5651, 5655, 5656, 5680, 5683, 5684, 5687, 5689, 5691, 5696, 5706, 5708, 5729, 5748, 5749, 5753, 5757, 5772,
                5773, 5783, 5785, 5783, 5784, 5785, 5786, 5785, 5787, 5808, 5801, 5803, 5810, 5818, 5823, 5829, 5832, 5826, 5839, 5841, 5844, 5846, 5847, 5860, 5862, 5872, 5869, 5854,
                5865, 5866, 5870, 5872, 5875, 5911, 5924, 5937, 5947, 5965, 5969, 5971, 5976, 5974, 5976, 5960, 5962, 5963, 5965, 5975, 5976, 5985, 5986, 5981, 5990, 5993, 5982, 5989,
                5990, 5994, 6015, 6020, 6030, 6041, 6012, 6014, 6035, 6040, 6016, 6038, 6061, 6047, 6052, 6055, 6057, 6072, 6094, 6099, 6104, 6112, 6110, 6126, 6125, 6135, 6152, 6161,
                6169, 6172, 6187, 6197, 6198, 6206, 6207, 6205, 6204, 6202, 6205, 6200, 6202, 6206, 6223, 6224, 6231, 6237, 6241, 6271, 6272, 6273, 6281, 6277, 6282, 6283, 6298, 6305,
                6307, 6333, 6334, 6340, 6341, 6342, 6343, 6336, 6342, 6343, 6348, 6355, 6375, 6388, 6389, 6391, 6416, 6417, 6418, 6419, 6428, 6462, 6463, 6464, 6465, 6432, 6443, 6444,
                6446, 6451, 6453, 6472, 6470, 6483, 6484, 6495, 6485, 6489, 6490, 6466, 6462, 6468, 6461, 6462, 6458, 6461, 6475, 6499, 6502, 6504, 6506, 6512, 6527, 6528, 6540, 6542,
                6545, 6565, 6566, 6585, 6592, 6597, 6598, 6599, 6613, 6622, 6626, 6637, 6639, 6657, 6672, 6679, 6684, 6687, 6684, 6721, 6722, 6725, 6727, 6728, 6730, 6732, 6751, 6756,
                6763, 6764, 6779, 6807, 6817, 6822, 6824, 6826, 6821, 6823, 6838, 6834, 6835, 6837, 6843, 6862, 6863, 6864, 6865, 6835, 6839, 6844, 6845, 6884, 6885, 6895, 6904, 6905,
                6908, 6909, 6914, 6916, 6917, 6920, 6921, 6920, 6921, 6934, 6913, 6917, 6928, 6930, 6931, 6941, 6944, 6957, 6959, 6967, 6970, 6971, 6973, 6984, 6986, 6987, 6990, 6993,
                6994, 7018, 7019, 7026, 7028, 7044, 7048, 7051, 7053, 7052, 7050, 7053, 7056, 7030, 7044, 7043, 7055, 7067, 7068, 7083, 7065, 7066, 7082, 7084, 7088, 7079, 7078, 7080,
                7081, 7083, 7086, 7092, 7102, 7122, 7146, 7149, 7150, 7155, 7167, 7170, 7168, 7176, 7185, 7186, 7182, 7183, 7185, 7187, 7204, 7208, 7209, 7211, 7228, 7230, 7232, 7233,
                7239, 7242, 7245, 7246, 7247, 7251, 7253, 7255, 7258, 7259, 7268, 7270, 7272, 7291, 7319, 7320, 7321, 7323, 7333, 7351, 7343, 7349, 7366, 7378, 7383, 7384, 7381, 7377,
                7379, 7383, 7386, 7401, 7410, 7438, 7441, 7443, 7444, 7446, 7445, 7446, 7448, 7459, 7462, 7457, 7461, 7462, 7466, 7477, 7489, 7497, 7500, 7501, 7523, 7524, 7527, 7536,
                7538, 7539, 7541, 7533, 7536, 7539, 7547, 7567, 7548, 7544, 7546, 7548, 7563, 7564, 7571, 7583, 7585, 7594, 7597, 7605, 7606, 7633, 7655, 7656, 7660, 7672, 7676, 7684,
                7686, 7687, 7688, 7689, 7681, 7680, 7691, 7690, 7711, 7725, 7726, 7729, 7741, 7744, 7745, 7772, 7773, 7786, 7782, 7783, 7788, 7794, 7795, 7803, 7804, 7813, 7817, 7848,
                7858, 7849, 7856, 7858, 7860, 7859, 7877, 7878, 7879, 7901, 7931, 7935, 7937, 7944, 7945, 7949, 7954, 7955, 7953, 7956, 7968, 7970, 7973, 7974, 7971, 7975, 7991, 7989,
                7994, 7985, 7988, 8002, 8008, 8015, 8019, 8029, 8028, 8052, 8057, 8051, 8063, 8065, 8064, 8069, 8082, 8093, 8098, 8105, 8104, 8109, 8103, 8119, 8130, 8153, 8165, 8157,
                8159, 8176, 8168, 8173, 8171, 8162, 8176, 8182, 8190, 8208, 8212, 8213, 8214, 8220, 8222, 8209, 8194, 8220, 8221, 8242, 8252, 8255, 8252, 8231, 8239, 8236, 8237, 8242,
                8244, 8245, 8246, 8261, 8280, 8281, 8282, 8288, 8289, 8283, 8287, 8288, 8299, 8303, 8305, 8318, 8319, 8328, 8331, 8344, 8346, 8371, 8377, 8388, 8405, 8414, 8415, 8416,
                8396, 8364, 8352, 8353, 8362, 8363, 8369, 8375, 8382, 8403, 8405, 8407, 8406, 8411, 8419, 8423, 8427, 8433, 8434, 8439, 8442, 8447, 8436, 8442, 8443, 8451, 8452, 8472,
                8473, 8499, 8504, 8496, 8481, 8484, 8511, 8503, 8506, 8513, 8517, 8522, 8525, 8524, 8527, 8532, 8551, 8552, 8554, 8555, 8558, 8567, 8568, 8570, 8571, 8573, 8574, 8577,
                8578, 8579, 8586, 8596, 8597, 8616, 8617, 8620, 8624, 8625, 8627, 8629, 8642, 8643, 8648, 8662, 8664, 8665, 8679, 8686, 8685, 8711, 8714, 8718, 8720, 8724, 8726, 8735,
                8736, 8777, 8778, 8780, 8783, 8779, 8788, 8789, 8825, 8827, 8837, 8871, 8873, 8874, 8881, 8898, 8902, 8871, 8884, 8885, 8889, 8915, 8909, 8910, 8912, 8915, 8914, 8922,
                8927, 8941, 8979, 8974, 8987, 8974, 8981, 8975, 9004, 9008, 9011, 9025, 9027, 9028, 9030, 9043, 9057, 9072, 9078, 9084, 9088, 9091, 9095, 9101, 9105, 9114, 9123, 9134,
                9174, 9171, 9172, 9173, 9171, 9179, 9183, 9188, 9190, 9196, 9197, 9198, 9202, 9210, 9231, 9232, 9243, 9256, 9257, 9259, 9263, 9265, 9264, 9258, 9273, 9282, 9285, 9269,
                9274, 9262, 9261, 9270, 9284, 9285, 9286, 9289, 9290, 9291, 9293, 9282, 9285, 9286, 9289, 9287, 9289, 9291, 9289, 9290, 9299, 9302, 9316, 9317, 9342, 9337, 9339, 9340,
                9341, 9342, 9371, 9373, 9374, 9373, 9374, 9376, 9384, 9390, 9423, 9424, 9427, 9429, 9430, 9431, 9432, 9434, 9465, 9473, 9474, 9478, 9482, 9483, 9485, 9469, 9471, 9441,
                9457, 9467, 9462, 9474, 9475, 9481, 9475, 9476, 9479, 9482, 9484, 9493, 9500, 9506, 9509, 9510, 9511, 9524, 9529, 9558, 9571, 9576, 9579, 9581, 9582, 9587, 9594, 9618,
                9638, 9646, 9649, 9650, 9649, 9655, 9646, 9648, 9652, 9665, 9659, 9697, 9703, 9733, 9750, 9751, 9753, 9754, 9755, 9761, 9762, 9766, 9784, 9789, 9766, 9767, 9768, 9771,
                9785, 9789, 9792, 9807, 9821, 9823, 9830, 9844, 9847, 9857, 9858, 9860, 9873, 9870, 9873, 9887, 9880, 9878, 9891, 9893, 9894, 9896, 9902, 9911, 9920, 9931, 9963, 9972,
                9974, 9973, 9974, 9976, 9990, 9989, 9996, 9995, 10024, 10025, 10026, 10028, 10040, 10041, 10040, 10041, 10044
        };

    }
}