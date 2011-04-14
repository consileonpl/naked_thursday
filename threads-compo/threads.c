#include <stdio.h>
#include <pthread.h>
#include <time.h>

void* say_hello(void* arg) {
  printf("Hello world!\n");
  return NULL;
}

int main() {
  time_t start = time(NULL);
  int i;
  for (i = 0; i < 100000; i++) {
    pthread_t thread;
    void* status;
    pthread_create(&thread, NULL, say_hello, NULL);
    pthread_join(thread, &status);
  }
  time_t end = time(NULL);
  printf("Executed in: %d sec", end - start);
  return 0;
}
