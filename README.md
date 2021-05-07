# Stack Implementation In JAVA

### Project Structure
     stack-impl        - project root
     +-- src/main/java/com/stack             - Contains all java classes related to Stack.
     |     +- controller.xml                 - Contains rest controller.
     |     +-- exception                     - Contains custom exception for throwing 400 in case of empty stack.
     |     +-- mapper                        - For mapping integer response to json model.
     |     +-- model                         - Contains StackNode.
     |     +-- service                       - Contains StackService.
     |     +-- stack/impl                    - Contains Stack impl with Generic data type & linked list and Array.
     |     +-- rep                           - Contains response model

### Stack Implementation Overview

Stack can be implemented in two ways, one with LinkedList and with array. There is no better or worse approach to implement a stack but they have different advantages.

Implementation based on linked list gives you more flexibility over the container's capacity since you can theoretically always add more elements to it. Array based stack is more limited in terms of capacity. Linked list implicate more space overhead though, as you need to store references to other nodes.

### How To Run Program

Download the source code. Go to project folder and run below commands.
`docker build -t stack-excercise .`
You may need to use `sudo` if you are using linux or fedora and don't have access to docker sock.
Once above command is done you have your docker image then you need to run this image but command below.
`sudo docker run -it stack-excercise`

### API Details
I have exposed 3 APIs for this as below
POST : `http:IP/push/{intdata}`

GET : `http:IP/peek`

DELETE : `http:IP/pop`

If you are running program directly please use `localhost:8080` in place of IP in above APIs.
If you are running this example with docker file please use `172.17.0.2:8080` in place of IP. `172.17.0.2` is default IP by docker but in your it might be different.

