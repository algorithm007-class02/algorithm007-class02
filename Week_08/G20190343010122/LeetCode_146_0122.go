package homework

import (
	"container/list"
)

type LRUNode struct {
	key int
	value int
}

type LRUCache struct {
	cacheMap map[int]*list.Element
	cacheList *list.List
	capacity int
}


func Constructor(capacity int) LRUCache {
	lru := LRUCache{}
	lru.cacheMap = make(map[int]*list.Element)
	lru.cacheList = list.New()
	lru.capacity = capacity
	return lru
}


func (this *LRUCache) Get(key int) int {
	if v, ok := this.cacheMap[key]; ok{
		this.cacheList.Remove(v)
		v = this.cacheList.PushBack(v.Value)
		this.cacheMap[key] = v
		return v.Value.(LRUNode).value
	}

	return -1
}


func (this *LRUCache) Put(key int, value int)  {
	if v, ok := this.cacheMap[key]; ok{
		this.cacheList.Remove(v)
		v.Value = LRUNode{key, value}
		v = this.cacheList.PushBack(v.Value)
		this.cacheMap[key] = v
	}else {
		if this.cacheList.Len() >= this.capacity{
			front := this.cacheList.Front()
			this.cacheList.Remove(front)
			delete(this.cacheMap, front.Value.(LRUNode).key)
		}
		listEle := this.cacheList.PushBack(LRUNode{key,value})
		this.cacheMap[key] = listEle
	}
}
