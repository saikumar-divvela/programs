import hashlib


def md5(fname):
    hash_md5 = hashlib.md5()
    with open(fname,"rb") as f:
        for chunk in iter(lambda: f.read(4096),b""):
            hash_md5.update(chunk)
    return hash_md5.hexdigest()



hash1 = md5("process.py")
hash2 = md5("test123.py")
print (hash1==hash2)

