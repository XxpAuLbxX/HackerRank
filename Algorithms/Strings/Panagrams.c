#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <ctype.h>

int main() {
    char s[1001]; // max length +1 for string termination
    int alpha[26] = {0}, comp;
    fgets(s, 1001, stdin);
    // Loops until end of string
    for(int i = 0; s[i] != '\0'; i++) {
        comp = (int)tolower(s[i]); // converted to lower case and casted to int
        if(comp >= 97 && comp <= 122) {
            alpha[comp - 97] = 1;
        }
    }
    // loop from lowercase a to z
    for(int i = 0; i < 26; i++) { 
         if(alpha[i] != 1) {
             printf("not pangram");
             return 0;
         }
    }
    printf("pangram");
    return 0;
}