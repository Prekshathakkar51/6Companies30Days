class Solution {
    int[] res = new int[12];
    int max = 0;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        compute(numArrows, aliceArrows, new int[12], 11, 0);
        return res;
    }

    private void compute(int numArrows, int[] aliceArrows, int[] bobArrows, int idx, int point) {
        if (idx == 0) {
            if (point > max) {
                max = point;
                bobArrows[idx] = numArrows;
                res = bobArrows.clone();
            }
            return;
        }
        compute(numArrows, aliceArrows, bobArrows, idx - 1, point);
        if (numArrows > aliceArrows[idx]) {
            bobArrows[idx] = aliceArrows[idx] + 1;
            compute(numArrows - bobArrows[idx], aliceArrows, bobArrows, idx - 1, point + idx);
            bobArrows[idx] = 0;
        }
    }
}