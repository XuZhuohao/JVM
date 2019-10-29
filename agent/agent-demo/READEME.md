## 1. premain 方式

### 1.1 启动命令
#### 1.1.1 cmd
```cmd
javac com/yui/study/jvm/agent/demo/HelloWorld.java
java -javaagent:myagent.jar helloworld.HelloWorld
```  
#### 1.1.1 idea 
- Edit Configurations > Application > AgentDemoApplication > VM options 添加下述命令 
```text
-javaagent:agent-premain.jar
```
- agent-premain.jar 放到 Working directory (VM options 下面配置的)下
```text
默认在项目的 root 目录下(当前项目的jvm目录，最外层)
```

## 2. agentmain 方式