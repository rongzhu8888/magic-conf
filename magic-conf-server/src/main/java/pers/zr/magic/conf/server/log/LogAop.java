package pers.zr.magic.conf.server.log;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * <p>
 *     该类用户统一打印api(rpc,rest)层日志的,包括输入输出和执行时间<br>
 *     通过zabbix按一定规则进行监控预警(如api执行时间超过10s)
 * <p/>
 *  使用方法：表达式里配置你需要拦截的类和方法
 * =========================================================
 * <bean id="apiLogAop" class="com.hengda.hdb.common.log.LogAop"></bean>
 *
 * <aop:config> <aop:aspect ref="apiServiceLogAop"> <aop:around method="doMonitor" pointcut=
 * "execution(* com.hengda.hdb.core.facade.impl.*.*FacadeImpl*.*(..))"/> </aop:aspect> </aop:config>
 * =========================================================
 */

public class LogAop {

    private Logger log = LogManager.getLogger(LogAop.class);

    public Object doMonitor(ProceedingJoinPoint pjp) {
        StringBuffer className = new StringBuffer(" ");
        StringBuffer methodName = new StringBuffer(" ");
        StringBuffer paramStr = new StringBuffer(" ");
        getJointPointInfo(pjp, className, methodName, paramStr);

        String resultStr = null;
        Long start = System.currentTimeMillis();
        long end = 0L;
        try {
            Object result = pjp.proceed();
            end = System.currentTimeMillis();
            resultStr = JSON.toJSONString(result);
            return result;
        } catch (Throwable t) {
            throw new RuntimeException(t);
        } finally {
            if (end == 0) {
                end = System.currentTimeMillis();
            }

            log.info("invoke service=" + className + "." + methodName + ",params=["
                    + paramStr + "],result=[" + resultStr + "]"
                    + ",use time=" + (end - start) + "ms");
        }
    }

    private void getJointPointInfo(ProceedingJoinPoint pjp, StringBuffer className, StringBuffer methodName, StringBuffer paramStr){
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        className.append( method.getDeclaringClass().getName());

        methodName.append(method.getName());
        Object[] params = pjp.getArgs();
        int length = 0;
        if (params != null) {
            length = params.length;
        }

        for (int i = 0; i < length; i++) { // 组装打印参数
            paramStr.append(JSON.toJSONString(params[i])).append("|");
        }
    }
}
