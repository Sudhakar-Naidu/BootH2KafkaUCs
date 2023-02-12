### Step-1  : Setting-Up Kafka

* [download kafka](https://kafka.apache.org/downloads)
* [download offset explorer to view kafka message](https://www.kafkatool.com/)

### Step-2  : Extract the zip and run the below commands

    bin/zookeeper-server-start.sh config/zookeeper.properties
    bin/kafka-server-start.sh config/server.properties

### Step-3  : Run the BootH2KafkaUCs Application

I. Publish/Create messages into UpStream topic using (Here I am publishing 5 messages):

[UpStream_Topic_Publish URL](http://localhost:8080/upstream/publish/5/)

II. All the above published messages would be consumed and also persisted into H2 Database

### Step-4  : Accessing H2 Database

* [H2 Console URL](http://localhost:8080/h2-console)

  username : sa password : bootH2

### Step-5  : Verify Data

    I. from H2 Console
    II. from Kafka Offset Explorer

### Step-6  : Read a message from Database and modify & Publish to DownStream Topic

    I. Pick an orderId from H2 ORDERS_TBL table (here I picked an orderId 2)

[DownStream_Topic Publish_URL](http://localhost:8080/downstream/publish/2)

    II. If an orderId doesn't exist, you would be presented "Order Doesn't Exist" message
    III. Vefiry message existance from Offset Explores (follow Step-5 and Step-1)