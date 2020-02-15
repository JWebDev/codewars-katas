package main

import "fmt"

func main() {
	fmt.Println(RowSumOddNumbers(1))
	fmt.Println(RowSumOddNumbers(2))
	fmt.Println(RowSumOddNumbers(3))
	fmt.Println(RowSumOddNumbers(4))
	fmt.Println(RowSumOddNumbers(5))
	fmt.Println(RowSumOddNumbers(13))
}

func RowSumOddNumbers(n int) int {
	stepsToSkip, oddNumbers := 0, 0
	for i := 1; i < n; i++ {
		stepsToSkip += i
	}

	for i := 1; stepsToSkip > -n; i += 2 {
		if stepsToSkip--; stepsToSkip < 0 {
			oddNumbers += i
		}
	}
	return oddNumbers
}
