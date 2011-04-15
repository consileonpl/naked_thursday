require 'thread'

start = Time.now
20000.times do
  Thread.new{
    printf 'Bye!'
    sleep(40000)
  }
  Thread.pass
end
diff = Time.now - start
puts ' --- %d seconds --- ' % diff