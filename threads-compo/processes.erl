%%#!/usr/bin/env escript
%%
%% Running interpreded version via escript (uncommend first line for this test)
%%
%%     $./processes.erl
%%     Process spawn time = 22961 ms
%%     Bye!
%%     ...
%%
%% Running comiled version
%%
%%     $erl +P 200000
%%     1> c(processes).
%%     ok
%%     2> processes:main([]).
%%     Process spawn time = 740 ms
%%     ok
%%     Bye!
%%     ...
%%
%% So ... Interpreted erlang via escript (not compiled) is slower than compiled version (what is obvious)... and is as slow as java (compiled ... what is also obvoius ;) which using native threads.
%%
%% Erlang tests was runned on:
%%
%%     MacBook White 2.1 GHz Core 2 Duo / 4GB / MacOSX 1.67
%%
%% Erlang version:
%%
%%     Erlang R14B02 (erts-5.8.3) [source] [64-bit] [smp:2:2] [rq:2] [async-threads:0] [hipe] [kernel-poll:false]


-module(processes).
-export([main/1]).

main(_) ->
  statistics(wall_clock),
  for(1, 100000, fun() -> spawn(fun() -> wait() end) end),
  {_, Result} = statistics(wall_clock),
  io:format("Process spawn time = ~p ms~n", [Result]).

wait() ->
  receive
  after 1000 ->
    io:format("Bye!~n"),
    true
  end.

for(To, To, Fun) -> [ Fun() ];
for(From, To, Fun) -> [ Fun() | for(From + 1, To, Fun)].