#!/usr/bin/env python

import threading
import time


def thread():
    print("Hello World")
    time.sleep(1)

t1 = time.time()
for i in range(100000):
    threading.Thread(target=thread).start()
t2 = time.time()

print("Time: {:.1f} seconds".format(t2 - t1))
