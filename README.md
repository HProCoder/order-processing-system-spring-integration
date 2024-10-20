### Spring integration

In this tutorial we will learn how to use spring integration.
espacialy transformers and routers.

Let have the following example : 

we will upload a csv file that will contains many orders with two diffent types:
- purchase
- rental

we will transform data of given csv file to an object with transformer
then use router to send request to specific channel for example when type of order is purchase
we will redirect request to purchase channel otherwise to rental channel.