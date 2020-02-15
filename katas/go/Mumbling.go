package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(Accum("ZpglnRxqenU"))
	fmt.Println(Accum("NyffsGeyylB"))
	fmt.Println(Accum("MjtkuBovqrU"))
	fmt.Println(Accum("EvidjUnokmM"))
	fmt.Println(Accum("HbideVbxncC"))
}

func Accum(s string) string {
	splitted, mumbString := strings.Split(strings.ToLower(s), ""), ""
	for index, letter := range splitted {
		mumbString += strings.ToUpper(letter) + strings.Repeat(letter, index) + "-"
	}
	return strings.Trim(mumbString, "-")
}
