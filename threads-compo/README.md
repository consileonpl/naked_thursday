### Task

Create 100000 threads which displays "Hello world" and sleep for 1
second. Measure the execution time in order to verify total costs of
threads creation.

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