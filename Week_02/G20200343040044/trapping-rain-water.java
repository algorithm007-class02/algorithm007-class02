public static int trap(int a[]) {
	if (a == null || a.length <= 0)
		return 0;
	int n = a.length;
	int low = 0, high = n - 1, secondMaxHeight = -1, area = 0;//
	while (low <= high) {
		if (a[low] < a[high]) {
			if (a[low] > secondMaxHeight)
				secondMaxHeight = a[low];
			area += secondMaxHeight - a[low];
			low++;

		} else {
			if (a[high] > secondMaxHeight)
				secondMaxHeight = a[high];
			area += secondMaxHeight - a[high];
			high--;
		}
	}

	return area;
}