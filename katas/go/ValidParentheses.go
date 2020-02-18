package main

import (
	"fmt"
	"regexp"
	"strings"
)

func main() {
	fmt.Println(ValidParentheses("()"))
	fmt.Println(ValidParentheses(")(()))"))
	fmt.Println(ValidParentheses("("))
	fmt.Println(ValidParentheses("(())((()())())"))
}

func ValidParentheses(parens string) bool {
	parentheses, re, stack := strings.Split(strings.ReplaceAll(parens, " ", ""), ""), regexp.MustCompile("[\\[\\{\\(]"), []string{}
	pairs := map[string]string{"[": "]", "{": "}", "(": ")"}
	for _, letter := range parentheses {
		if re.MatchString(letter) {
			stack = append(stack, letter)
		} else {
			if len(stack) == 0 || letter != pairs[stack[len(stack)-1]] {
				return false
			}
			stack = stack[:len(stack)-1]
		}
	}
	return len(stack) == 0
}
