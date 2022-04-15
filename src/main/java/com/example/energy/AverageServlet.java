package com.example.energy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AverageServlet", value = "/AverageServlet")
public class AverageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.获取session对象
        HttpSession session =request.getSession();
        //2.根据在InitServlet中写入的属性名读取session中保存的对象，赋值给一个Object类型变量
        //3.判断变量是否为null，
        //是null    在request对象中写入msg属性，属性值为"系统未初始化"，请求转发到energyMessage.jsp页面
        //不是null  将变量强制类型转换为 ArrayList<Student> ,复制给变量 stuList
        if(session.getAttribute("stuList")==null){
            request.setAttribute("msg","系统未初始化");
            request.getRequestDispatcher("energyMessage.jsp").forward(request,response);
        }
        ArrayList<Student> stuList=(ArrayList<Student>) session.getAttribute("stuList");
        int sum=0,num=0;
        for (Student stu:stuList) {
            sum =sum+stu.getEnergy();
            num++;
        }
        int avg=sum/num;
        request.setAttribute("average",avg);
        request.getRequestDispatcher("energyAverage.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
