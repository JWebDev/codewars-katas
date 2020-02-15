package main

import "fmt"

func main() {
	fmt.Println(Solution("world"))
}

func Solution(word string) string {
	reversed := ""
	for i := len(word) - 1; 0 <= i; i-- {
		reversed += string(word[i])
	}
	return reversed
}
