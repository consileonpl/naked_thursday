### Task

Create 100000 threads which displays "Hello world" and sleep for 1
second. Measure the execution time in order to verify total costs of
threads creation.

### Ruby example
To run the example call the following in console:

    ruby threads.rb

Running example on 100000 elements hanged up my PC _(ruby 1.8.7 patch 72)_, when limited to 10000 threads it runs in 16 seconds.