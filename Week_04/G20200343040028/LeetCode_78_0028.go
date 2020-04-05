package G20200343040028

func searchMatrix(matrix [][]int, target int) bool {
	if len(matrix)==0||len(matrix[0])==0{
		return false
	}
	low:=0
	high:=len(matrix)-1
	return binarySearchMatrix(matrix,low,high,target)
}

func binarySearchMatrix(matrix [][]int,low int,high int,target int)  bool{
	//最终的目的应该要精确定位到某一行
	if target<matrix[low][0]||target>matrix[high][len(matrix[low])-1] {
		return false
	}
	if low==high{
		return bSearch(matrix[low],target)
	}
	temp:=(low+high)/2
	if target<matrix[temp][0] {
		return binarySearchMatrix(matrix,low,temp-1,target)
	}else if target<=matrix[temp][len(matrix[temp])-1] {
		return bSearch(matrix[temp],target)
	}else{
		return binarySearchMatrix(matrix,temp+1,high,target)
	}
}

func bSearch(arr []int,target int) bool{
	i,j:=0,len(arr)-1
	if target<arr[i]||target>arr[j] {
		return false
	}
	for i<=j{
		temp:=(i+j)/2
		if arr[temp]==target  {
			return true
		}
		if arr[temp]>target {
			j=temp-1
		}else{
			i=temp+1
		}
	}
	return false
}
