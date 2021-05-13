/**
 * 
 */
package com.example.components;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author dcividin
 *
 */
@Component
public class CustomBeanpostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof LifeCycleBean) {
			((LifeCycleBean)bean).beforeInit();
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof LifeCycleBean) {
			((LifeCycleBean)bean).afterInit();
		}
		return bean;
	}

}
