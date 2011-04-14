require 'thread'

(1..100000).each{|i|
  Thread.new{
    sleep(1000)
  }
}