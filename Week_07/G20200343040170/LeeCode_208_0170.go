type Trie struct {
    children map[int]*Trie
    Value string
}


/** Initialize your data structure here. */
func Constructor() Trie {
    t := Trie{}
    t.children = make(map[int]*Trie)
    return t
}


/** Inserts a word into the trie. */
func (this *Trie) Insert(word string)  {
    root := this
    for i := 0; i < len(word); i++ {
        key := int(word[i] - 97)
        if root.children[key] == nil {
            item := new(Trie)
            item.children = make(map[int]*Trie)
            root.children[key] = item
        }
        root = root.children[key]
    }
    root.Value = word
}


/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
    root := this
    for i := 0; i < len(word); i++ {
        key := int(word[i] - 97)
        if root.children[key] == nil {
            return false
        }
        root = root.children[key]
    }
    return root.Value == word 
}


/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
    root := this
    for i := 0; i < len(prefix); i++ {
        key := int(prefix[i] - 97)
        if root.children[key] == nil {
            return false
        }
        root = root.children[key]
    }
    return true
}


/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
 