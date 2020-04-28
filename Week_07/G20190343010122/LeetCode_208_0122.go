package homework


type Trie struct {
	root *TrieNode
}


/** Initialize your data structure here. */
func Constructor() Trie {
	this:= Trie{}
	this.root = NewTrieNode()
	return this
}


/** Inserts a word into the trie. */
func (this *Trie) Insert(word string)  {
	node := this.root
	for i:=0; i<len(word); i++ {
		curChar := word[i]
		if !node.ContainKey(curChar){
			node.put(curChar, &TrieNode{})
		}
		node = node.get(curChar)
	}

	node.IsEnd = true
}


/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	node := this.searchPrefix(word)
	if node != nil && node.IsEnd{
		return true
	}else {
		return false
	}
}


/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	node := this.searchPrefix(prefix)
	if node == nil{
		return false
	}

	return true
}

func (this* Trie)searchPrefix(prefix string)*TrieNode{
	node := this.root
	for i:=0; i<len(prefix); i++{
		if !node.ContainKey(prefix[i]){
			return nil
		}else {
			node = node.get(prefix[i])
		}
	}

	return node
}

type TrieNode struct {
	links [26]*TrieNode
	IsEnd bool
}

func NewTrieNode()*TrieNode{
	node := &TrieNode{}
	node.links = [26]*TrieNode{}
	node.IsEnd = false

	return node
}

func (this* TrieNode)ContainKey(ch byte)bool{
	return this.links[ch - 'a'] != nil
}

func (this* TrieNode)get(ch byte)*TrieNode{
	return this.links[ch - 'a']
}

func (this* TrieNode)put(ch byte, node *TrieNode){
	this.links[ch-'a'] = node
}

