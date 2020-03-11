package main

import "fmt"

func main() {
	fmt.Println(Diagonal(20, 3)) //5985
	//fmt.Println(Diagonal(20, 4))   //20349
	//fmt.Println(Diagonal(20, 5))   //54264
	//fmt.Println(Diagonal(20, 15))  //20349
	//fmt.Println(Diagonal(100, 0))  //101
	//fmt.Println(Diagonal(100, 10)) //158940114100040
}

func Diagonal(n, p int) int {
	if p == 0 || p == n {
		return 1
	}
	if p > n-p {
		p = n - p
	}

	return Diagonal(n-1, p-1) + Diagonal(n-1, p)
}
