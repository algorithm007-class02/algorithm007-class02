/*
 * @Author: mingxing.huang
 * @Date: 2020-05-16 17:11:21
 */
/**
 * 438. 找到字符串中所有字母异位词
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function (s, p) {
    // let res = [];
    // let len = p.length;
    // for (let i = 0; i <= s.length - len; i++) {
    //     let sub = s.substring(i, i + len);
    //     if (sortStr(sub) === sortStr(p)) {
    //         res.push(i);
    //     }
    // }
    // return res;

    // function sortStr(s) {
    //     return s.split('').sort((a, b) => a.codePointAt() - b.codePointAt()).join('')
    // }

    if (!s || !p) return [];
    let window = {}
    let ans = [];
    // 保存p中字符及其个数
    let need = {};
    [...p].map(c => need[c] ? need[c]++ : need[c] = 1);
    let l = 0, r = 0, cnt = 0, nkLen = Object.keys(need).length;
    while (r < s.length) {
        let c1 = s[r];
        if (need[c1]) {
            window[c1] ? window[c1]++ : window[c1] = 1;
            if (window[c1] === need[c1]) cnt++;
        }
        r++;
        while (cnt === nkLen) {
            let c2 = s[l];
            if ((r - l) == p.length) ans.push(l);
            if (need[c2]) {
                window[c2]--;
                if (window[c2] < need[c2]) cnt--;
            }
            l++;
        }
    }
    return ans;
};