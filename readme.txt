本样例代码用于演示在spring dm server中的petstore例子,包括分类的分页列表展示及增加、修改、删除/批量删除、产品的搜索和基于log4j的日志操作。


源代码组织:
	cn.ceopen.sample.petstore                   :PAR 工程
	cn.ceopen.sample.petstore.dao               :dao 工程
	cn.ceopen.sample.petstore.datasource        :数据源 工程
	cn.ceopen.sample.petstore.model             :领域模型 工程
	cn.ceopen.sample.petstore.service           :服务接口 工程
	cn.ceopen.sample.petstore.service.impl      :服务实现 工程
  cn.ceopen.sample.petstore.web               :web 工程
	addition : 附件文件: 离线使用dozerbeanmapping.dtd，请拷贝到spring tool suite安装目录下和dm server的bin目录下
	bundles  ：工程依赖的bundles，请拷贝到spring dm server的repository\bundles\usr目录下
	database : 创建数据库的脚本


使用说明:
  http://localhost:8080/petstore: 程序的入口。
  工程文件最好放在spring tools suite的workspace下，否则PAR的导出有问题。
	sts2.0中对于service-impl-context.xml会报告AOP错误，可以忽略该错误。

