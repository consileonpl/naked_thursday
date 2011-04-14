#include <stdio.h>
#include <pthread.h>
#include <time.h>
#include <unistd.h>

void* say_hello(void* arg) {
  printf("Hello world!\n");
  sleep(1);
  return NULL;
}

int main() {
  time_t start = time(NULL);
  int i;
  for (i = 0; i < 100000; i++) {
    pthread_t thread;
    pthread_create(&thread, NULL, say_hello, NULL);
  }
  time_t end = time(NULL);
  printf("Executed in: %d sec", end - start);
  return 0;
}
