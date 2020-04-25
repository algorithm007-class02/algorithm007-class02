package homework

type Point struct {
	x int
	y int
}

func robotSim(commands []int, obstacles [][]int) int {
	obstacleSet := newHashSet()
	for i := 0; i < len(obstacles); i++ {
		obstacle := Point{obstacles[i][0], obstacles[i][1]}
		obstacleSet.Insert(obstacle)
	}

	deltaX := []int{0, 1, 0, -1}
	deltaY := []int{1, 0, -1, 0}
	deltaIndex := 0

	curPos := Point{}

	maxDist := 0

	for i := 0; i < len(commands); i++ {
		if commands[i] == -1 {
			deltaIndex = (deltaIndex + 1) % 4
		} else if commands[i] == -2 {
			deltaIndex = (deltaIndex + 3) % 4
		} else {
			for j := 0; j < commands[i]; j++ {
				nextPos := Point{curPos.x + deltaX[deltaIndex], curPos.y + deltaY[deltaIndex]}
				if obstacleSet.Contains(nextPos) {
					break
				}

				curPos = nextPos

				dist := curPos.x*curPos.x + curPos.y*curPos.y
				if dist>maxDist{
					maxDist = dist
				}
			}
		}
	}

	return maxDist
}

type hashset struct {
	data map[interface{}]interface{}
}

func newHashSet()*hashset{
	set := &hashset{}
	set.data = make(map[interface{}]interface{})
	return set
}

func (this* hashset)Contains(key interface{})bool{
	_,ok := this.data[key]
	return ok
}

func (this* hashset)Insert(key interface{}){
	this.data[key] = nil
}

func (this* hashset)Remove(key interface{}){
	delete(this.data, key)
}
