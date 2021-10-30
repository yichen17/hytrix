package com.onecard.code.config;

import com.onecard.code.tools.*;

import java.io.File;
import java.util.*;

public class CodeGenerator {

	private static Map<String, String> paramsMap = new HashMap<String, String>();
	public static ResourceBundle bundle = null;
	private String ip;
	private String port ;
	private String dbName;
	private String userName;
	private String password;
	private String servicePackage;
	private String mapperPackage;
	private String mpackage;
	private String tableNames;
	//
	private static String databasetype = "mysql";

	private String projectPath = System.getProperty("user.dir");
	private String classPath = projectPath + File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator;
	private String resourcesPath = projectPath +  File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator;

	public CodeGenerator(Builder builder) {
		this.ip = builder.ip;
		this.port = builder.port;
		this.userName = builder.userName;
		this.password = builder.password;
		this.dbName = builder.dbName;
		this.tableNames = builder.tableNames;
		this.mapperPackage = builder.mapperPackage;
		this.servicePackage = builder.servicePackage;
		this.mpackage = builder.mpackage;
	}

	public static class  Builder{

		private String ip;
		private String port;
		private String userName;
		private String password;
		private String dbName;
		private String tableNames;
		private String servicePackage;
		private String mapperPackage;
		private String mpackage;
		public CodeGenerator build(){
			if(isEmpty(this.ip)){
				throw new RuntimeException("必须参数ip不能为空！");
			}
			if(isEmpty(this.port)){
				throw new RuntimeException("必须参数port不能为空！");
			}
			if(isEmpty(this.userName)){
				throw new RuntimeException("必须参数userName不能为空！");
			}
			if(isEmpty(this.password)){
				throw new RuntimeException("必须参数password不能为空！");
			}
			if(isEmpty(this.dbName)){
				throw new RuntimeException("必须参数dbName不能为空！");
			}
			if(isEmpty(this.tableNames)){
				throw new RuntimeException("必须参数tableNames不能为空！");
			}
			return new CodeGenerator(this);
		}
		public Builder ip(String ip){
			this.ip = ip;
			return this;
		}

		public Builder port(String port){
			this.port = port;
			return this;
		}
		public Builder userName(String userName){
			this.userName = userName;
			return this;
		}

		public Builder password(String password){
			this.password = password;
			return this;
		}
		public Builder dbName(String dbName){
			this.dbName = dbName;
			return this;
		}
		public Builder tableNames(String tableNames){
			this.tableNames = tableNames;
			return this;
		}
		public Builder mpackage(String mpackage){
			this.mpackage = mpackage;
			return this;
		}
		public Builder mapperPackage(String mapperPackage){
			this.mapperPackage = mapperPackage;
			return this;
		}
		public Builder servicePackage(String servicePackage){
			this.servicePackage = servicePackage;
			return this;
		}
		private boolean isEmpty(String str){
			if(Objects.isNull(str)||"".equals(str)||"null".equals(str)){
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
		}
	}





	/**
	 * 通过key 获取pwd
	 * 
	 * @param key
	 * @return
	 */
	public static String getVal(String key) {
		return paramsMap.get(key);
	}

