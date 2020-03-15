var removeDuplicates = function (nums) {
    if(nums.length===0) {
        return 0;
    }

    var len = 0;
    for(var i=0; i<nums.length; i++) {
        if(nums[i]!==nums[len]) {
            nums[++len] = nums[i];
        }
    }
    return len + 1;
};
