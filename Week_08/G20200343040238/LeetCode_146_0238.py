# Lru_cache实现：
#   双端队列 + 哈希表


class DoubleLinkNode:
    def __init__(self, key=0, value=0):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None


class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.size = 0
        self.cache = {}
        self.head, self.tail = DoubleLinkNode(), DoubleLinkNode()
        self.head.next = self.tail
        self.tail.prev = self.head

    def add_node(self, node: DoubleLinkNode) -> None:
        next_node = self.head.next
        node.next, node.prev = next_node, self.head
        self.head.next, next_node.prev = node, node

    def remove_node(self, node: DoubleLinkNode) -> None:
        prev_node, next_node = node.prev, node.next
        prev_node.next, next_node.prev = next_node, prev_node

    def remove_to_head(self, node) -> None:
        self.remove_node(node)
        self.add_node(node)

    def pop_node(self) -> None:
        last_node = self.tail.prev
        self.remove_node(last_node)
        del self.cache[last_node.key]
        self.size -= 1

    def get(self, key: int) -> int:
        node = self.cache.get(key)
        if not node:
            return -1
        self.remove_to_head(node)
        return node.value

    def put(self, key: int, value: int) -> None:
        node = self.cache.get(key)
        if node:
            node.value = value
            self.remove_to_head(node)
            return
        link_node = DoubleLinkNode(key, value)
        if self.size >= self.capacity:
            self.pop_node()
        self.cache[key] = link_node
        self.size += 1
        self.add_node(link_node)
