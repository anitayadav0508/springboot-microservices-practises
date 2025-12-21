# Q:- what is Mono object and what is Flux Object?
# A:- Mono is used to represent single object. while Flux is used to represent stream of objects.
# Mono: Send request one time and Get response also one time. While in case of Flex send request one time but get response multiple time within set of interval of time.

# Mono:- Suppose client sent httpRequest to RestApi and get one response from api.like: client -> GET /emp/{empid}  -> Rest API -> Get one Response. while In case of Flex when client send a request Rest api send response in every seconds like 1s it send response of api,2s it send response of api,3s it send response of api and so on. Mono is a stream of 0 to 1 elements.Whereas a Flux is a stream of 0 to N elements.
# Refer image Mono_VS_Flex.png

# Q -where we use flex in real life explanation?
# A - Cricket Match Live (where score updated in every minutes).
#  Stock Market (Stock market prizes updated very frequently), they are continuous response and stream  response.

# Mono and Flux working on event driven programming i.e when a client send a request to REST API its not guarantee that we get success every time i.e on Success we execute set of code similar on Error i want to execute some other set of codes it works on event or reactive based.Mono is a single response once you receive the response , you can perform the operation on that object based on the event , you receive the response from api then single response represent as mono , based on event trigger  success or error  set of codes will be executing i.e OnSuccess, OnError
# Netflix streaming video frames, Live stock price updates