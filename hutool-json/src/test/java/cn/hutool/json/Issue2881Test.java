package cn.hutool.json;

import cn.hutool.core.collection.ListUtil;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhaohui
 * @since 2023/2/8
 */
public class Issue2881Test {

	private static class Student implements Serializable {
		private static final long serialVersionUID = 3977995366389619053L;
		private String name;

		private Integer age;


		public Student(String name, Integer age) {
			this.name = name;
			this.age = age;
		}
	}

	@Test
	public void javaBeanParseJsonTest() {
		List<Student> stuList = new ArrayList<>();
//		stuList.add(new Student("张三", 18));
//		stuList.add(new Student("张四", 19));
//		stuList.add(new Student("张五", 20));
//		stuList.add(new Student("李三", 17));
//		stuList.add(new Student("李四", 16));
//		stuList.add(new Student("李五", 15));

		List<List<Student>> students = new ArrayList<>();
//		students.add(stuList);



		students.add(ListUtil.of(
				new Student("张三", 18),
				new Student("张四", 19),
				new Student("张五", 20)));
		students.add(ListUtil.of(
				new Student("李三", 17),
				new Student("李四", 16),
				new Student("李五", 15)));
		JSON json = JSONUtil.parse(students);
		System.out.println(json.toStringPretty());

	}


}
