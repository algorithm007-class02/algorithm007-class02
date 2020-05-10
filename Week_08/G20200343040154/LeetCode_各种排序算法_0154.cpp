class Solution {
public:
	// 桶排序
	vector<int> bucketSort(vector<int>& nums) {
		if (nums.empty()) return {};
		int low = *min_element(nums.begin(), nums.end());
		int high = *max_element(nums.begin(), nums.end());
		int n = high - low + 1;
		vector<int> buckets(n);
		for (auto x : nums) ++buckets[x - low];
		vector<int> res;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < buckets[i]; ++j) {
				res.push_back(i + low);
			}
		}
		return res;
	}
	
	// 归并排序
	vector<int> mergeSort(vector<int>& nums, int l, int r) {
		if (l > r) return {};
		if (l == r) return {nums[l]};
		vector<int> res;
		int m = l + (r - l) / 2;
		auto ln = mergeSort(nums, l, m);
		auto rn = mergeSort(nums, m + 1, r);
		int i = 0;
		int j = 0;
		while (i < ln.size() && j < rn.size()) {
			if (ln[i] <= rn[j]) {
				res.push_back(ln[i++]);
			} else {
				res.push_back(rn[j++]);
			}
		}
		while (i < ln.size()) res.push_back(ln[i++]);
		while (j < rn.size()) res.push_back(rn[j++]);
		return res;
	}
	
	// 快速排序
	void quickSort(vector<int>& nums, int l, int r) {
		if (l >= r) return;
		int m = l + (r - l) / 2;
		swap(nums[r], nums[m]);
		int t = l;
		for (int i = l; i < r; ++i) {
			if (nums[i] < nums[r]) {
				swap(nums[t++], nums[i]);
			}
		}
		swap(nums[t], nums[r]);
		quickSort(nums, l, t - 1);
		quickSort(nums, t + 1, r);
	}
	
	// 三路快排
	void quickSortV2(vector<int>& nums, int l, int r) {
		if (l >= r) return;
		int t = nums[l + (r - l) / 2];
		int tl = l;
		int tr = r;
		for (int i = tl; i <= tr;) {
			if (nums[i] == t) {
				++i;
			} else if (nums[i] < t) {
				swap(nums[i++], nums[tl++]);
			} else {
				swap(nums[i], nums[tr--]);
			}
		}
		quickSortV2(nums, l, tl - 1);
		quickSortV2(nums, tr + 1, r);
	}

	// 希尔排序
	void shellSort(vector<int>& nums) {
		for (int gap = nums.size() / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < nums.size(); ++i) {
				for (int j = i; j - gap >= 0 && nums[j - gap] > nums[j]; j -= gap) {
					swap(nums[j - gap], nums[j]);
				}
			}
		}
	}
	
	// 堆排序
	void adjust(vector<int>& nums, int p, int s) {
		while (2 * p + 1 < s) {
			int c1 = 2 * p + 1;
			int c2 = 2 * p + 2;
			int c = (c2 < s && nums[c2] > nums[c1]) ? c2 : c1;
			if (nums[c] > nums[p]) swap(nums[c], nums[p]);
			else break;
			p = c;
		}
	}
	void heapSort(vector<int>& nums) {
		for (int i = nums.size() / 2; i >= 0; --i) {
			adjust(nums, i, nums.size());
		}
		for (int i = nums.size() - 1; i > 0; --i) {
			swap(nums[0], nums[i]);
			adjust(nums, 0, i);
		}
	}  
	 
	// 冒泡排序
	void bubbleSort(vector<int>& nums) {
		for (int i = 0; i < nums.size(); ++i) {
			for (int j = 0; j < i; ++j) {
				if (nums[i] < nums[j]) {
					swap(nums[i], nums[j]);
				}
			}
		}
	}
	
	// 插入排序
	void insertSort(vector<int>& nums) {
		for (int i = 0; i < nums.size(); ++i) {
			for (int j = i; j - 1 >= 0 && nums[j - 1] > nums[j]; --j) {
				swap(nums[j - 1], nums[j]);
			}
		}
	}
	
	// 选择排序
	void selectSort(vector<int>& nums) {
		for (int i = 0; i < nums.size(); ++i) {
			int min_ind = i;
			for (int j = i; j < nums.size(); ++j) {
				if (nums[j] < nums[min_ind]) {
					min_ind = j;
				}
			}
			swap(nums[i], nums[min_ind]);
		}
	}

};
