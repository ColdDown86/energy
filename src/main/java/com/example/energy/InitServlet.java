package com.example.energy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "InitServlet", value = "/InitServlet")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ArrayList<Student> studentList=new ArrayList<>();

        //2.循环创建50个学生，每次创建一个学生对象，就放入学生列表对象
        for(int i=0;i<50;i++){
            Student student=new Student();
            int j=20145201+i;
            String s=Integer.toString(j);
            student.setId(s);
            int e=(int)(Math.random()*100);
            student.setEnergy(e);
            studentList.add(student);
        }

        // 计科201 学号从 20145101开始 20145150结束
        // 计科202 学号从 20145201开始 20145250结束
        // 计科203 学号从 20145301开始 20145350结束
        //        能量生成规则，100以内随机正整数

        //3.学生列表对象 放入Session，属性名称为stuList
        HttpSession session =request.getSession();
        session.setAttribute("stuList",studentList);
        //4.在request对象中写入msg属性，属性值为"系统初始化完成"
        request.setAttribute("msg","系统初始化完成");
        //5.请求转发到 energyMessage.jsp页面,该页面中需要写jsp代码显示msg信息
        request.getRequestDispatcher("energyMessage.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
