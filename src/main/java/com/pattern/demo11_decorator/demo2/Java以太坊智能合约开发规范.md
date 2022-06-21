# 序言

> JUICE是一个区块链应用开发平台，基于JUICE构建的网络和智能合约语言，我们可以实现各种各样的分布式应用（DApp）。
JUICE v1.5.0支持基于Java语言版本的智能合约，使开发者能够快速、高效地完成智能合约编写。
目前版本为技术预览版，开发Java智能合约仍有诸多限制和需要遵循的规范，我们会在后续版本不断完善更新。

    当前版本：
    v1.5.0
    1、合约类必须实现java.io.Serializable接口，类中应规范使用类注解，各类方法注解(详见java智能合约开发规范说明)。
    2、合约类中暂不支持引用第三方jar包。
    3、合约对外提供的接口方法的形参类型及返回类型暂时只支持java基本数据类型以及String。
    
    后续版本规划：
    v1.5.1
    1、支持跨合约调用
    v1.6.x
    1、支持jar包

# 智能合约注解使用说明

## 注解使用规范
>Juice区块链平台提供的Java智能合约对外提供的接口类型分为**交易**和**查询**两种，以及其他**非合约接口**。默认情况下所有的接口都是**非合约接口**（*不能直接访问*, *不能修改区块链数据*），保证Java智能合约的编程是面向合约接口的编程。Juice区块链系统提供两类注解， 包括： 合约类型注解，接口类型注解。

### 合约类型注解
>@Contract，表示当前java类是否为智能合约，不添加此注解的java类则当作普通的java类来处理，普通的java类不支持以下接口类型的注解。

### 接口类型注解
>@Transaction，定义为交易型接口注解，即调用了这个接口会发送交易并改变区块链数据， 该类型接口建议不需要返回值！
* * * * *
>@Call，定义为非交易类型注解，与@Transaction不同，它需要返回结果值，但是接口不会产生区块链交易、不会改变区块链数据，用户需要获取数据必须通过此类注解接口！

# 智能合约开发规范说明

### 合约类
> 1 . 必须使用开发SDK提供的@Contract注解
```
例如：
@Contract
public class ExampleContract
```
> 2 . 必须实现java.io的序列化接口
```
例如：
public class ExampleContract implements Serializable
```
> 3 . 不可依赖JDK以外的第三方JAR包
```
例如：不支持在智能合约的java类里面使用import语句
import org.springframework.stereotype.Controller;
```
> 4 . 可依赖和合约类相同编译目录的外部类，使用@Contract注解的imports字段注明依赖的包名+类名
```
例如：
@Contract(imports = {"test.contract.ContractImport"})
public class ExampleContract
```
> 5 . 必须保留一个无参数构造方法
```
例如:
public ExampleContract() {

}
```

### 合约方法
> 1 . 合约方法必须使用@Transaction(写方法)或@Call(读方法)注解
```
例如：
@Transaction
public void setX(String a)

@Call
public String getX()
```
> 2 . 合约方法权限必须为public
```
例如：
@Transaction
public void setX(String a)
```
> 3 . 使用@Call(读方法)注解的合约方法必须有返回值
```
例如：
@Call
public String getX()
```
> 4 . 保持方法执行过程幂等性
```
例如：不支持结果随每次调用变化的方法
long dateTime = new java.util.Date().getTime();
long currentTime = System.currentTimeMillis();
int random = new java.util.Random().nextInt();
```

### 合约环境变量
> 使用com.juice.core.Ethereum类
```
package test.contract;

import java.io.Serializable;

import com.juice.core.Contract;
import com.juice.core.Ethereum;

@Contract
public class ExampleContract implements Serializable {
    
    private static final long serialVersionUID = -5545651580279995957L;
    
    public void constant() {
        // 区块号
        int number = Ethereum.getBlockNumber();
        // 区块hash
        String hash = Ethereum.getBlockHash(number);
        // 直接发送方地址
        String address = Ethereum.getSender();
        // 最初发送方地址
        String origin = Ethereum.getOrigin();
        // 当前块时间戳
        int now = Ethereum.getNow();
    }
    
}
```


# 智能合约开发示例

> Java智能合约示例

