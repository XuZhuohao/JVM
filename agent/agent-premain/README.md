
## 1.编译
### 1.1 手动添加清单
>javac com/yui/study/jvm/agent/service/AgentPremainApplication.java

>jar cvmf manifest.txt agent-premain.jar com/  
**manifest.txt**
```text
Premain-Class: com.yui.study.jvm.agent.service.AgentPremainApplication

```

