package homework

func findCircleNum(M [][]int) int {

	peopleNum := len(M)
	unionFind := NewUnionFind(peopleNum)
	for i:=0;i<peopleNum-1 ;i++  {
		for j:=i+1; j<peopleNum; j++ {
			if M[i][j] == 1{
				unionFind.Union(i,j)
			}
		}
	}

	return unionFind.Count()
}

type UnionFind struct{
	parrent []int
	rank []int
	count int
}

func NewUnionFind(n int)*UnionFind{
	this := &UnionFind{}
	this.parrent = make([]int, n)
	this.rank = make([]int, n)
	this.count = n

	for  i:=0; i<n; i++ {
		this.parrent[i] = i
	}
	return this
}

func (this * UnionFind)Find(p int)int {
	for ; p!= this.parrent[p];  {
		this.parrent[p] = this.parrent[this.parrent[p]]
		p = this.parrent[p]
	}

	return p
}

func (this* UnionFind)Union(p, q int){
	rootP := this.Find(p)
	rootQ := this.Find(q)
	if rootP == rootQ {
		return
	}
	if this.rank[rootQ] > this.rank[rootP]{
		this.parrent[rootP]  = rootQ
	}else {
		this.parrent[rootQ] = rootP
		if this.rank[rootP] == this.rank[rootQ]{
			this.rank[rootP]++
		}
	}

	this.count--
}

func (this* UnionFind)Count()int{
	return this.count
}
