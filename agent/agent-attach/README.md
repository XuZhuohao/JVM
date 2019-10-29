## 1.说明
### 1.1 agent-tool
agent 到 demo，具体操作的地方

### 1.2 agent-api
使 agent-tool 能附着到对应的进程上面去

## 2. 使用
- 编译 agent-tool，并复制 jar 位置
- 启动 agent-demo
- 修改 agent-api 对应参数
    - agentJarPath: agent-tool jar 包位置
    - targetPid: agent-demo 的进程 pid 号，可以使用 jps 查看
- 启动 agent-api.AgentApiApplication