	public void run() {
		String[] tableNameArray = tableNames.split(",");
		for (String tableName:tableNameArray){
			System.out.println(tableName);
			Map<String, Object> tableMap = DBMSMetaUtil.selectTable(databasetype, ip, port, dbName, userName, password, tableName);
			List<Map<String, Object>> columns = DBMSMetaUtil.listColumns(databasetype, ip, port, dbName, userName, password, tableName);
			List<Map<String, Object>> pkColumns = DBMSMetaUtil.listPkColumn(databasetype, ip, port, dbName, userName, password, tableName);

			//
			tableMap = MapUtil.convertKey2LowerCase(tableMap);
			columns = MapUtil.convertKeyList2LowerCase(columns);
			pkColumns = MapUtil.convertKeyList2LowerCase(pkColumns);

			String entityPackage = mkdirMapperPackage();
			String xmlPackage = mkXmlDirPackage();
			String entityName = ColumnUtil.getEntityName(tableName);
			String entityRemark = String.valueOf(tableMap.get("remarks"));

			columns = ColumnUtil.mysqlColumnsToJavaColumns(columns);
			Map<String, Object> map = ColumnUtil.columnToMap(columns, entityName, entityRemark, mapperPackage, mpackage);

			FreemarkerUtils hf = new FreemarkerUtils();

			try {
				hf.init(resourcesPath);
				// 生成实体对象
				if (isExistFile(entityPackage + "entity"+File.separator+ entityName + "DO.java")) {
					System.out.println(entityPackage + "entity" +File.separator+ entityName + "DO.java" + "  已经存在");
				} else {
					hf.process(map, entityPackage + "entity"+File.separator, entityName + "DO.java", "pojo.ftl");
				}
				String mapperFilePath = mkdirMapperPackage();
				if (isExistFile(mapperFilePath + "mapper"+File.separator + entityName + "Mapper.java")) {
					System.out.println(mapperFilePath + "mapper"+File.separator + entityName + "Mapper.java 已经存在");
				} else {
					hf.process(map, mapperFilePath + "mapper"+File.separator, entityName + "Mapper.java", "mapper.ftl");
				}
				Map<String, Object> mapperMap = MapperUtil.createMapper(mapperPackage, mpackage, entityName, tableName, columns, pkColumns.get(0));
				if (isExistFile(xmlPackage + "mapper"+File.separator + entityName + "Mapper.xml")) {
					System.out.println(xmlPackage + "mapper" + entityName + "Mapper.xml 已经存在");
				} else {
					hf.process(mapperMap, xmlPackage + "mapper"+File.separator, entityName + "Mapper.xml", "mapperXml.ftl");
				}
				// 生成service
				String serviceFilePath = mkdirServicePackage();
				Map<String, Object> serviceMap = ServiceUtil.createService(servicePackage,mapperPackage, mpackage, entityName, tableName, columns, pkColumns.get(0));
				if (isExistFile(serviceFilePath + "service"+File.separator + entityName + "Service.java")) {
					System.out.println(serviceFilePath + "service"+File.separator + entityName + "Service.java 已经存在");
				} else {
					hf.process(serviceMap, serviceFilePath + "service"+File.separator, entityName + "Service.java", "service.ftl");
				}
				if (isExistFile(serviceFilePath + "service"+File.separator+"impl"+File.separator + entityName + "ServiceImpl.java")) {
					System.out.println(serviceFilePath + "service"+File.separator+"impl"+File.separator + entityName + "ServiceImpl.java 已经存在");
				} else {
					hf.process(serviceMap, serviceFilePath + "service"+File.separator+"impl"+File.separator, entityName + "ServiceImpl.java", "serviceImpl.ftl");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 构建包
	 */
	public String mkdirMapperPackage() {
		String[] baseArrs = mapperPackage.split("\\.");
		String[] mpackageArrs = mpackage.split("\\.");
		String packagePath = classPath;

		if (baseArrs != null) {
			for (String path : baseArrs) {
				packagePath = packagePath + File.separator + path;
			}
		}
		if (mpackageArrs != null) {
			for (String path : mpackageArrs) {
				packagePath = packagePath + File.separator + path;
			}

		}
		packagePath = packagePath + File.separator;
		createDir(packagePath + "entity" + File.separator);
		createDir(packagePath + "mapper" + File.separator);
		return packagePath;

	}

	/**
	 * 构建包
	 */
	public String mkdirServicePackage() {
		String[] baseArrs = servicePackage.split("\\.");
		String[] mpackageArrs = mpackage.split("\\.");
		String packagePath = classPath;

		if (baseArrs != null) {
			for (String path : baseArrs) {
				packagePath = packagePath + File.separator + path;
			}
		}
		if (mpackageArrs != null) {
			for (String path : mpackageArrs) {
				packagePath = packagePath + File.separator + path;
			}

		}
		packagePath = packagePath + File.separator;
		createDir(packagePath + "service" + File.separator);
		createDir(packagePath + "service"+File.separator+"impl" + File.separator);
		return packagePath;

	}

	/**
	 * 构建包
	 */
	public String mkXmlDirPackage() {
		String[] baseArrs = mapperPackage.split("\\.");
		String[] mpackageArrs = mpackage.split("\\.");
		String packagePath = resourcesPath + "conf"+File.separator+"mybatis";

		if (baseArrs != null) {
			for (String path : baseArrs) {
				packagePath = packagePath + File.separator + path;
			}
		}
		if (mpackageArrs != null) {
			for (String path : mpackageArrs) {
				packagePath = packagePath + File.separator + path;
			}

		}
		packagePath = packagePath + File.separator;
		createDir(packagePath + "mapper" + File.separator);
		return packagePath;

	}

	public static boolean isExistFile(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}

	// 创建目录
	public static boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {// 判断目录是否存在
			System.out.println("包名已经存在！[" + destDirName + "]");
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {// 结尾是否以"/"结束
			destDirName = destDirName + File.separator;
		}
		if (dir.mkdirs()) {// 创建目标目录
			System.out.println("创建目录成功！[" + destDirName + "]");
			return true;
		} else {
			System.out.println("创建目录失败！");
			return false;
		}
	}
}
