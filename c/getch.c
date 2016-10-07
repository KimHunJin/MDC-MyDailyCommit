#include <stdio.h>
#include <stdlib.h>

#define CRT_SECURE_NO_WARNINGS

int getch() 
{
  int r;
  unsigned char c;
  if((r==read(0,&c, sizeof(c))) <0) 
  {
	  return r;
  } else {
	  return c;
  }
}

int main() 
{
  printf("getch test\n");
  getch();
}