```
package test.contract;

import java.io.Serializable;

import com.juice.core.Call;
import com.juice.core.Contract;
import com.juice.core.Transaction;

/**
 * 每个合约类必须使用开发SDK提供的@Contract注解标明该类为合约类 
 * 合约类必须实现java.io的序列化接口
 * 合约方法使用@Transaction(写方法)或@Call(读方法)标明该方法为合约执行方法
 */
@Contract
public class ExampleContract implements Serializable {

    private static final long serialVersionUID = -5545651580279995957L;

    private String x;

    /**
     * 合约执行方法必须为public
     * @Transaction为写方法
     * 
     * @param a
     */
    @Transaction
    public void setX(String a) {
        this.x = a;
    }

    /**
     * 合约执行方法必须为public 
     * @Call为读方法
     * 使用@Call(读方法)注解的方法必须有返回值
     * 
     * @return
     */
    @Call
    public String getX() {
        return x;
    }

    /**
     * 非合约方法不能通过合约调用
     * 
     * @return
     */
    public String getName() {
        return "";
    }
}

```

> 生成的合约代理类
```
package test.contract.proxy;

import com.juzix.web3j.abi.datatypes.Function;
import com.juzix.web3j.jvm.JvmData;
import com.juzix.web3j.jvm.MsgTypeEnum;
import com.juzix.web3j.tx.Contract;
import java.lang.Class;
import java.lang.Object;
import java.lang.String;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Future;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

public final class ExampleContractProxy extends Contract {
    private static final JvmData[] datas = new JvmData[] {new JvmData ("0", "test/contract/ExampleContract", "0xcafebabe0000003400270a00050021090004002208002307002407002507002601001073657269616c56657273696f6e5549440100014a01000d436f6e7374616e7456616c756505b309e3451553c1cb010001780100124c6a6176612f6c616e672f537472696e673b0100063c696e69743e010003282956010004436f646501000f4c696e654e756d6265725461626c650100124c6f63616c5661726961626c655461626c650100047468697301001f4c746573742f636f6e74726163742f4578616d706c65436f6e74726163743b01000473657458010015284c6a6176612f6c616e672f537472696e673b29560100016101001952756e74696d6556697369626c65416e6e6f746174696f6e7301002d4c636f6d2f6a757a69782f6a756963652f7574696c2f616e6e6f746174696f6e2f5472616e73616374696f6e3b0100046765745801001428294c6a6176612f6c616e672f537472696e673b0100264c636f6d2f6a757a69782f6a756963652f7574696c2f616e6e6f746174696f6e2f43616c6c3b0100076765744e616d6501000a536f7572636546696c650100144578616d706c65436f6e74726163742e6a61766101002a4c636f6d2f6a757a69782f6a756963652f7574696c2f616e6e6f746174696f6e2f436f6e74726163743b0c000e000f0c000c000d01000001001d746573742f636f6e74726163742f4578616d706c65436f6e74726163740100106a6176612f6c616e672f4f626a6563740100146a6176612f696f2f53657269616c697a61626c65002100040005000100060002001a000700080001000900000002000a0002000c000d000000040001000e000f000100100000002f00010001000000052ab70001b10000000200110000000600010000001000120000000c000100000005001300140000000100150016000200100000003e00020002000000062a2bb50002b10000000200110000000a00020000001e0005001f001200000016000200000006001300140000000000060017000d00010018000000060001001900000001001a001b000200100000002f00010001000000052ab40002b00000000200110000000600010000002a00120000000c0001000000050013001400000018000000060001001c00000001001d001b000100100000002d00010001000000031203b00000000200110000000600010000003300120000000c0001000000030013001400000002001e00000002001f001800000006000100200000")};

    private ExampleContractProxy(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static ExampleContractProxy load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ExampleContractProxy(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Future<ExampleContractProxy> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue) {
        return deployAsync(ExampleContractProxy.class, web3j, credentials, gasPrice, gasLimit, deployData(datas), "", initialValue);
    }

    public Future<TransactionReceipt> setX(String arg0) {
        Function function = new Function(MsgTypeEnum.SENDTRANSACTION, "test/contract/ExampleContract", "setX", "(Ljava/lang/String;)V", Arrays.<Object>asList(arg0), Collections.<Class<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<String> getX() {
        Function function = new Function(MsgTypeEnum.CALL, "test/contract/ExampleContract", "getX", "()Ljava/lang/String;", 
                Arrays.<Object>asList(), 
                Arrays.<Class<?>>asList(String.class));
        return executeCallSingleValueReturnAsync(function);
    }
}
```

