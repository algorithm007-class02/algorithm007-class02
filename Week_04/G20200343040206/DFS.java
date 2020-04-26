public class DFS {
//    if node in visited:
//        # already visited
//        return
//
//    visited.add(node)
//
//    # process current node
//    # ...# logic here
//    dfs(node.left)
//    dfs(node.right)
}
//
//visited = set()
//def dfs(node, visited):
//    visited.add(node)
//    # process current node here.
//    ...
//    for next_node in node.children():
//        if not next_node in visited:
//            dfs(next_node, visited)
//
//
//def BFS(graph, start, end):
//
//    queue = []
//    queue.append([start])
//    visited.add(start)
//
//    while queue:
//        node = queue.pop()
//        visited.add(node)
//
//        process(node)
//        nodes = generate_related_nodes(node)
//        queue.push(nodes)
//
//    # other processing work
//    ...
//
//visited = set()
//
//def dfs(node, visited):
//    visited.add(node)
//
//    # process current node here.
//    ...
//
//    for next_node in node.children():
//        if not next_node in visited:
//            def(next_node, visited)
//
//left,right=0,len(array)-1
//while left<=right
//    mid = (left+right)/2
//    if array[mid] == target:
//        #find the target!!
//        break or return result
//    else array[mid] < target:
//        left = mid + 1
//    else:
//        right = mid - 1