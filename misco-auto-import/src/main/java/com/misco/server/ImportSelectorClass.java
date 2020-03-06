/**
 * 
 */
package com.misco.server;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author liuwei 配合Import 注释 import 加载此类 按照@configuartion 的方式将外部配置类按照 将@bean
 *         属性加入到spring 容器 ：关键字：全程没有@confiuration ，利用@annotion 的 @import
 *         导入importSeceltro
 */
public class ImportSelectorClass implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//通过配置名称将这个类 
		return new String[] {ExternalConfigImport.class.getName()};
	}

}
