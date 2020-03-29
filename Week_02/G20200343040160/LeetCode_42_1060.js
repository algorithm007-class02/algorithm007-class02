/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    if (!height.length) return 0;
    const maxHeight = Math.max.apply(null, height), len = height.length;
    let rainArea = 0, edge_i = 0, edge_j = 0, i = 0, j = len - 1;
    while (edge_i !== maxHeight && edge_j !== maxHeight) {
        height[i] > edge_i ? edge_i = height[i++] : rainArea += edge_i - height[i++];
        height[j] > edge_j ? edge_j = height[j--] : rainArea += edge_j - height[j--];
    }
    if (edge_j === maxHeight) {
        while (i <= j) {
            height[i] > edge_i ? edge_i = height[i++] : rainArea += edge_i - height[i++];
        }
    } else {
        while (i <= j) {
            height[j] > edge_j ? edge_j = height[j--] : rainArea += edge_j - height[j--];
        }
    }
    return rainArea;
};