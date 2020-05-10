class LRUCache {
public:
	class LinkNode
	{
	public:
		LinkNode() {
		};

		int key;
		int value;
		LinkNode* pre;
		LinkNode* next;
	};

	void addNode(LinkNode* node) {
		node->pre = head;
		node->next = head->next;
		head->next->pre = node;
		head->next = node;
	}

	void removeNode(LinkNode* node) {
		node->pre->next = node->next;
		node->next->pre = node->pre;
	}

	void moveToHead(LinkNode* node) {
		removeNode(node);
		addNode(node);
	}

	LinkNode* popTailNode() {
		LinkNode* lastNode= tail->pre;
		removeNode(lastNode);
		return lastNode;
	}

	LRUCache(int capacity) {
		head = new LinkNode();
		tail = new LinkNode();
		head->next = tail;
		tail->pre = head;
		this->capcity = capacity;
		this->size = 0;
	}

	int get(int key) {
		unordered_map<int, LinkNode*>::iterator iter = hash_table.find(key);
		if (iter != hash_table.end()) {
			moveToHead(iter->second);
			return iter->second->value;
		}
		else {
			return -1;
		}
	}

	void put(int key, int value) {
		unordered_map<int, LinkNode*>::iterator iter = hash_table.find(key);
		if (iter != hash_table.end()) {
			moveToHead(iter->second);
			iter->second->value = value;
		}
		else {
			LinkNode* node = new LinkNode();
			node->key = key;
			node->value = value;
			addNode(node);
			hash_table.insert(pair<int, LinkNode*>(key, node));

			size++;
			if (size > capcity) {
				LinkNode* lastNode = popTailNode();
				hash_table.erase(lastNode->key);
				size--;
			}
		}
	}

	LinkNode* head;
	LinkNode* tail;
	int capcity;
	int size;
	unordered_map<int, LinkNode*> hash_table;
};