package th.co.acc.dwi.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import th.co.acc.dwi.model.ServiceException;

public class BeanUtils {

	public static boolean isEmpty(String st){
		boolean b = true;
		if(st!=null && st.trim().length()>0){
			b = false;
		}
		return (b);

	}

	public static boolean isEmpty(StringBuilder st){
		boolean b = true;
		if(st!=null && st.toString().trim().length()>0){
			b = false;
		}
		return (b);

	}

	public static boolean isEmpty(List<?> ls ){
		boolean b = true;
		if(ls!=null && !ls.isEmpty()){
			b = false;
		}
		return (b);

	}

	public static boolean isEmpty(Map<?, ?> map){
		boolean b = true;
		if(map!=null && !map.isEmpty()){
			b = false;
		}
		return(b);
	}

	public static boolean isEmpty(Set<?> set){
		boolean b = true;
		if(set!=null && !set.isEmpty()){
			b = false;
		}
		return(b);
	}
	
	public static boolean isEmpty(Integer integer){
		boolean b = isNull(integer);
		return (b);

	}

	public static boolean isEmpty(Byte byt){
		boolean b = isNull(byt);
		return (b);

	}

	public static boolean isEmpty(Short s){
		boolean b = isNull(s);
		return (b);

	}

	public static boolean isEmpty(Long l){
		boolean b = isNull(l);
		return (b);

	}

	public static boolean isEmpty(Character c){
		boolean b = isNull(c);
		return (b);

	}

	public static boolean isEmpty(Float f){
		boolean b = isNull(f);
		return (b);

	}

	public static boolean isEmpty(Double d){
		boolean b = isNull(d);
		return (b);

	}

	public static boolean isEmpty(Number num){
		boolean b = isNull(num);
		return (b);

	}

	public static boolean isEmpty(BigDecimal d){
		boolean b = isNull(d);
		return (b);

	}

	public static boolean isNull(Object obj){
		boolean b = true;
		if(obj != null){
			b = false;
		}
		return (b);
	}

	public static Object getDefaultValueIfNull(Object value, Object defaultValue){
		Object result = defaultValue;
		if(value != null){
			result = value;
		}
		return(result);
	}

	public static boolean isNotEmpty(String st){
		boolean b = true;
		if(st ==null || st.trim().length()==0){
			b = false;
		}
		return (b);

	}

	public static boolean isNotEmpty(List<?> ls ){
		boolean b = false;
		if(ls!=null && !ls.isEmpty()){
			b = true;
		}
		return (b);

	}

	public static boolean isNotEmpty(Map<?,?> map){
		boolean b = false;
		if(map!=null && !map.isEmpty()){
			b = true;
		}
		return(b);
	}

	public static boolean isNotEmpty(Set<?> set){
		boolean b = false;
		if(set!=null && !set.isEmpty()){
			b = true;
		}
		return(b);
	}
	
	public static boolean isNotEmpty(Integer integer){
		boolean b = isNotNull(integer);
		return (b);

	}

	public static boolean isNotEmpty(Byte byt){
		boolean b = isNotNull(byt);
		return (b);

	}

	public static boolean isNotEmpty(Short s){
		boolean b = isNotNull(s);
		return (b);

	}

	public static boolean isNotEmpty(Long l){
		boolean b = isNotNull(l);
		return (b);

	}

	public static boolean isNotEmpty(Character c){
		boolean b = isNotNull(c);
		return (b);

	}

	public static boolean isNotEmpty(Float f){
		boolean b = isNotNull(f);
		return (b);

	}

	public static boolean isNotEmpty(Double d){
		boolean b = isNotNull(d);
		return (b);

	}

	public static boolean isNotEmpty(Number num){
		boolean b = isNotNull(num);
		return (b);

	}

	public static boolean isNotEmpty(BigDecimal d){
		boolean b = isNotNull(d);
		return (b);

	}

	public static boolean isNotEmpty(Object obj){
		boolean b = false;
		if(obj != null){
			b = true;
		}
		return (b);
	}

	public static boolean isNotNull(Object obj){
		boolean b = false;
		if(obj != null){
			b = true;
		}
		return (b);
	}
	
	public static Map<String, Object> convertBeanToMap(Object bean, List<String> excludeProperties) {
		Map<String, Object> map = new HashMap<String, Object>();
		PropertyDescriptor[] propertyDescriptors = org.springframework.beans.BeanUtils.getPropertyDescriptors(bean.getClass());
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			
			if ((BeanUtils.isEmpty(excludeProperties))
					|| (BeanUtils.isNotEmpty(excludeProperties) 
							&& !excludeProperties.contains(propertyDescriptor.getName()))) {
				
				Method method = propertyDescriptor.getReadMethod();
				if (BeanUtils.isNotNull(method)) {
					try {
						Object object = method.invoke(bean);
						map.put(propertyDescriptor.getName(), object);
					} catch (IllegalArgumentException e) {
						try {
							throw ServiceException.get500SystemError(e);
						} catch (ServiceException e1) {
							e1.printStackTrace();
						}
					} catch (IllegalAccessException e) {
						try {
							throw ServiceException.get500SystemError(e);
						} catch (ServiceException e1) {
							e1.printStackTrace();
						}
					} catch (InvocationTargetException e) {
						try {
							throw ServiceException.get500SystemError(e);
						} catch (ServiceException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		}
		return map;
	}
	
	public synchronized static void convertResultSetToList(final ResultSet rs , final List<Map<String,String>> result) throws SQLException{
		if (BeanUtils.isNotNull(rs)) {
			final ResultSetMetaData rsmd = rs.getMetaData();
			final int columnCount = rsmd.getColumnCount();
			Map<String,String> row;
			while (rs.next()) {
				row = new HashMap<String,String>();
				for (int i = 1 ; i < columnCount + 1 ; i++) {
					row.put(rsmd.getColumnLabel(i), rs.getString(i));
				}
				result.add(row);
			}
			rs.close();
		};
	}
	
}
