package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(FindShort("bitcoin take over the world maybe who knows perhaps"))
	fmt.Println(FindShort("turns out random test cases are easier than writing out basic ones"))
}

func FindShort(s string) int {
	splitted := strings.Split(s, " ")
	first := len(splitted[0])
	for idx := range splitted {
		if first > len(splitted[idx]) {
			first = len(splitted[idx])
		}
	}
	return first
}
