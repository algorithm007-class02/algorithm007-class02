package homework

import "testing"

func Test_isAnagram(t *testing.T){
	s, r := "rat", "car"
	result := isAnagram(s, r)
	if result == true{
		t.Error("expect result is false, but the result is true")
	}

	s = "anagram"
	r = "nagaram"
	result = isAnagram(s, r)
	if result == false{
		t.Error("expect result is true, but the result is false")
	}

}
