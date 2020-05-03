class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = {}


    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        tree = self.root
        for w in word:
            tree = tree.setdefault(w,{})
        tree['#'] = '#'


    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        tree = self.root
        for w in word:
            if not w in tree:
                return False
            tree = tree[w]
        if not '#' in tree:
            return False
        return True


    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        tree = self.root
        for w in prefix:
            if not w in tree:
                return False
            tree = tree[w]
        return True
