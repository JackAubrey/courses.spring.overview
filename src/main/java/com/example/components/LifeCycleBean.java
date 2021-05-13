/**
 * 
 */
package com.example.components;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author dcividin
 *
 */
@Component
public class LifeCycleBean
		implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {
	
	public LifeCycleBean() {
		System.out.println("## I'm LifeCycleBean constructor");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("## ApplicationContext has been set");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("## BeanFactory has been set");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("## My Bean name is " + name);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("## The LifeCycleBean has been terminated");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("## The LifeCycleBean has its properties set");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("## The Post Construct annotated method has been called");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("## The Pre Destroy annotated method has been called");
	}

	public void beforeInit() {
		System.out.println("-- Before Init -- Called by Custom Bean post Processor");
	}
	
	public void afterInit() {
		System.out.println("-- After Init -- Called by Custom Bean post Processor");
	}
}
