/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
  this.cap = capacity;
  this.cache = new Map();
};

/** 
* @param {number} key
* @return {number}
*/
LRUCache.prototype.get = function(key) {
  let cache = this.cache;
  if(cache.has(key)){
      let val = cache.get(key);
      cache.delete(key);
      cache.set(key,val);
      return val;
  }else{
      return -1;
  }
};

/** 
* @param {number} key 
* @param {number} value
* @return {void}
*/
LRUCache.prototype.put = function(key, value) {
  let cache = this.cache;   
  if(cache.has(key)){
      cache.delete(key);
  }else{
      if(cache.size == this.cap){
          cache.delete(cache.keys().next().value);
      }
  }
  cache.set(key,value);
};

/** 
* Your LRUCache object will be instantiated and called as such:
* var obj = new LRUCache(capacity)
* var param_1 = obj.get(key)
* obj.put(key,value)
*/
var cache = new LRUCache( 2 /* 缓存容量 */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得密钥 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得密钥 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4

