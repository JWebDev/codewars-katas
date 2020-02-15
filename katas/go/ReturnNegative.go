package main

import "fmt"

func main() {
	fmt.Println(MakeNegative(1))
	fmt.Println(MakeNegative(-5))
	fmt.Println(MakeNegative(0))
}

func MakeNegative(x int) int {
	if x > 0 {
		x = -x
	}
	return x
}
