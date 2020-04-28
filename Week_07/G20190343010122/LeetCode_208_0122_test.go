package homework

import "testing"

func Test_Trie(t *testing.T){
	trieTree := Constructor()
	trieTree.Insert("apple")
	if trieTree.Search("apple") != true {
		t.FailNow()
	}

	if trieTree.Search("app") == true{
		t.FailNow()
	}


	if trieTree.StartsWith("app") != true{
		t.FailNow()
	}


	trieTree.Insert("app")

	if trieTree.Search("app") != true {
		t.FailNow()
	}
}