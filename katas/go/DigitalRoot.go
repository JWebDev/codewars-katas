package main

import (
	"fmt"
	"strconv"
	"strings"
)

func main() {
	fmt.Println(DigitalRoot(16))
	fmt.Println(DigitalRoot(942))
	fmt.Println(DigitalRoot(132189))
	fmt.Println(DigitalRoot(493193))
}

func DigitalRoot(n int) int {
	if n < 10 {
		return n
	}
	number, sum := strings.Split(strconv.Itoa(n), ""), 0
	for _, digit := range number {
		n, _ := strconv.Atoi(digit)
		sum += n
	}
	return DigitalRoot(sum)
}
