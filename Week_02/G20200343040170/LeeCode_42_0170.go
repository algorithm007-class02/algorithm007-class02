func trap(height []int) int {
    cap := 0
    leftMax := 0
    rightMax := 0
    left, right := 0, len(height) - 1
    for left < right {
        if height[left] < height[right] {
            if height[left] >= leftMax {
                leftMax = height[left]
            } else {
                cap += leftMax - height[left]
            }
            left++
        } else {
            if height[right] > rightMax {
                rightMax = height[right]
            } else {
                cap += rightMax - height[right]
            }
            right--
        }
    }

    return cap
}
