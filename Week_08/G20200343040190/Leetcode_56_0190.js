/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
// 双指针84ms
// 第一种情况[1,4],[5,6]
// 第二种情况[1,4],[2,3]
// 第三种情况[1,4],[3,6]
var merge = function(intervals) {
  let arr=intervals.sort((a,b)=>a[0]-b[0]);
  let savePoint=0;scanPoint=1;
  let res=[];
  if(intervals.length===1) return [intervals[0]];
  while(scanPoint<arr.length){
      if(arr[savePoint][1]<arr[scanPoint][0]){
          res.push(arr[savePoint]);
      }
      if(arr[savePoint][1]>=arr[scanPoint][1]){
          arr[savePoint+1]=arr[savePoint];
      }
      if(arr[savePoint][1]>=arr[scanPoint][0]&&arr[savePoint][1]<arr[scanPoint][1]){
          let newArr=[arr[savePoint][0],arr[scanPoint][1]];
          arr[savePoint+1]=newArr;
      }
      savePoint++;
      scanPoint++;
  }
  if(scanPoint===arr.length){
      res.push(arr[savePoint]);
  }
  return res
};
merge([[1,3],[2,6],[8,10],[15,18]]);
