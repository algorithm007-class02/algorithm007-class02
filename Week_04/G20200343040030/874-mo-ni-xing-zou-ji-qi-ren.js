/**
 * @param {number[]} commands
 * @param {number[][]} obstacles
 * @return {number}
 */
var robotSim = function(commands, obstacles) {
  var dx = [0, 1, 0, -1];
  var dy = [1, 0, -1, 0];
  var di = 0;
  var endX = 0;
  var endY = 0;
  var result = 0;
  var hashObstacle = {};
  for (var r = 0; r < obstacles.length; r++) {
    hashObstacle[obstacles[r][0] + "-" + obstacles[r][1]] = true;
  }
  for (var s = 0; s < commands.length; s++) {
    if (commands[s] == -2) {
      di = (di + 3) % 4;
    } else if (commands[s] == -1) {
      di = (di + 1) % 4;
    } else {
      // 每次走一步
      for (var z = 1; z <= commands[s]; z++) {
        var nextX = endX + dx[di];
        var nextY = endY + dy[di];
        // 判断下一步是否为障碍物
        if (hashObstacle[nextX + "-" + nextY]) {
          break;
        }
        endX = nextX;
        endY = nextY;
        result = Math.max(result, endX * endX + endY * endY);
      }
    }
  }
  return result;
};
