2017年决定还是把自己所学的东西写到github上,现在试一下本地拉去最新版的网页内容。

git 的用法 

先创建ssh的成双的密钥 ，一个是公开的一个是私密的
id_rsa是私钥，不能泄露出去，id_rsa.pub是公钥

ssh-keygen -t rsa -C "youremail@example.com"

将id_rsa.pub设置进个人主页里面以后帐号可以识别本台设备了


本地上传文件
git add 文件
 
git commit 文件

远程上传文件


给远程项目创建别名
 git remote add designpatten git@github.com:JackWuChengHao/-.git

远程的master与本地文件关联
git push -u designpatten master


以后本地上传直接

但也需要先add 
在 commit -m "说明"

git push designpatten master

从远程拉取使用

git pull designpatten master
