# Homework For Spring-core
## Task 1

Suppose   you’re   going   to   develop   a   shop   application   to   sellproducts online.  
First,  create  a  package  called task-1  and  put  all  your  code  insidethis  package.  
Then  you  should  create  the Product  POJO  class,which has several properties, such as the product name and price.  
As  there  are  many  types  of  products  in  your  shop,  you  make  theProduct class abstract to extend it for different product subclasses.  
Then you create two product subclasses, Battery and Disc.  
Eachof them has its own properties.To  define  instances  of  a  POJO  class  in  the  Spring  IoC  container,  
you have to create a Java config class with instantiation values.Next,  you  can  write  the  Main  class  to  test  your  products  
byretrieving them from the Spring IoC container.  

## Task 2  
Create  a  new  package  for  this  task  in  your  current  classpath  andgive it the name: task-2  
Now  create  a Delivery  interface  in  this  package  together  withtwo  arbitrary  implementation  for  it  (for  example: RegularDeliveryand ExpressDelivery).    
Your   new   product   class   should   have   aDelivery interface as its dependency.  
Try   to   use @Autowire   annotation   for   wiring   up   deliverydependency  to  your Product  class   
(you  can  choose  between  anyinjection type as we talked during the lecture).  
Once  finished  customizing  your Product  class,  try  to  get  twoinstances of it from Spring container.  
Note that you should ask thecontainer  to  give  you  a Delivery.class  type  of  bean.  Don't  useany specific implementation for asking from container.  
If   you   encountered   any   exception,   try   to   resolve   that   usingapproaches we already talked about. (You remember @Qualifier?or maybe you can use @Primary).  

## Task 3  
In contrast to single configuration class, managing beans and theirautowiring might not seem too straightforward.  
One practice is toinitialize  the  application  context  with  the  location  of  each  configclass:
```java
AnnotationConfigApplicationContextctx=newAnnotationConfigApplicationContext(ConfigA.class,ConfigB.class)
```  
Another alternative is to use @Import annotation. (Google is yourfriend, honey :D)  
Start  by  creating  a  new  package  called task-3.  Then  create  twoseparate config files.  
Declare various beans in each config file andthen try to call the application context inside your main method toretrieve an instance of each bean.  

## Task 4

Create another package called task-4. Then create a ShoppingCartclass inside it.
This class should hold the data for a list of Productitems. 
It should be also able to add items to the list of products aswell  as  list  all  items  in  the  cart.Create  appropriate  configurationclass.  
Call  it ShoppingCartConfig.classOnce  you  do  this,  youcan  define  a Main  class  to  test  the  shopping  cart  by  adding  someproducts  to  it.   
Suppose  there  are  two  customers  navigating  inyour  shop  at  the  same  time.  The  first  one  gets  a  shopping  cart  bythe getBean()  method  and  adds  two  products  to  it.    
Then,  thesecond  customer  also  gets  a  shopping  cart  by  the getBean()method and adds another product to it.  
