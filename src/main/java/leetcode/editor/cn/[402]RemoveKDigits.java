//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。 
//
// 注意: 
//
// 
// num 的长度小于 10002 且 ≥ k。 
// num 不会包含任何前导零。 
// 
//
// 示例 1 : 
//
// 
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
// 
//
// 示例 2 : 
//
// 
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 : 
//
// 
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
// 
// Related Topics 栈 贪心算法

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        /**
         *  测试用例
         *  1432219 3 => 1219
         *  12345 3 => 12
         *  143 4 => 0
         *  10200 1 => 200
         */
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : num.toCharArray()) {
            while(!stack.isEmpty() && k > 0 && c < stack.peekLast()) {
                stack.removeLast();
                k--;
            }
            stack.addLast(c);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.removeLast();
            k--;
        }
        StringBuilder result = new StringBuilder();
        boolean isLeadZero = true;
        for (char c : stack) {
            if(isLeadZero && c == '0') continue;
            isLeadZero = false;
            result.append(c);
        }
        if(result.length()==0) result.append("0");
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
