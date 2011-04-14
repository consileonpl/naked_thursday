## Task

Create 100000 threads which displays "Hello world" and sleep for 1
second. Measure the execution time in order to verify total cost of
threads creation.

## Results

### Ruby example
To run the example call the following in console:

    ruby threads.rb

Running example on 100000 elements hanged up my PC _(ruby 1.8.7 patch 72)_, when limited to 10000 threads it runs in 16 seconds.

### Erlang version - both cases (compiled vs interpreted as escript)

Running interpreded version via escript (uncommend first line for this test)

    $./processes.erl
    Process spawn time = 22961 ms
    Bye!
    ...

Running comiled version

    $erl +P 200000
    1> c(processes).
    ok
    2> processes:main([]).
    Process spawn time = 740 ms
    ok
    Bye!
    ...

So ... Interpreted erlang via escript (not compiled) is slower than compiled version (what is obvious)... and is as slow as java (compiled ... what is also obvoius ;) which using native threads.

Erlang tests was runned on:

    MacBook White 2.1 GHz Core 2 Duo / 4GB / MacOSX 10.6.7

Erlang version:

    Erlang R14B02 (erts-5.8.3) [source] [64-bit] [smp:2:2] [rq:2] [async-threads:0] [hipe] [kernel-poll:false]

### Java example

Compiling:

    $ javac Threads.java

Executing:

    $ java Threads

Takes ~40 seconds on my machine.

### C example

Compiling:

    $ gcc -Wall -lpthread threads.c -o threads

Executing:

    $ ./threads

Takes 2 seconds on my machine.

## Results 2

Results on i7 950, 3.07 GHZ, 6GB RAM

 * C - 0m0.681s
 * Java (1.6) - 0m32.061s
 * Python - 0m49.133s
 * Ruby (1.9.2) - 2m25.393s and cause exception: ``threads.rb:4:in `initialize': can't create Thread (11) (ThreadError)``
