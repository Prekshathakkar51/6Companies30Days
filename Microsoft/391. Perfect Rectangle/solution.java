

public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) {
            return false;
        } else {
            HashSet<String> set = new HashSet<>();
            int leftMost = Integer.MAX_VALUE;
            int bottomMost = Integer.MAX_VALUE;
            int rightMost = Integer.MIN_VALUE;
            int topMost = Integer.MIN_VALUE;
            int x1, y1, x2, y2;
            long area = 0;
            for (int[] rect : rectangles) {
                x1 = rect[0];
                y1 = rect[1];
                x2 = rect[2];
                y2 = rect[3];
                area += (x2 - x1) * (y2 - y1);
                if (x1 < leftMost) {
                    leftMost = x1;
                }
                if (y1 < bottomMost) {
                    bottomMost = y1;
                }
                if (x2 > rightMost) {
                    rightMost = x2;
                }
                if (y2 > topMost) {
                    topMost = y2;
                }
                if (area > (rightMost - leftMost) * (topMost - bottomMost)) {
                
                    return false;
                }
                
                String key1 = x1 + "," + y1;
                String key2 = x1 + "," + y2;
                String key3 = x2 + "," + y1;
                String key4 = x2 + "," + y2;
                
                if (set.contains(key1)) {
                    set.remove(key1);
                } else {
                    set.add(key1);
                }

                if (set.contains(key2)) {
                    set.remove(key2);
                } else {
                    set.add(key2);
                }

                if (set.contains(key3)) {
                    set.remove(key3);
                } else {
                    set.add(key3);
                }

                if (set.contains(key4)) {
                    set.remove(key4);
                } else {
                    set.add(key4);
                }
            }

            if (area != (rightMost - leftMost) * (topMost - bottomMost)) {//说明没有完全覆盖或出现了重叠覆盖
                return false;
            }

            String key1 = leftMost + "," + bottomMost;
            String key2 = leftMost + "," + topMost;
            String key3 = rightMost + "," + bottomMost;
            String key4 = rightMost + "," + topMost;
            if (set.size() != 4 || !set.contains(key1) ||
                !set.contains(key2) || !set.contains(key3) ||
                !set.contains(key4)) {
                return false;
            } else {
                return true;
            }
        }
    }
}
