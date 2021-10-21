# java_mqtt_test
Testing Java Spring Integration MQTT 

# Problem Synopsis
SetUserName() and SetPassword() doesn't take effect.  Always default to user "guest" and password "guest".  

# How to reproduce the problem
## Clone this repository
```
git clone https://github.com/wuujiann/java_mqtt_test.git
```

## Start MQTT Server
```
cd java_mqtt_test/rabbitmq
docker-compose up -d  # This should start the MQTT server
```

## Remove guest user from the rabbitmq
1. Goto http://localhost:15672
2. Login as client1, password client1
3. Click "Admin" tab
4. Click "guest" user
5. Scroll down to bottom and click `Delete`

## Run the Java program
5. cd the java project folder (java_mqtt_test)
6. Type `code . `  # Open the java project in Visual Studio Code
7. Click "Run" -> "Run without debugging"
8. The following error will be reported:
```
org.eclipse.paho.client.mqttv3.MqttSecurityException: Bad user name or password
```

## Recreate guest user in RabbitMQ server, and the error goes away
1. Goto http://localhost:15672
2. Login as client1, password client1
3. Click __Admin__ tab
4. Under __Add a user__, enter guest as Username, and guest as Password
5. Click __Add User__
6. Click __guest__ user
7. Click __Set permission__

## Re-run the Java program, and the error goes away
5. cd the java project folder (java_mqtt_test)
6. Type `code . `  # Open the java project in Visual Studio Code
7. Click "Run" -> "Run without debugging"
8. No more errors

## Check the connected user in RabbitMQ management console
1. Goto http://localhost:15672
2. Click __Connections__ tab
3. You'll notice that the logged in __User name__ listed is __guest__, even though the username specified in application.yml is client1

