Eureka注册中心： http://localhost:6001/  
预览云端配置文件：http://localhost:6002/hudic-config/dev  
    --hudic.hello: hello I am dev update at 16:52/17:12/17:27  
    --mysql.database: Hudic  
    --mysql.password: root  
    --mysql.username: root  
以json格式读取云端配置：http://localhost:6002/hudic-config-dev.properties  
    --{"name":"hudic-config","profiles":["dev"],"label":null,"version":"5ab1d5a52b99733c5944b99d4dfe250fd4f233a1","state":null,"propertySources":[{"name":"https://github.com/Hudic/Hudic//config-repo/hudic-config-dev.properties","source":{"hudic.hello":"hello I am dev update at 16:52/17:12/17:27","mysql.database":"Hudic","mysql.username":"root","mysql.password":"root"}}]}  
测试本地接口：http://localhost:6102/hello  
    --hello I am dev update at 16:52/17:12/17:27  
