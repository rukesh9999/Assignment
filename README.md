# Assignment

Stor URLS API
-------------
This is a RestApi implemented using SpringBoot,Spring rest,spring datajpa

1)This api used to store urls sended by the user or  client
2)used to get the unique key of the url based on url
3)used to get the count of url no. of times it has been accessed
4) get all the list of urls

we can access the rest api by runningit by the following urls

1)http://localhost:8080/storeurl?url=google.com

2)http://localhost:8080/get?url=google.com

3)http://localhost:8080/count?url=google.com

4)http://localhost:8080/list?page=1&size=2

the documentation done by using swagger 

we can see itd documentation by the following url
http://localhost:8080/swagger-ui.html

we used in-memory database h2 inorder to store the data for storeApi, inorder to see  data
http://localhost:8080/h2-console for storeApi

for storeApi_withoutDb i used arraylist to store urls like java in-memory
