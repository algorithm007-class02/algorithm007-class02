/**
 * @param {number} capacity
 */
var LRUCache = function (capacity) {
  this.capacity = capacity;
  this.cache = new Map();
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function (key) {
  if (!this.cache.has(key)) return -1;

  let temp = this.cache.get(key);
  this.cache.delete(key);
  this.cache.set(key, temp);
  return this.cache.get(key);
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function (key, value) {
  if (this.cache.has(key)) {
    this.cache.delete(key);
  }

  this.cache.set(key, value);
  if (this.cache.size > this.capacity) {
    let temp = this.cache.keys().next().value;
    this.cache.delete(temp);
  }

  this.cache.set(key, value);
};