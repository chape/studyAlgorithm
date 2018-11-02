package leetcode.easy.stack_queue_heap;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by ChaoChao on 2018/8/12.
 实现一个基本的计算器来计算一个简单的字符串表达式的值。

 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。

 示例 1:

 输入: "1 + 1"
 输出: 2
 示例 2:

 输入: " 2-1 + 2 "
 输出: 3
 示例 3:

 输入: "(1+(4+5+2)-3)+(6+8)"
 输出: 23
 说明：

 你可以假设所给定的表达式都是有效的。
 请不要使用内置的库函数 eval。
 */
public class Calculator_224 {

    @Test
    public void testCalculate() {

        String expression = "(1+(4+5+2)-3)+(6+8)";
        int result = calculate(expression);

        System.out.println("计算结果:"+result);

    }

    public int calculate(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opeStack = new Stack<>();

        // 状态机 字符-数字状态机
        final int START_STATE = 0;
        final int NUM_STATE = 1;
        final int OPERATION_STATE = 2;
        //初始状态
        int state = START_STATE;

        // 可计算标志
        boolean computeFlag = false;
        // 数字值
        int num = 0;
        char[] expression = s.toCharArray();
        for (int i = 0; i < expression.length; i++) {
            if(' ' == expression[i]) {
                continue;
            }
            switch (state) {
                case START_STATE:
                    if(expression[i] >= '0' && expression[i] <= '9') {
                        state = NUM_STATE;
                    } else {
                        state = OPERATION_STATE;
                    }
                    // 退格 进入 NUM_STATE 或 OPERATION_STATE
                    i--;
                    break;
                case NUM_STATE:
                    if(expression[i] >= '0' && expression[i] <= '9') {
                        num = 10 * num + expression[i] - '0';
                    } else {
                        numStack.push(num);
                        if(computeFlag) {
                            compute(numStack,opeStack);
                        }
                        num = 0;
                        // 此时为非数字 需要重新进入switch语句 OPERATION_STATE
                        i--;
                        // 由 NUM_STATE 转化为 OPERATION_STATE
                        state = OPERATION_STATE;
                    }

                    break;
                case OPERATION_STATE:
                    if(expression[i] == '-' || expression[i] == '+') {
                        opeStack.push(expression[i]);
                        computeFlag = true;
                    } else if(expression[i] == '(') {
                        state = NUM_STATE;
                        computeFlag = false;
                    } else if(expression[i] == ')') {
                        compute(numStack,opeStack);
                    }else if(expression[i] >= '0' && expression[i] <= '9') {
                        // 由 OPERATION_STATE 转化为 NUM_STATE
                        state = NUM_STATE;
                        // 此时为数字 需要重新进入switch语句 NUM_STATE
                        i--;
                    }
                    break;
            }
        }
        if(0 != num) {
            numStack.push(num);
            compute(numStack,opeStack);
        }
        if(0 == num && numStack.isEmpty()) {
            return 0;
        }
        return numStack.pop();
    }


    private void compute(Stack<Integer> numStack, Stack<Character> opeStack) {
        if(numStack.size() < 2) {
            return;
        }
        Integer num1 = numStack.pop();
        Integer num2 = numStack.pop();

        Character operation = opeStack.pop();
        if('+' == operation) {
            numStack.push(num1 + num2);
        }
        if('-' == operation) {
            numStack.push(num2 - num1);
        }
    }



}
