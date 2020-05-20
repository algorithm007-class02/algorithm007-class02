// 146. LRU缓存机制
// https://leetcode-cn.com/problems/lru-cache/#/

// 解法：比较规范的版本1
// 使用迭代器版本：更简洁
class LRUCache {
private:
	// Cache的容量大小
	int cap;
	// 双链表：装着（key,value）元祖
	list<pair<int, int>> cache;
	// 哈希表：key映射到（key,value）在 cache 中的位置
	unordered_map<int, list<pair<int, int>>::iterator> map;
public:
	LRUCache(int capacity) {
	   this->cap = capacity;
	}
	
	int get(int key) {
		// 根据Key在Map中查找
		auto it = map.find(key);
		// 访问的key不存在
		if (it == map.end()) return -1;
		// key存在，把（key,value）换到队头
		pair<int, int> kv = *map[key];
		cache.erase(map[key]);
		cache.push_front(kv);
		// 更新（key,value）在cache中的位置
		map[key] = cache.begin();
		return kv.second;
	}
	
	void put(int key, int value) {
		auto it = map.find(key);
		// map 中不存在这个 key
		if (it == map.end()) {
			// 判断 cache 是否已满
			if (cache.size() == cap) {
				// cache 已满，删除尾部的键值对腾位置
				// cache 和 map 中的数据都要删除
				auto kv = cache.back();
				int lastKey = kv.first;
				map.erase(lastKey);
				cache.pop_back();
			}
			// cache 没满，可以直接添加
			cache.push_front(make_pair(key, value));
			map[key] = cache.begin();
		} else {
			// key存在，更改value并换到队头
			cache.erase(map[key]);
			cache.push_front(make_pair(key, value));
			map[key] = cache.begin();
		}
	}
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */



// 解法2：左神版本
// 手写双链表版本

struct Node {
	int key;
	int value;
	Node* pre;
	Node* next;
	// 构造函数初始化
	Node(int key, int value) : key(key), value(value), pre(nullptr), next(nullptr) {}
};

class LRUCache {
private:
	int size; //缓冲区大小
	Node* head;
	Node* tail;
	map<int, Node*> map;

public:
	LRUCache(int capacity) {
		this->size = capacity;
		head = nullptr;
		tail = nullptr;
	}

	// 删除当前节点
	void remove(Node* cur) {
		if (cur == head) {
			head = cur->next;
		} else if (cur == tail) {
			tail = cur->pre;
		} else {
			cur->next->pre = cur->pre;
			cur->pre->next = cur->next;
		}
	}

	// 添加到双链表的头部
	void addFirst(Node* cur) {
		cur->next = head;
		if (head != nullptr)
			head->pre = cur;
		head = cur; // 重置head节点指向
		if (tail == nullptr)
			tail = head;     // ????
	}
	
	int get(int key) {
		// 1.当key存在时
		if (map.count(key) > 0) {
			// 删除key对应的原来节点
			Node* cur = map[key];
			int value = cur->value;
			remove(cur);
			// 将节点重新插入到缓冲区的头部
			addFirst(cur);
			return value;
		}
		// 2.当key不存在时
		return -1;
	}
	
	void put(int key, int value) {
		// 当key存在时
		if (map.count(key) > 0) {
			Node* cur = map[key];
			cur->value = value;
			remove(cur);
			addFirst(cur);
		} else {
			Node* node = new Node(key, value);
			// 判断当前缓冲区大小已经满了
			if (map.size() >= size) {
				std::map<int, Node*>::iterator it = map.find(tail->key); // 返回迭代器类型
				remove(tail);
				map.erase(it); // 这里erase 函数参数是迭代器类型，所以上面需要使用迭代器类型
			}
			addFirst(node);
			map[key] = node;
		}
	}
};