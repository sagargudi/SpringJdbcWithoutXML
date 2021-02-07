package com.sagar.Sjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sagar.Sjdbc.Dao.StudentDao;
import com.sagar.Sjdbc.Entity.Student;


/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
    	
      ApplicationContext context= new AnnotationConfigApplicationContext(JdbcConfig.class);    
   StudentDao studentdao=context.getBean("stu",StudentDao.class);
  //create object of student to set values
   //insert
  Student s= new Student();
   s.setId(7);
   s.setName("indra");
   s.setCity("indralok");
   
  int result=studentdao.insert(s);
    
     
       System.out.println("student added "+result);
       
       // update
   Student s1= new Student();
   s1.setName("kishore");
   s1.setCity("Mysore");
   s1.setId(7);
   
   int result1=studentdao.change(s1);
   System.out.println("changed "+result1);
   
   
   //delete
   Student s2= new Student();
   s.setId(2);
   int result11=studentdao.remove(s);
   System.out.println("deleted "+result11);
   
   //fetch one object
   
  Student stu =studentdao.getStudent(4);
   
   System.out.println(stu);
   
   //fetch multiple object
   List<Student> stu1=studentdao.getAllStudent();
   for(Student stud:stu1) {
	   System.out.println(stud);
   }
    }
}
