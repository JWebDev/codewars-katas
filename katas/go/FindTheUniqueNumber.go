package main

import (
	"fmt"
)

func main() {
	fmt.Println(FindUniq([]float32{1.0, 1.0, 1.0, 2.0, 1.0, 1.0}))
	fmt.Println(FindUniq([]float32{0, 0, 0.55, 0, 0}))
}

func FindUniq(arr []float32) float32 {
	unique, m := float32(0.0), make(map[float32]int)

	for _, val := range arr {
		if _, ok := m[val]; ok {
			m[val] = m[val] + 1
		} else {
			m[val] = 1
		}
	}
	for key, val := range m {
		if val == 1 {
			unique = key
		}
	}
	return unique
}
