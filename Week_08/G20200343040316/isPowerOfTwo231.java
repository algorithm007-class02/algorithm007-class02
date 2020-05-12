package com.wxs.algorithm1.week08;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/5/10
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class isPowerOfTwo231 {


    public boolean isPowerOfTwo(int n) {

        return n > 0 && (n &(n-1))==0;
    }
}
