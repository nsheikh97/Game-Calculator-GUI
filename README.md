# Game-Calculator-GUI
JavaFX implementation of game tools used during board games. (e.g timer, shuffler, dice roller, score keeper)

# Menu



**test.txt**
```sh
http://www.google.com
http://irl.cs.tamu.edu

```
**Shell**
```sh
./hw1p2.exe 1 test.txt

```
### Example Output:

```sh
Opened test.txt with size 47
URL: http://www.google.com
        Parsing URL... host www.google.com, port 80
        Checking host uniqueness...passed
        Doing DNS...done in 4 ms Found 216.58.193.132
        Checking IP uniqueness...passed
        Connecting on robots...done in 16 ms
        Loading...done in 24 ms with 326 bytes
        Verifying Header...status code 200
URL: http://irl.cs.tamu.edu
        Parsing URL... host irl.cs.tamu.edu, port 80
        Checking host uniqueness...passed
        Doing DNS...done in 0 ms Found 128.194.135.72
        Checking IP uniqueness...passed
        Connecting on robots...done in 9 ms
        Loading...done in 18 ms with 155 bytes
        Verifying Header...status code 404
       *Connecting on page...done in 10 ms
        Loading...done in 33 ms with 6885 bytes
        Verifying Header...status code 200
       +Parsing page...done in 0 ms with 11 links
```

## Version:

**1.0** // Currently only supports 1 thread

## Experience
+ Using WinSock2
+ Using recv with dynamic buffer
+ Performing DNS lookup
+ Sending GET and HEAD HTTP requests
