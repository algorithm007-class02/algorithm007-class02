/*
 * @Author: mingxing.huang
 * @Date: 2020-04-03 11:18:26
 */
/**
 * 874. 模拟行走机器人
 * @param {number[]} commands
 * @param {number[][]} obstacles
 * @return {number}
 */
var robotSim = function(commands, obstacles) {
  let res = 0;
  let x = 0;
  let y = 0;
  let d = "up";
  let dirs = { up: [0, 1], down: [0, -1], right: [1, 0], left: [-1, 0] };
  let turnRightDirs = { up: "right", right: "down", down: "left", left: "up" };
  let turnLeftDirs = { up: "left", left: "down", down: "right", right: "up" };
  let ob = {};
  for (let o of obstacles) {
    ob[o[0] + "," + o[1]] = true;
  }
  for (let i = 0; i < commands.length; i++) {
    // console.log("当前方向：", d);
    if (commands[i] === -1) {
      d = turnRightDirs[d];
    } else if (commands[i] === -2) {
      d = turnLeftDirs[d];
    } else {
      // 一步一步走，前方有障碍就跳过
      for (let s = 1; s <= commands[i]; s++) {
        let newX = x + dirs[d][0];
        let newY = y + dirs[d][1];
        if (ob[newX + "," + newY]) {
          break;
        }
        x = newX;
        y = newY;
        res = Math.max(res, x ** 2 + y ** 2);
      }
    }
  }
  return res;
};
