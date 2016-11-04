import redis
print ("hello")
redis_host = "168.219.209.55"
redis_port = 6379
_redis = redis.Redis(host=redis_host, port=redis_port) 
# try to do a simple query to confirm connection 141             
_redis.exists('anything')