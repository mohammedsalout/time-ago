# Get the time ago with Android app

[![](https://jitpack.io/v/mohammedsalout/time-ago.svg)](https://jitpack.io/#mohammedsalout/time-ago)

![](https://raw.githubusercontent.com/mohammedsalout/time-ago/main/time_ago.png)


This library helps you to get the time in the form ( hour/min/second ago) , and it is easy to use

The first step you need to add on build:gradle(project)

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}


Then implement the library using 

  	dependencies {
	        implementation 'com.github.mohammedsalout:time-ago:Tag'
  	}
    
# Library usage

you can use the library with two input  time as a string or as long 
Example 1 : with String time 

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        String string_time = "2020-12-09T21:03:32.000000Z";
        int server_time_zone = 0;
        AgoTime.getTimeAgo(context, string_time, formatter,server_time_zone);

        // the server millis time zone is the server time zone it will be positive or negative
        // If server zone time is +2 then the he server millis time zone = 2h*60m*60s*10000 =  7200000
        //If server zone time is -2 then the he server millis time zone = -2h*60m*60s*10000 = -7200000

Example 2: usage with time as long  

    int server_time_zone = 0;
    AgoTime.getTimeAgo(context, 1607535180000L , server_time_zone);



       
