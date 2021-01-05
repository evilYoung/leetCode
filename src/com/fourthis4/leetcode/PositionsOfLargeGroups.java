package com.fourthis4.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 *
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PositionsOfLargeGroups {

    public List<List<Integer>> largeGroupPositions(String s) {
        if (s == null || "".equals(s)) {
            return Collections.emptyList();
        }
        //为了不用判断最后一个
        s = s + "A";
        char[] c = s.toCharArray();
        List<List<Integer>> result = new ArrayList<>();

        int pos = 0;
        char t = c[pos];
        for (int i = 0; i < c.length; i++) {
            if (c[i] != t) {
                if (i - pos > 2) {
                    result.add(Arrays.asList(pos, i - 1));
                }
                pos = i;
                t = c[pos];
            }
        }

        return result;
    }

}
