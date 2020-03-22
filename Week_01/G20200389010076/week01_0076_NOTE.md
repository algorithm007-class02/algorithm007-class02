##  <center> 学习笔记 </center>

###### 一、下划线
* 单前导下划线：_var
* 单末尾下划线：var_
* 双前导下划线：__var
* 双前导和末尾下划线：&#95;&#95;var&#95;&#95;
* 单下划线：_
> 1. 单前导下划线 _var:
 告知其他程序员,以单个下划线开头的变量或方法仅供内部使用。
 这不是Python强制规定的。 Python不像Java那样在“私有”和“公共”变量之间有很强的区别。
 > 2. 单末尾下划线 var_:
 单个末尾下划线（后缀）是一个约定，用来避免与Python关键字产生命名冲突。如class_
 > 3. 双前导下划线 __var:
 双下划线前缀会导致Python解释器重写属性名称，以避免子类中的命名冲突。
这也叫做名称修饰（name mangling） - 解释器更改变量的名称，以便在类被扩展的时候不容易产生冲突。
```python
class Test:
   def __init__(self):
       self.__baz = 23#会变解释成 _Test__baz ,对象调用__baz会报AttributeError
                        #调用_Test__baz则不会报错
                        #解释器在类中会自动将__baz扩展为_Test__baz
```
> 4. 双前导和双末尾下划线 &#95;var&#95;:
这样的例子有，&#95;&#95;init&#95;&#95;对象构造函数，或&#95;&#95;call&#95;&#95; ,这些dunder方法通常被称为神奇方法 。
最好避免在自己的程序中使用以双下划线（“dunders”）开头和结尾的名称，以避免与将来Python语言的变化产生冲突。

> 5.单下划线 _
有时候单个独立下划线是用作一个名字，来表示某个变量是临时的或无关紧要的。
```python
#使用“_”来表示它只是一个临时值
for _ in range(32):
    print('Hello, World.')
#_作为占位符变量可以派上用场
>>> car = ('red', 'auto', 12, 3812.4)
>>> color, _, _, mileage = car
>>> color
'red'
>>> _
12
#_是大多数Python REPL中的一个特殊变量，它表示由解释器评估的最近一个表达式的结果。
#比如你可以在一个解释器会话中访问先前计算的结果，或者，你是在动态构建多个对象并与它们交互，无需事先给这些对象分配名字：
>>> 20 + 3
23
>>> _
23
>>> list()
[]
>>> _.append(1)
>>> _
[1]
```

###### 二. 提交作业需要使用github、git，把以前学的一点知识捡了起来：

```
    git clone "SSH 或 HTTPS"

    git add .

    git commit -m "备注"

    git reset (commit序列)

    git push

    git pull

    git config --global user.name ""

    git config --global user.email ""

    git log
    
    git status
```




