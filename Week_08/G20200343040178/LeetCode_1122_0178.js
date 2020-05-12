/*
 * @Author: mingxing.huang
 * @Date: 2020-05-06 21:34:54
 */
/**
 * 数组的相对排序
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function (arr1, arr2) {
    // 思路：将arr1按照arr2元素顺序排序，剩下的再升序排序
    let k = 0;
    for (let i = 0; i < arr2.length; i++) {
        for (let j = 0; j < arr1.length; j++) {
            if (arr1[j] === arr2[i]) {
                let temp = arr1[k];
                arr1[k] = arr1[j];
                arrj[j] = temp;
                k++;
            }
        }
    }
    let front = arr1.slice(0, k);
    let end = arr1.slice(k).sort((a, b) => a - b);
    return front.concat(end);
}