> 使用合约代理类部署、加载、调用合约

```
package test.contract;

import java.io.File;
import java.math.BigInteger;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import com.juzix.web3j.protocol.CustomerWeb3j;

import test.contract.proxy.ExampleContractProxy;

public class DApp {

    public static void main(String[] args) throws Exception {
        // web3j客户端
        Web3j web3j = CustomerWeb3j.build(new HttpService("http://node.url"));
        Credentials credentials = WalletUtils.loadCredentials("passwd", new File("key.json"));
        
        BigInteger gasPrice = new BigInteger("");
        BigInteger gasLimit = new BigInteger("");
        BigInteger initialValue = new BigInteger("");

        // 部署合约
        ExampleContractProxy delopy = ExampleContractProxy.deploy(web3j, credentials, gasPrice, gasLimit, initialValue).get();
        // 调用合约
        delopy.setX("1");
        delopy.getX();

        String contractAddress = delopy.getContractAddress();
        // 加载合约
        ExampleContractProxy load = ExampleContractProxy.load(contractAddress, web3j, credentials, gasPrice, gasLimit);
        // 调用合约
        load.setX("2");
        load.getX();
    }

}
```

#DApp开发示例

> 提供基于gradle插件SDK工具包，自动生成合约代理类

#### 1.开发环境准备
> ide(eclipse, idea)
> gradle
> maven
> jdk

####  2.下载相关SDK工具包(安装到本地maven库)
> gradle juice插件: com.juzix.gradle:juice-plugin:1.0
> 合约代理类生成: com.juzix.generator:juice-generator:1.0
> 合约开发SDK: com.juzix.util:juice-util:1.0
> web3j: org.web3j:core:2.1.0

#### 3.新建一个gradle工程
> build.gradle 示例
```
/*
 * 引入gradle juice插件
 */
buildscript {
     repositories {
         mavenLocal()
         mavenCentral()
     }
     dependencies {
         classpath 'com.juzix.gradle:juice-plugin:1.0'
     }
}

apply plugin: 'juice'

repositories {  
    mavenLocal()
    mavenCentral()
}

/*
 * 引入开发SDK包
 */
dependencies {
    compile 'com.juzix.generator:juice-generator:1.0'
}

/*
 * 合约代理类输出路径
 */
juice {
    generateSourcePath = "$rootProject.projectDir/src/main/generate"
}
```

#### 4.执行gradle juice插件生成合约代理类
> 项目路径下执行命令
```
 gradle generateJuiceProxy
```


# C/C++注解校验

>C++层，对JuiceObject类（Java）提供的工具接口能力进行了封装，提供了校验交易类型注解、访问属性注解的接口，可以参考：juzix_annotation.h， 接口如下：
```
/**
@desc check if the method is a Transaction annotaion method
@param className, the full class name, eg. java.lang.String
@param method, the method name
@param methodDesc, the decription of the method signature, eg. int fun(int) whose decription is (I)I
@ret   1 has Transaction annotaion, 0 not has Transation annotation, -1 got error for bad parameters or exception
*/
int checkTransactionMethod(JNIEnv* env, const char* className, const char* method, const char* methodDesc);

/**
@desc check if the method is a Call annotaion method
@param className, the full class name, eg. java.lang.String
@param method, the method name
@param methodDesc, the decription of the method signature, eg. int fun(int) whose decription is (I)I
@ret   1 has Transaction annotaion, 0 not has Transation annotation, -1 got error for bad parameters or exception
*/
int checkCallMethod(JNIEnv* env, const char* className, const char* method, const char* methodDesc);

/**
@desc check if the method has Transaction or Call  annotaion method
@param className, the full class name, eg. java.lang.String
@param method, the method name
@param methodDesc, the decription of the method signature, eg. int fun(int) whose decription is (I)I
@ret   1 has Transaction or Call annotaion, 0 not has Transaction or Call   annotation, -1 got error for bad parameters or exception
*/
int checkAccessibleMethod(JNIEnv* env, const char* className, const char* method, const char* methodDesc);

/**
@desc check if the class is a @Contract annotaion method
@param className, the full class name, eg. java.lang.String
@ret   1 has Contract annotaion, 0 not has Transation annotation, -1 got error for bad parameters or exception
*/
int checkContractClass(JNIEnv* env, const char* className);
```