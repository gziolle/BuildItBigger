Build It Bigger
======

This is "Build It Bigger" - part of Udacity's Android Developer Nanodegree.
The purpose of this project was to build an app with multiple flavors that uses multiple libraries and Google Cloud Endpoint.

The project contains four modules:

1. A Java library that provides jokes.
2. A Google Cloud Endpoint (GCE) project that provides those jokes to the Java library.
3. An Android Library containing an activity for displaying jokes.
4. An Android app that fetches jokes from the GCE module and passes them to the Android Library for display. It has paid and free versions.

Instructions
------
This project runs properly on a Android Virtual Device. You first need to run the Endpoint (jokeserver) and then the app. 
If you want to test it using a real device, please follow the instructions below:

1. Create a gradle.properties file inside your user's gradle file. On Windows, this is usually located at: `C:\Users\<username>\.gradle`
2. Edit this file and put the following line: `MyIpAddress="http://IP-ADDRESS:8080/_ah/api/"`
3. Replace the IP-ADDRESS part with the IP address your real device is connected to.
4. Save the file and run jokeserver again.

Libraries
------

This project uses the following library:

[FindBugs Jsr305](https://mvnrepository.com/artifact/com.google.code.findbugs/jsr305)


License
------

> Copyright @2017 Guilherme Ziolle

> Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

> http://www.apache.org/licenses/LICENSE-2.0

> Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
