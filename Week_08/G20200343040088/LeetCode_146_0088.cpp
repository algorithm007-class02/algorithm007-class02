class LRUCache {
    int size_;
    list<pair<int, int>> cache_;
    unordered_map<int, list<pair<int, int>>::iterator> map_;
public:
    LRUCache(int capacity) {
        size_ = capacity;
    }
    
    int get(int key) {
        auto iter = map_.find(key);
        if (iter == map_.end()) {
            return -1;
        } else {
            auto it = map_[key];
            pair<int, int> temp = *it;
            cache_.erase(it);
            cache_.push_front(temp);
            map_[key] = cache_.begin();
            return temp.second;
        }
    }
    
    void put(int key, int value) {
        auto iter = map_.find(key);
        if (iter == map_.end()) {
            if (cache_.size() == size_) {
                pair<int, int> temp = cache_.back();
                map_.erase(temp.first);
                cache_.pop_back();
            }
            cache_.push_front(make_pair(key, value));
            map_[key] = cache_.begin();
        } else {
            cache_.erase(map_[key]);
            cache_.push_front(make_pair(key, value));
            map_[key] = cache_.begin();
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */