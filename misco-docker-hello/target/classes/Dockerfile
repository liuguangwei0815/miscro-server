FROM java:8
MAINTAINER liuwei
LABEL Description="我的第一个镜像" Vendor="Open Analytics NV" Version="0.1"
ADD misco-docker-hello.jar /root/misco-docker-hello.jar
#EXPOSE命令只是声明了容器应该打开的端口并没有实际上将它打开!也就是说，如果你不用-p或者-P中指定要映射的端口，你的容器是不会映射端口出去的,这个是暴露在外面的 7047， 容器打算使用什么端口 打算7047
EXPOSE 7047
ENTRYPOINT java -jar /root/misco-docker-hello.jar
